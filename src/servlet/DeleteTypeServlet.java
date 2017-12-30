package servlet;

import service.TypeService;
import service.TypeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 赖红 on 2017/12/29.
 */
@WebServlet(name = "DeleteTypeServlet")
public class DeleteTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int typeId= Integer.parseInt(request.getParameter("typeId"));
        TypeService typeService = new TypeServiceImp();
        typeService.deleteType(typeId);
        response.sendRedirect("ListTypeServlet");
    }
}
