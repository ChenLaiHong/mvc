package servlet;

import bean.Article;
import service.ArticleService;
import service.ArticleServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 赖红 on 2018/1/5.
 */
@WebServlet(name = "ArticleComServlet")
public class ArticleComServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int articleId = Integer.parseInt(request.getParameter("articleId"));
        ArticleService articleService = new ArticleServiceImp();
        articleService.updateReadNum(articleId);
        Article article = articleService.findById(articleId);
    }
}
