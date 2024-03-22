package org.bs.pojo;

import java.sql.Date;

/**
 * @author KSaMar
 * @version 1.0
 * 用户实体类
 */
public class User {
    // id
    private int id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 名称
    private String names;
    // 性别
    private String sex;
    // 地址
    private String address;
    // 手机号
    private String phone;
    //
    private String post;
    // 电子邮件
    private String email;
    // 注册时间
    private Date regTime;
    // 注册 ip 地址
    private String regIpAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getRegIpAddress() {
        return regIpAddress;
    }

    public void setRegIpAddress(String regIpAddress) {
        this.regIpAddress = regIpAddress;
    }
}
