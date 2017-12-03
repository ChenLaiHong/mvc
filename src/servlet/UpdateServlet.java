package servlet;

import bean.User;
import service.UserService;
import service.UserServiceImp;
import utils.Choose;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 赖红 on 2017/12/3.
 */
@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       int uid = Integer.parseInt(request.getParameter("uid"));
        UserService userService = new UserServiceImp();
        User user=userService.findUser(uid);
        request.setAttribute("sex", Choose.sex);
        request.setAttribute("preferences", Choose.preferences);
        request.setAttribute("major", Choose.major);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
    }
}
