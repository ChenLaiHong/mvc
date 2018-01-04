package servlet;

import service.UserService;
import service.UserServiceImp;
import utils.PageBean;
import utils.QueryInfo;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 赖红 on 2017/12/2.
 */
@WebServlet(name = "ListUserServlet")
public class ListUserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QueryInfo info = WebUtils.request2Bean(req, QueryInfo.class);
        UserService userService = new UserServiceImp();
        PageBean pageBean = userService.pageQuery(info);
        req.setAttribute("pagebean",pageBean);
        req.getRequestDispatcher("/loginSuc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
