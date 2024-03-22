package org.bs.servlet;

import org.bs.dao.CartDao;
import org.bs.pojo.Cart;
import org.bs.pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * 添加购物车控制器
 */
public class ShopCartListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        CartDao cartDao = new CartDao();
        ArrayList<Cart> books = cartDao.selectByUserId(user.getId());
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/user/cart.jsp");
        dispatcher.forward(req, resp);
    }
}
