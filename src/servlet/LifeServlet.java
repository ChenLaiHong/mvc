package servlet;

import bean.Life;
import bean.User;
import service.LifeService;
import service.LifeServiceImp;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 赖红 on 2018/1/4.
 */
@WebServlet(name = "LifeServlet")
public class LifeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String lifeName = request.getParameter("lifeName");
           String lifeContent = request.getParameter("lifeContent");
           int lifeId = Integer.parseInt(request.getParameter("lifeId"));

           LifeService lifeService = new LifeServiceImp();
           if(lifeId ==0) {
               Life life = new Life();
               life.setLifeName(lifeName);
               life.setLifeContent(lifeContent);
               lifeService.add(life);

           }else {
               Life life= WebUtils.request2Bean(request,Life.class);
               lifeService.updateLife(life);
           }
               response.sendRedirect("ListLifeServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LifeService lifeService = new LifeServiceImp();
        int lifeId = Integer.parseInt(request.getParameter("lifeId"));
        Life life = lifeService.findLife(lifeId);
        request.setAttribute("life",life);
        request.getRequestDispatcher("/updateLife.jsp").forward(request, response);
    }
}
