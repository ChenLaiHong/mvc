package servlet;

import bean.User;
import service.UserService;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 赖红 on 2018/1/3.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String uname = request.getParameter("uname");
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      String password2 = request.getParameter("password2");
      String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
      Pattern p = Pattern.compile(str);
      Matcher m = p.matcher(email);
        if(uname == null || uname==""){
          request.setAttribute("masg","用户名不能为空");
          request.getRequestDispatcher("/index.jsp").forward(request,response);
          return;
      }
        if(m.matches()){
            request.setAttribute("masg","填写正确的邮箱");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }
        if(password == null || password==""){
            request.setAttribute("masg","密码不能为空");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }
        if(!password.equals(password2)){
            request.setAttribute("masg","两次密码不一致");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }
        else {
            UserService userService = new UserServiceImp();
            User user = new User();
            user.setUname(uname);
            user.setPassword(password);
            user.setEmail(email);
            userService.register(user);
            request.getRequestDispatcher("/index.jsp").forward(request,response);

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
