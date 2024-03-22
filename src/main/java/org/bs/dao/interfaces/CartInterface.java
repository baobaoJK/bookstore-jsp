package org.bs.dao.interfaces;

import org.bs.pojo.Book;
import org.bs.pojo.Cart;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * 购物车接口
 */
public interface CartInterface {
    /**
     * 根据 id 遍历购物车
     *
     * @param userId 用户 id
     * @return 购物车信息
     */
    ArrayList<Cart> selectByUserId(int userId);

    /**
     * 添加购物车
     *
     * @param id        id
     * @param username  用户名
     * @param ipAddress 地址
     * @param time      时间
     */
    void addCart(int id, String username, String ipAddress, Timestamp time);

    /**
     * 添加购物车
     *
     * @param books    图书列表
     * @param count    数量
     * @param userId   用户 id
     * @param bookName 图书名称
     */
    void addCart(ArrayList<Book> books, int count, int userId, String bookName);

    /**
     * 修改购物车
     *
     * @param bookId 图书 id
     * @param amount 总数
     */
    void updateCart(int bookId, int amount);

    /**
     * 根据 bookId 和 id 删除购物车
     *
     * @param bookId 图书 id
     * @param userId 用户id
     */
    void deleteCart(int bookId, int userId);

    /**
     * 根据 id 删除购物车
     *
     * @param userId 用户 ID
     */
    void deleteCart(int userId);

    /**
     * 清空购物车
     *
     * @param userId 用户 id
     */
    void clearCart(int userId);

}
