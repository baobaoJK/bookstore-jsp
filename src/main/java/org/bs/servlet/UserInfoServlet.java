package org.bs.servlet;

import org.bs.dao.UserDao;
import org.bs.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author KSaMar
 * @version 1.0
 */
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String status = req.getParameter("status");

        // 查看用户信息
        if (status.equals("cat")) {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = new UserDao().selectById(id);

            if (user != null) {
                req.setAttribute("user", user);
                resp.sendRedirect("/admin/user.jsp");
            }
        }

        // 删除用户
        if (status.equals("deleteUser")) {
            int id = Integer.parseInt(req.getParameter("id"));
            new UserDao().deleteById(id);
            resp.sendRedirect("/admin/userlist.jsp");
        }

        // 更新用户信息
        if (status.equals("updateUser")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String names = req.getParameter("names");
            String address = req.getParameter("address");
            String phone = req.getParameter("phone");
            String post = req.getParameter("post");
            String email = req.getParameter("email");

            UserDao userDao = new UserDao();
            userDao.updateUserById(id, names, address, phone, post, email);

            HttpSession session = req.getSession();
            session.setAttribute("user", userDao.selectById(id));
            resp.sendRedirect("/user/user.jsp");
        }
        
        // 跳转用户信息页
        if (status.equals("user")) {
            resp.sendRedirect("/user/user.jsp");
        }

        // 退出用户登录
        if (status.equals("signout")) {
            HttpSession session = req.getSession();
            session.invalidate();
            resp.sendRedirect("/login.jsp");
        }
    }
}
