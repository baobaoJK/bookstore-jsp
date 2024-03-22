<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-link active" href="<c:url value="/display"/>">首页</a>
            <a class="nav-link" href="<c:url value="/display"/>">在线购物</a>
            <a class="nav-link" href="<c:url value="/cart"/>">我的购物车</a>
            <a class="nav-link" href="<c:url value="/order?status=cat"/>">我的订单</a>
            <a class="nav-link" href="<c:url value="/user?status=user"/>">个人信息</a>
            <a class="nav-link" href="<c:url value="/user?status=signout"/>">退出登录</a>
        </div>
    </div>
</nav>