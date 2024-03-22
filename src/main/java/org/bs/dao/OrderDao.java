package org.bs.dao;

import org.bs.dao.interfaces.OrderInterface;
import org.bs.pojo.Order;
import org.bs.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author KSaMar
 * @version 1.0
 * 订单管理 DAO
 */
public class OrderDao implements OrderInterface {
    DataBaseUtil dataBaseUtil = new DataBaseUtil();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    /**
     * 根据 用户 id 搜索订单
     *
     * @param userId 用户 id
     * @return 订单信息
     */
    @Override
    public ArrayList<Order> selectByUserId(int userId) {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from order_list where user_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();

            orders = getOrders(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }
        return orders;
    }

    /**
     * 根据 indentNo 搜索订单
     *
     * @param indentNo 编号
     * @return 订单信息
     */
    @Override
    public ArrayList<Order> selectByIndentNo(int indentNo) {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from order_list where indent_no=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, indentNo);

            resultSet = preparedStatement.executeQuery();

            orders = getOrders(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }

        return orders;
    }

    /**
     * 搜索所有订单信息
     *
     * @return 订单信息
     */
    @Override
    public ArrayList<Order> selectAll() {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            DataBaseUtil dataBaseUtil = new DataBaseUtil();
            connection = dataBaseUtil.getConnection();

            String sql = "select * from order_list";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            orders = getOrders(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }
        return orders;
    }

    /**
     * 添加订单
     *
     * @param totalPrice 总价
     * @param time       事件
     * @param id         id
     * @param username   用户名
     * @param address  ip 地址
     */
    @Override
    public void insertOrder(float totalPrice, Timestamp time, int id, String username, String address) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "insert into order_list(user_id,user_name,submit_time,total_price,is_pay_off,is_sales,address) values(?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, username);
            preparedStatement.setTimestamp(3, time);
            preparedStatement.setFloat(4, totalPrice);
            preparedStatement.setString(5, "未付");
            preparedStatement.setString(6, "未发货");
            preparedStatement.setString(7, address);

            int result = preparedStatement.executeUpdate();
            if (result != 0) {
                System.out.println("insert order is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 根据 id 和 图书名称删除订单
     *
     * @param id       id
     * @param bookName 图书名称
     */
    @Override
    public void deleteOrderByIdAndBookName(int id, String bookName) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "delete from order_list where id=? and book_name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, bookName);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("delete order is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 根据 indentNo 删除订单
     *
     * @param indentNo indentNo
     */
    @Override
    public void deleteOrderByIndentNo(int indentNo) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "delete from order_list where indent_no=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, indentNo);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("delete order is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 更新订单
     */
    @Override
    public void updateOrder() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "update order_list set consignment_time=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, timestamp);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("update order is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 更新订单状态
     *
     * @param indentNo 订单编号
     * @param isPayOff 付款状态
     * @param isSales  发货状态
     */
    @Override
    public void updateOrder(int indentNo, String isPayOff, String isSales) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "update order_list set is_pay_off=?, is_sales=? where indent_no=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, isPayOff);
            preparedStatement.setString(2, isSales);
            preparedStatement.setInt(3, indentNo);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("update order is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 获取订单数据
     *
     * @param orderResultSet 订单集合
     * @return 订单数据
     * @throws SQLException SQL 异常
     */
    public ArrayList<Order> getOrders(ResultSet orderResultSet) throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setIndentNo(resultSet.getInt("indent_no"));
            order.setUserId(resultSet.getInt("user_id"));
            order.setUsername(resultSet.getString("user_name"));
            order.setSubmitTime(resultSet.getTimestamp("submit_time"));
            order.setConsignmentTime(resultSet.getTimestamp("consignment_time"));
            order.setTotalPrice(resultSet.getFloat("total_price"));
            order.setContent(resultSet.getString("content"));
            order.setAddress(resultSet.getString("address"));
            order.setIsPayOff(resultSet.getString("is_pay_off"));
            order.setIsSales(resultSet.getString("is_sales"));
            order.setBookName(resultSet.getString("book_name"));
            orders.add(order);
        }

        return orders;
    }
}
