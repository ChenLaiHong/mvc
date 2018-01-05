package servlet;

import bean.Article;
import bean.Comment;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        TypeService typeService = new TypeServiceImp();
        CommentService commentService = new CommentServiceImp();
        List list = commentService.findAll(articleId);
        int readCount = articleService.findById(articleId).getReadCount();
        articleService.updateReadNum(readCount,articleId);
        Article article = articleService.findById(articleId);
        String type = typeService.findType(article.getTypeId()).getTypeName();
        request.setAttribute("article",article);
        request.setAttribute("type",type);
        request.setAttribute("commentList",list);
        request.getRequestDispatcher("/article.jsp").forward(request, response);

    }
}
