package org.bs.pojo;

import java.sql.Timestamp;

/**
 * @author KSaMar
 * @version 1.0
 * 订单实体类
 */
public class Order {
    // id
    private int id;
    // 订单编号
    private int indentNo;
    // 用户 id
    private int userId;
    // 用户名称
    private String username;
    // 提交时间
    private Timestamp submitTime;
    // 交货时间
    private Timestamp consignmentTime;
    // 总价
    private float totalPrice;
    // 简介
    private String content;
    // 地址
    private String address;
    // 付款状态
    private String isPayOff;
    // 发货状态
    private String isSales;
    // 图书名称
    private String bookName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndentNo() {
        return indentNo;
    }

    public void setIndentNo(int indentNo) {
        this.indentNo = indentNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public Timestamp getConsignmentTime() {
        return consignmentTime;
    }

    public void setConsignmentTime(Timestamp consignmentTime) {
        this.consignmentTime = consignmentTime;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsPayOff() {
        return isPayOff;
    }

    public void setIsPayOff(String isPayOff) {
        this.isPayOff = isPayOff;
    }

    public String getIsSales() {
        return isSales;
    }

    public void setIsSales(String isSales) {
        this.isSales = isSales;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
