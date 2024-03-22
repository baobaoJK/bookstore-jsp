package org.bs.dao.interfaces;

import org.bs.pojo.Book;

import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * 图书管理接口
 */
public interface BookInterface {
    /**
     * 查询图书信息
     *
     * @return 图书信息
     */
    ArrayList<Book> selectAll();

    /**
     * 根据 id 查询图书
     *
     * @param id id
     * @return 图书信息
     */
    Book selectById(int id);

    /**
     * 根据图书名称查询图书
     *
     * @param bookName 图书名称
     * @return 图书信息
     */
    ArrayList<Book> selectByBookName(String bookName);

    /**
     * 根据图书类型查询图书
     *
     * @param bookClass 图书类型
     * @return 图书信息
     */
    ArrayList<Book> selectByBookClass(String bookClass);

    /**
     * 添加图书
     *
     * @param bookName  图书名称
     * @param author    作者
     * @param publish   出版社
     * @param bookClass 图书类型
     * @param bookNo    图书编号
     * @param price     价格
     * @param amount    总量
     * @param content   简介
     */
    void addBook(String bookName, String bookClass, String author, String publish, String bookNo, String content, float price, int amount);

    /**
     * 修改图书信息
     *
     * @param id      id
     * @param price   价格
     * @param amount  总量
     * @param surplus 剩余数量
     */
    void updateBook(int id, float price, int amount, int surplus);

    /**
     * 根据 id 删除图书
     *
     * @param id id
     */
    void deleteBook(int id);
}
