package org.bs.servlet;

import org.bs.dao.UserDao;
import org.bs.pojo.User;

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
 * 注册用户控制器
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        String ipAddress = req.getRemoteAddr().toString();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("repassword");
        String names = req.getParameter("names");
        String sex = req.getParameter("sex");
        String address = req.getParameter("address");
        String post = req.getParameter("post");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNames(names);
        user.setSex(sex);
        user.setAddress(address);
        user.setPhone(phone);
        user.setPost(post);
        user.setEmail(email);
        user.setRegIpAddress(ipAddress);

        if (username.length() != 0 && password.length() != 0 && rePassword.length() != 0 && names.length() != 0) {

            User sqlUser = userDao.selectByUsername(username);
            if (sqlUser.getUsername() == null) {
                if(password.equals(rePassword)) {
                    if (userDao.addUser(user)) {
                        out.print(user.getUsername() + "，注册成功，去登录！<a href='/login.jsp'>登录页面</a>");
                    }
                }
                else {
                    out.println("你两次输入的密码不同，请重新注册！<a href='/register.jsp'>注册页面</a>");
                }
            } else {
                out.println("该用户名已被注册，请重新注册！<a href='/register.jsp'>注册页面</a>");
            }
        } else {
            out.println("必须输入用户名，原密码，确认密码，真实姓名，请重新注册! <a href='/register.jsp'>注册页面</a>");
        }
    }
}
