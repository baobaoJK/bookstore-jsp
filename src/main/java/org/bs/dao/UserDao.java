package org.bs.dao;

import org.bs.dao.interfaces.UserInterface;
import org.bs.pojo.User;
import org.bs.util.DataBaseUtil;

import java.sql.*;
import java.util.Date;

/**
 * @author KSaMar
 * @version 1.0
 * 用户操作 DAO
 */
public class UserDao implements UserInterface {
    DataBaseUtil dataBaseUtil = new DataBaseUtil();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    /**
     * 根据 id 搜索 用户
     *
     * @param id id
     * @return 用户信息
     */
    @Override
    public User selectById(int id) {
        User user = null;

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from user_list where id=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            user = getUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }

        return user;
    }

    /**
     * 根据 用户名 搜索用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public User selectByUsername(String username) {
        User user = null;

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from user_list where user_name=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            user = getUser(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }

        return user;
    }

    /**
     * 根据 用户名 和 密码 搜索用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        User user = null;

        try {
            connection = dataBaseUtil.getConnection();

            String sql = "select * from user_list where user_name=? and pass_word=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            user = getUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }
        return user;
    }

    /**
     * 添加用户
     * @param user 用户
     * @return 添加状态
     */
    @Override
    public boolean addUser(User user) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        try {
            DataBaseUtil dataBaseUtil = new DataBaseUtil();
            connection = dataBaseUtil.getConnection();

            String sql = "insert into " +
                    "user_list(user_name,pass_word,names,sex,address,phone,post,email,reg_time,reg_ip_address) " +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNames());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getPost());
            preparedStatement.setString(8, user.getEmail());
            preparedStatement.setTimestamp(9, timestamp);
            preparedStatement.setString(10, user.getRegIpAddress());

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("add user is success");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }

        return false;
    }

    /**
     * 根据 id 删除用户
     * @param id 用户 id
     */
    @Override
    public void deleteById(int id) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "delete from user_list where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("delete user is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 根据 用户 Id 更新信息
     *
     * @param id 用户 id
     * @param names 用户名称
     * @param address 用户地址
     * @param phone 用户手机号
     * @param post 用户邮编
     * @param email 用户邮件
     */
    @Override
    public void updateUserById(int id, String names, String address, String phone, String post, String email) {
        try {
            connection = dataBaseUtil.getConnection();

            String sql = "update user_list set names=?,address=?,phone=?,post=?,email=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, names);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, post);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, id);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("update user is success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement);
        }
    }

    /**
     * 获取用户信息
     * @param userResultSet 用户集合
     * @return 用户信息
     * @throws SQLException SQL 异常
     */
    public User getUser(ResultSet userResultSet) throws SQLException {
        User user = new User();

        while (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("pass_word"));
            user.setNames(resultSet.getString("names"));
            user.setSex(resultSet.getString("sex"));
            user.setAddress(resultSet.getString("address"));
            user.setPhone(resultSet.getString("phone"));
            user.setPost(resultSet.getString("post"));
            user.setEmail(resultSet.getString("email"));
            user.setRegTime(resultSet.getDate("reg_time"));
            user.setRegIpAddress(resultSet.getString("reg_ip_address"));
        }

        return user;
    }
}
