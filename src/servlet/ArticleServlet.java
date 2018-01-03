package servlet;

import bean.Article;
import service.ArticleService;
import service.ArticleServiceImp;
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
 * Created by 赖红 on 2017/12/30.
 */
@WebServlet(name = "ArticleServlet")
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        String articleName = request.getParameter("articleName");
        String article = request.getParameter("article");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String author = (String) request.getSession().getAttribute("name");


        if(articleName=="" ||articleName==null){
            request.setAttribute("mesg","文章标题不能为空");
            doGet(request,response);
            return;
        }
        Article article1 = new Article();
        article1.setArticleName(articleName);
        article1.setArticle(article);
        article1.setTypeId(typeId);
        article1.setAuthor(author);

        ArticleService articleService = new ArticleServiceImp();
        TypeService typeService = new TypeServiceImp();

        articleService.addArticle(article1);
       int articleCount= typeService.find(typeId);
        typeService.addCount(article1.getTypeId(),articleCount);
        request.getRequestDispatcher("/read.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeService typeService = new TypeServiceImp();
        List list = typeService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/add_article.jsp").forward(request, response);
    }
}
