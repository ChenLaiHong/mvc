package servlet;

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

/**
 * Created by 赖红 on 2017/12/8.
 */
@WebServlet(name = "QueryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
         String query = request.getParameter("query");
         System.out.print("输入的内容：-----"+query);
         if(query==""||query==null){
             response.sendRedirect("ListUserServlet");
         }else {
             QueryInfo info = WebUtils.request2Bean(request, QueryInfo.class);
             UserService userService = new UserServiceImp();
             PageBean pageBean = userService.pageQueryLike(info,query);
             request.setAttribute("queryPage",pageBean);
             request.getRequestDispatcher("/queryRes.jsp").forward(request, response);
         }
    }
}
