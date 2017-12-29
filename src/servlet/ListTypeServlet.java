package servlet;

import service.TypeService;
import service.TypeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 赖红 on 2017/12/29.
 */
@WebServlet(name = "ListTypeServlet")
public class ListTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeService typeService = new TypeServiceImp();
        List list = typeService.getAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.print("集合：" + list);
        }
        request.setAttribute("list", list);
        request.getRequestDispatcher("/articleType.jsp").forward(request, response);
    }
}
