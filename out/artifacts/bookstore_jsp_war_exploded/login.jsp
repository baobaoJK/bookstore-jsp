<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 用户登录</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/login.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="login">
    <form action="/login" method="post" class="login-form">
        <h2><%= WebInfo.getWebName() %> - 用户登录</h2>
        <div class="login-form-item">
            <label for="username">账号</label>
            <input type="text" name="username" id="username" placeholder="账号">
        </div>
        <div class="login-form-item">
            <label for="password">密码</label>
            <input type="password" name="password" id="password" placeholder="密码">
        </div>
        <div class="login-form-item">
            <button type="submit" class="btn btn-primary">登录</button>
        </div>
        <div class="login-form-item">
            <a href="/register.jsp">注册账号</a>
        </div>
    </form>
</div>

</body>
</html>
