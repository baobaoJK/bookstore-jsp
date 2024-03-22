package org.bs.dao.interfaces;

import org.bs.pojo.User;

/**
 * @author KSaMar
 * @version 1.0
 * 用户管理接口
 */
public interface UserInterface {
    /**
     * 根据用户 id 获取用户
     *
     * @param id id
     * @return 用户
     */
    User selectById(int id);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    User selectByUsername(String username);

    /**
     * 根据用户名和密码获取用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    User selectByUsernameAndPassword(String username, String password);

    /**
     * 注册新用户，加入用户表
     *
     * @param user 用户
     * @return 添加状态
     */
    boolean addUser(User user);

    /**
     * 根据用户 id 删除用户
     *
     * @param id id
     */
    void deleteById(int id);

    /**
     * 更新用户信息
     *
     * @param id 用户 id
     * @param names 用户名称
     * @param address 用户地址
     * @param phone 用户手机号
     * @param post 用户邮编
     * @param email 用户邮件
     */
    void updateUserById(int id, String names, String address, String phone, String post, String email);
}
