package utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 赖红 on 2017/12/5.
 */
@WebFilter(filterName = "EcondFilter")
public class EcondFilter implements Filter {

    public void destroy() {

        System.out.print("过滤器被销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    HttpServletRequest request =(HttpServletRequest)req;
    HttpServletResponse response = (HttpServletResponse)resp;
     req.setCharacterEncoding("UTF-8");
     resp.setCharacterEncoding("UTF-8");
       System.out.print("ddddddd");
        chain.doFilter(request, response);


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
