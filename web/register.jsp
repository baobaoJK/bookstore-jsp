<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 用户注册</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/register.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="register">
    <form action="/register" method="post" class="register-form">
        <h1><%= WebInfo.getWebName() %> - 用户注册</h1>
        <div class="register-form-item">
            <label for="username"><span style="color: red">*</span>用户名</label>
            <input type="text" name="username" id="username">
        </div>
        <div class="register-form-item">
            <label for="password"><span style="color: red">*</span>密码</label>
            <input type="password" name="password" id="password">
        </div>
        <div class="register-form-item">
            <label for="repassword"><span style="color: red">*</span>确认密码</label>
            <input type="password" name="repassword" id="repassword">
        </div>
        <div class="register-form-item">
            <label for="names"><span style="color: red">*</span>真实姓名</label>
            <input type="text" name="names" id="names">
        </div>
        <div class="register-form-item">
            <label for="sex">性别</label>
            <select name="sex" id="sex">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
        <div class="register-form-item">
            <label for="address">联系地址</label>
            <input type="text" name="address" id="address">
        </div>
        <div class="register-form-item">
            <label for="post">联系邮编</label>
            <input type="text" name="post" id="post">
        </div>
        <div class="register-form-item">
            <label for="phone">联系电话</label>
            <input type="text" name="phone" id="phone">
        </div>
        <div class="register-form-item">
            <label for="email">电子邮件</label>
            <input type="text" name="email" id="email">
        </div>
        <div class="register-form-item">
            <button type="submit" name="register" class="btn btn-primary">注册</button>
        </div>
    </form>
</div>
</body>
</html>
