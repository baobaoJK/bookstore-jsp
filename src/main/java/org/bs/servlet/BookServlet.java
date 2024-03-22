package org.bs.servlet;

import org.bs.dao.CartDao;
import org.bs.dao.BookDao;
import org.bs.dao.UserDao;
import org.bs.pojo.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author KSaMar
 * @version 1.0
 * 图书操作控制器
 */
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // 获取状态
        String status = req.getParameter("status");

        BookDao bookDao = new BookDao();
        CartDao cartDao = new CartDao();

        // 添加图书至购物车
        if (status.equals("addCart")) {
            String bookName = req.getParameter("bookName");
            int count = Integer.parseInt(req.getParameter("bookCount"));
            int userId = Integer.parseInt(req.getParameter("userId"));
            ArrayList<Book> books = bookDao.selectByBookName(bookName);
            if (books != null) {
                cartDao.addCart(books, count, userId, bookName);
                resp.sendRedirect("/cart");
            }
        }

        // 更新购物车图书信息
        if (status.equals("updateCart")) {
            int bookId = Integer.parseInt(req.getParameter("bookId"));
            int amount  = Integer.parseInt(req.getParameter("amount"));
            cartDao.updateCart(bookId, amount);
            resp.sendRedirect("/cart");
        }

        // 删除购物车中的图书
        if (status.equals("deleteCart")) {
            int bookId = Integer.parseInt(req.getParameter("bookId"));
            int id = Integer.parseInt(req.getParameter("id"));
            cartDao.deleteCart(bookId, id);
            resp.sendRedirect("/cart");
        }

        // 提交购物车订单
        if(status.equals("submitCart")) {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            int id = Integer.parseInt(req.getParameter("id"));
            String username = new String(req.getParameter("username"));
            String address = new UserDao().selectByUsername(username).getAddress();
            cartDao.addCart(id, username, address, timestamp);
            cartDao.deleteCart(id);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/order");
            requestDispatcher.forward(req, resp);
        }

        // 清空购物车
        if (status.equals("clearCart")) {
            int id = Integer.parseInt(req.getParameter("id"));
            cartDao.deleteCart(id);
            resp.sendRedirect("/cart");
        }

        // 添加图书
        if (status.equals("addbook")) {
            String bookName = req.getParameter("bookName");
            String bookClass = req.getParameter("bookClass");
            String author = req.getParameter("author");
            String publish = req.getParameter("publish");
            String bookNo = req.getParameter("bookNo");
            String content = req.getParameter("content");
            float price = Float.parseFloat(req.getParameter("price"));
            int amount = Integer.parseInt(req.getParameter("amount"));
            bookDao.addBook(bookName, bookClass, author, publish, bookNo, content, price, amount);
            resp.sendRedirect("/admin/booklist.jsp");
        }

        // 删除图书
        if (status.equals("deletebook")) {
            int id = Integer.parseInt(req.getParameter("id"));
            bookDao.deleteBook(id);
            resp.sendRedirect("/admin/booklist.jsp");
        }

        // 更新图书
        if (status.equals("updatebook")) {
            int id = Integer.parseInt(req.getParameter("id"));
            float price = Float.parseFloat(req.getParameter("price"));
            int amount = Integer.parseInt(req.getParameter("amount"));
            int surplus = Integer.parseInt(req.getParameter("surplus"));

            bookDao.updateBook(id, price, amount, surplus);
            resp.sendRedirect("/admin/booklist.jsp");
        }
    }
}
