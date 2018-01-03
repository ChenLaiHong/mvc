package servlet;

import bean.Type;
import service.TypeService;
import service.TypeServiceImp;
import service.UserService;
import service.UserServiceImp;
import utils.PageBean;
import utils.QueryInfo;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 赖红 on 2017/12/28.
 */
@WebServlet(name = "ArticleTypeServlet")
public class ArticleTypeServlet extends HttpServlet {
    //新增和更新使用
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        String typeName=request.getParameter("typeName");
        int typeId= Integer.parseInt(request.getParameter("typeId"));
        System.out.print("输出："+typeName);
        Type type = new Type();
        TypeService typeService= new TypeServiceImp() ;
        if(typeId !=0){
            typeService.updateType(typeId,typeName);
        }else {
            type.setTypeName(typeName);
            typeService.add_article(type);
        }
        response.sendRedirect("ListTypeServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        TypeService typeService = new TypeServiceImp();
        int typeId = Integer.parseInt(request.getParameter("typeId"));
            Type type = typeService.findType(typeId);
            request.setAttribute("type", type);
            request.getRequestDispatcher("/updateType.jsp").forward(request, response);

    }
}
