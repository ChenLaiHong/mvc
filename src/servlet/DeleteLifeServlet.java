package servlet;

import service.LifeService;
import service.LifeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 赖红 on 2018/1/4.
 */
@WebServlet(name = "DeleteLifeServlet")
public class DeleteLifeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int lifeId = Integer.parseInt(request.getParameter("lifeId"));
        LifeService lifeService = new LifeServiceImp();
        lifeService.deleteLife(lifeId);
        response.sendRedirect("ListLifeServlet");
    }
}
