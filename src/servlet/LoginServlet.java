package servlet;


import bean.User;
import service.UserService;
import service.UserServiceImp;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by 赖红 on 2017/12/2.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService userServer=new UserServiceImp();
        User user=null;
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        if(name==null || "".equals(name)){
            request.setAttribute("msg","用户名不能为空");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }if(pass==null ||"".equals(pass)){
            request.setAttribute("msg","密码不能为空");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else if((user=userServer.find(name,pass))==null){
            request.setAttribute("msg","用户不存在");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else {
            // req.getSession().setAttribute("user", user);
            response.sendRedirect("ListUserServlet");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

       doPost(request, response);


    }
}
