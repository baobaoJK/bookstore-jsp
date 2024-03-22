package org.bs.dao.interfaces;

import org.bs.pojo.Order;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * 订单管理接口
 */
public interface OrderInterface {

    /**
     * 根据 用户 id 查询订单
     *
     * @param userId 用户 id
     * @return 订单信息
     */
    ArrayList<Order> selectByUserId(int userId);

    /**
     * 根据 indentNo 查询订单
     *
     * @param indentNo 编号
     * @return 订单信息
     */
    ArrayList<Order> selectByIndentNo(int indentNo);

    /**
     * 查询所有订单
     *
     * @return 订单信息
     */
    ArrayList<Order> selectAll();

    /**
     * 添加订单
     *
     * @param totalPrice 总价
     * @param time       事件
     * @param id         id
     * @param username   用户名
     * @param ipAddress  ip 地址
     */
    void insertOrder(float totalPrice, Timestamp time, int id, String username, String ipAddress);

    /**
     * 根据 id 和 图书名称删除订单
     *
     * @param id       id
     * @param bookName 图书名称
     */
    void deleteOrderByIdAndBookName(int id, String bookName);

    /**
     * 根据 indentNo 删除订单
     *
     * @param indentNo indentNo
     */
    void deleteOrderByIndentNo(int indentNo);

    /**
     * 发货
     */
    void updateOrder();

    /**
     * 更新订单状态
     *
     * @param indentNo 订单编号
     * @param isPayOff 付款状态
     * @param isSales  发货状态
     */
    void updateOrder(int indentNo, String isPayOff, String isSales);
}
