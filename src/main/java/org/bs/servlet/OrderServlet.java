package org.bs.servlet;

import org.bs.dao.OrderDao;
import org.bs.pojo.Order;
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
 * 订单控制器
 */
public class OrderServlet extends HttpServlet {
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

        OrderDao orderDao = new OrderDao();

        if (status.equals("deleteOrder")) {
            int indentNo = Integer.parseInt(req.getParameter("indentNo"));
            orderDao.deleteOrderByIndentNo(indentNo);
            resp.sendRedirect("/admin/orderlist.jsp");
        } else if (status.equals("updateOrder")) {
            int indentNo = Integer.parseInt(req.getParameter("indentNo"));
            String isPay = req.getParameter("isPay");
            String isSales = req.getParameter("isSales");
            orderDao.updateOrder(indentNo, isPay, isSales);
            resp.sendRedirect("/admin/orderlist.jsp");
        } else {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            ArrayList<Order> orders = orderDao.selectByUserId(user.getId());
            req.setAttribute("orders", orders);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/user/order.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
