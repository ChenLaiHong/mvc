package servlet;

import service.UserService;
import service.UserServiceImp;
import utils.PageBean;
import utils.QueryInfo;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
//        request.setCharacterEncoding("utf-8");
         String query = request.getParameter("query");
      request.setAttribute("query",query);
        System.out.print("输入的内容：-----"+query);
         if(query==""||query==null){
             response.sendRedirect("ListUserServlet");
         }else {

             QueryInfo info = WebUtils.request2Bean(request, QueryInfo.class);
             UserService userService = new UserServiceImp();
             PageBean pageBean = userService.pageQueryLike(info,query);
             System.out.print("内容："+pageBean);
             if(userService.pageQueryLike(info,query).getTotalrecord() != 0) {
                 request.setAttribute("queryPage", pageBean);
                 request.getRequestDispatcher("/queryRes.jsp").forward(request, response);
             }else {
                 request.setAttribute("message","没有相应专业的学生！");
                 request.getRequestDispatcher("/loginSuc.jsp").forward(request,response);
             }
         }
    }
}
