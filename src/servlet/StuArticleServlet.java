package servlet;

import bean.Article;
import service.ArticleService;
import service.ArticleServiceImp;
import service.TypeService;
import service.TypeServiceImp;
import utils.PageBean;
import utils.QueryInfo;
import utils.WebUtils;

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
@WebServlet(name = "StuArticleServlet")
public class StuArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QueryInfo info = WebUtils.request2Bean(request, QueryInfo.class);
        ArticleService articleService = new ArticleServiceImp();
        PageBean pageBean = articleService.pageQuery(info);
       // List list2 = articleService.getAll();
        request.setAttribute("articles", pageBean);
        request.getRequestDispatcher("/studentArticleList.jsp").forward(request,response);
    }
}
