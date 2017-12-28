package servlet;

import bean.Type;
import service.TypeService;
import service.TypeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 赖红 on 2017/12/28.
 */
@WebServlet(name = "ArticleServlet")
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeName=request.getParameter("typeName");
        Type type = new Type();
        TypeService typeService= new TypeServiceImp() ;
        type.setTypeName(typeName);
        typeService.add_article(type);
        request.getRequestDispatcher("/article.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
