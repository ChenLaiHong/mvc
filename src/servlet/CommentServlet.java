package servlet;

import bean.Article;
import bean.Comment;
import bean.User;
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
@WebServlet(name = "CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String content = request.getParameter("content");
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        CommentService commentService = new CommentServiceImp();
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setContent(content);
        comment.setAuthor(user.getUname());
        commentService.add(comment);
        ArticleService articleService = new ArticleServiceImp();
        int commentCount = articleService.findById(articleId).getCommentCount();
        articleService.updateCommNum(articleId,commentCount);
        TypeService typeService =new TypeServiceImp();
        List list = commentService.findAll(articleId);
        Article article = articleService.findById(articleId);
        String type = typeService.findType(article.getTypeId()).getTypeName();
        request.setAttribute("article",article);
        request.setAttribute("type",type);
        request.setAttribute("commentList",list);
        request.getRequestDispatcher("/article.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
