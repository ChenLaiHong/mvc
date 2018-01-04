package servlet;

import service.LifeService;
import service.LifeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 赖红 on 2018/1/4.
 */
@WebServlet(name = "ListLifeServlet")
public class ListLifeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LifeService lifeService = new LifeServiceImp();
        List list = lifeService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/life.jsp").forward(request, response);
    }
}
