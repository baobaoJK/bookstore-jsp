package org.bs.dao;

import org.bs.dao.interfaces.BookInterface;
import org.bs.pojo.Book;
import org.bs.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * 图书操作 DAO
 */
public class BookDao implements BookInterface {
    DataBaseUtil dataBaseUtil = new DataBaseUtil();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    /**
     * 搜索全部图书信息
     *
     * @return 图书信息
     */
    @Override
    public ArrayList<Book> selectAll() {
        ArrayList<Book> books = null;
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from book_list";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            books = getBooks(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }

        return books;
    }

    /**
     * 根据 ID 搜索图书
     *
     * @param id id
     * @return 图书信息
     */
    @Override
    public Book selectById(int id) {
        Book book = null;

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from book_list where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            book = getBooks(resultSet).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }

        return book;
    }

    /**
     * 根据 图书名称 搜索图书
     *
     * @param bookName 图书名称
     * @return 图书信息
     */
    @Override
    public ArrayList<Book> selectByBookName(String bookName) {
        ArrayList<Book> books = null;

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from book_list where book_name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookName);

            resultSet = preparedStatement.executeQuery();

            books = getBooks(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }

        return books;
    }

    /**
     * 根据 图书类型 搜索图书
     *
     * @param bookClass 图书类型
     * @return 图书信息
     */
    @Override
    public ArrayList<Book> selectByBookClass(String bookClass) {
        ArrayList<Book> books = null;

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from book_list where book_class=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookClass);

            resultSet = preparedStatement.executeQuery();

            books = getBooks(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }

        return books;
    }

    /**
     * 添加图书
     *
     * @param bookName  图书名称
     * @param bookClass 图书类型
     * @param author    作者
     * @param publish   出版社
     * @param bookNo    图书编号
     * @param content   简介
     * @param price     价格
     * @param amount    总量
     */
    @Override
    public void addBook(String bookName, String bookClass, String author, String publish, String bookNo, String content, float price, int amount) {

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "insert into " +
                    "book_list(book_name, book_class, author, publish, book_no, content, price, amount, surplus) " +
                    "values(?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookName);
            preparedStatement.setString(2, bookClass);
            preparedStatement.setString(3, author);
            preparedStatement.setString(4, publish);
            preparedStatement.setString(5, bookNo);
            preparedStatement.setString(6, content);
            preparedStatement.setFloat(7, price);
            preparedStatement.setInt(8, amount);
            preparedStatement.setInt(9, amount);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("add book is success");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 更新图书
     *
     * @param id      id
     * @param price   价格
     * @param amount  总量
     * @param surplus 剩余数量
     */
    @Override
    public void updateBook(int id, float price, int amount, int surplus) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "update book_list set price=?,amount=?,surplus=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, price);
            preparedStatement.setInt(2, amount);
            preparedStatement.setInt(3, surplus);
            preparedStatement.setInt(4, id);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("update book is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 删除图书
     * @param id id
     */
    @Override
    public void deleteBook(int id) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "delete from book_list where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("delete book is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 设置图书信息
     * @param bookResultSet 图书信息集合
     * @return 图书信息
     * @throws SQLException SQL异常
     */
    public ArrayList<Book> getBooks(ResultSet bookResultSet) throws SQLException {
        ArrayList<Book> books = new ArrayList<>();

        while (bookResultSet.next()) {
            Book book = new Book();
            book.setId(bookResultSet.getInt("id"));
            book.setBookName(bookResultSet.getString("book_name"));
            book.setBookClass(bookResultSet.getString("book_class"));
            book.setAuthor(bookResultSet.getString("author"));
            book.setPublish(bookResultSet.getString("publish"));
            book.setBookNo(bookResultSet.getString("book_no"));
            book.setContent(bookResultSet.getString("content"));
            book.setPrice(bookResultSet.getFloat("price"));
            book.setAmount(bookResultSet.getInt("amount"));
            book.setSurplus(bookResultSet.getInt("surplus"));
            books.add(book);
        }

        return books;
    }
}
