package org.bs.dao;

import org.bs.dao.interfaces.CartInterface;
import org.bs.pojo.Book;
import org.bs.pojo.Cart;
import org.bs.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * 购物车 DAO
 */
public class CartDao implements CartInterface {
    DataBaseUtil dataBaseUtil = new DataBaseUtil();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * 搜索购物车表单
     *
     * @param userId 用户 id
     * @return 购物车表单信息
     */
    @Override
    public ArrayList<Cart> selectByUserId(int userId) {
        ArrayList<Cart> carts = null;

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from cart_list where user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();

            carts = getCarts(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }

        return carts;
    }

    /**
     * 添加购物车
     *
     * @param id       id
     * @param username 用户名
     * @param address  地址
     * @param time     时间
     */
    @Override
    public void addCart(int id, String username, String address, Timestamp time) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from cart_list where user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                float totalPrice = resultSet.getFloat("price") * resultSet.getInt("amount");
                String sql2 = "insert into order_list" +
                        "(indent_no, user_id, user_name, submit_time, total_price, is_pay_off, is_sales, address, book_name) " +
                        "values(?,?,?,?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setInt(1, (int) (Math.random() * 10000000));
                preparedStatement.setInt(2, id);
                preparedStatement.setString(3, username);
                preparedStatement.setTimestamp(4, time);
                preparedStatement.setFloat(5, totalPrice);
                preparedStatement.setString(6, "未付");
                preparedStatement.setString(7, "未发货");
                preparedStatement.setString(8, address);
                preparedStatement.setString(9, resultSet.getString("book_name"));
                int result = preparedStatement.executeUpdate();

                if (result != 0) {
                    System.out.println("add cart is success");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }
    }

    /**
     * 添加图书至购物车
     *
     * @param books    图书列表
     * @param count    数量
     * @param userId   用户 id
     * @param bookName 图书名称
     */
    @Override
    public void addCart(ArrayList<Book> books, int count, int userId, String bookName) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "update book_list set surplus = book_list.surplus - ? where book_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, count);
            preparedStatement.setString(2, bookName);
            preparedStatement.executeUpdate();

            System.out.println("update book is success");

            String sql2 = "select user_id from cart_list where user_id = ? and book_id = ?";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, books.get(0).getId());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String sql3 = "update cart_list set amount = amount + ? where user_id = ? and book_id = ?";
                preparedStatement = connection.prepareStatement(sql3);
                preparedStatement.setInt(1, count);
                preparedStatement.setInt(2, userId);
                preparedStatement.setInt(3, books.get(0).getId());

                int result = preparedStatement.executeUpdate();
                if (result != 0) {
                    System.out.println("update cart is success");
                }
            } else {
                String sql4 = "insert into cart_list(user_id, book_name, author, book_class, price, amount, book_id) " +
                        "values(?,?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(sql4);
                preparedStatement.setInt(1, userId);
                preparedStatement.setString(2, books.get(0).getBookName());
                preparedStatement.setString(3, books.get(0).getAuthor());
                preparedStatement.setString(4, books.get(0).getBookClass());
                preparedStatement.setFloat(5, books.get(0).getPrice());
                preparedStatement.setInt(6, count);
                preparedStatement.setInt(7, books.get(0).getId());

                int result = preparedStatement.executeUpdate();
                if (result != 0) {
                    System.out.println("add cart is success");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }
    }

    /**
     * 更新购物车
     *
     * @param bookId 图书 id
     * @param amount 总数
     */
    @Override
    public void updateCart(int bookId, int amount) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "update cart_list set amount = ? where book_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, amount);
            preparedStatement.setInt(2, bookId);
            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("update cart is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 根据 bookId 和 id 删除购物车
     *
     * @param bookId 图书 id
     * @param userId id
     */
    @Override
    public void deleteCart(int bookId, int userId) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "delete from cart_list where user_id = ? and book_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, bookId);
            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("delete cart is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 根据 id 删除购物车
     *
     * @param userId 用户 id
     */
    @Override
    public void deleteCart(int userId) {
        try {
            dataBaseUtil = new DataBaseUtil();
            connection = dataBaseUtil.getConnection();

            String sql = "delete from cart_list where user_id = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("delete cart is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 根据 id 清空购物车
     *
     * @param userId 用户 id
     */
    @Override
    public void clearCart(int userId) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "delete from cart_list where user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("delete cart is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 获取购物车信息
     *
     * @param cartResultSet 购物车集合
     * @return 购物车信息
     * @throws SQLException SQL异常
     */
    public ArrayList<Cart> getCarts(ResultSet cartResultSet) throws SQLException {
        ArrayList<Cart> carts = new ArrayList<>();

        while (resultSet.next()) {
            Cart cart = new Cart();
            cart.setUserId(resultSet.getInt("user_id"));
            cart.setBookName(resultSet.getString("book_name"));
            cart.setBookClass(resultSet.getString("book_class"));
            cart.setAuthor(resultSet.getString("author"));
            cart.setPrice(resultSet.getFloat("price"));
            cart.setAmount(resultSet.getInt("amount"));
            cart.setBookId(resultSet.getInt("book_id"));
            carts.add(cart);
        }

        return carts;
    }
}
