package org.bs.filter;

import org.bs.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author KSaMar
 * @version 1.0
 * <p>
 * 过滤器
 */
public class Filter extends HttpServlet implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        javax.servlet.Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");

        HttpSession session = ((HttpServletRequest) servletRequest).getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            PrintWriter out = servletResponse.getWriter();
            out.print("您还没有登录！");
            out.print("<a href='/login.jsp'>登录</a>");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
