package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 赖红 on 2018/1/4.
 */
@WebServlet(name = "AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        if(name==null || "".equals(name)){
            request.setAttribute("msg","用户名不能为空");
            request.getRequestDispatcher("/AdminLogin.jsp").forward(request,response);
            return;
        }if(pass==null ||"".equals(pass)){
            request.setAttribute("msg","密码不能为空");
            request.getRequestDispatcher("/AdminLogin.jsp").forward(request,response);
            return;
        }if(name!="admin" || pass !="admin"){
            request.setAttribute("msg","没有此账号");
            request.getRequestDispatcher("/AdminLogin.jsp").forward(request,response);
        }else {
            request.getSession().setAttribute("admin",name);
            request.getRequestDispatcher("/adminIndex.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
