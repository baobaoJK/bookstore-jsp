package org.bs.servlet;

import org.bs.dao.UserDao;
import org.bs.pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author KSaMar
 * @version 1.0
 * 登录控制器
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        UserDao userDao = new UserDao();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        // 判断用户名和密码
        if (!username.isEmpty() && !password.isEmpty()) {

            User user = userDao.selectByUsernameAndPassword(username, password);
            if (user.getUsername() != null) {
                session.setAttribute("user", user);
                String url;

                // 判断是普通用户还是管理员用户
                if (username.equals("admin")) {
                    url = "/admin/booklist.jsp";
                } else {
                    url = "/display";
                }
                RequestDispatcher dispatcher = req.getRequestDispatcher(url);
                dispatcher.forward(req, resp);
            } else {
                resp.sendRedirect("/fail.jsp?status=fail");
            }
        } else {
            resp.sendRedirect("/fail.jsp?status=empty");
        }
    }
}
