package servlet;

import service.UserService;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 赖红 on 2017/12/2.
 */
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int uid = Integer.parseInt(request.getParameter("uid"));
            UserService service = new UserServiceImp();
            service.deleteUser(uid);
        }catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("ListUserServlet");
    }
}
