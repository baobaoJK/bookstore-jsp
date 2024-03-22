<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-link active" href="<c:url value="/admin/booklist.jsp"/>">商店图书信息</a>
            <a class="nav-link" href="<c:url value="/admin/addbook.jsp"/>">添加图书资料</a>
            <a class="nav-link" href="<c:url value="/admin/orderlist.jsp"/>">订单信息查询</a>
            <a class="nav-link" href="<c:url value="/admin/userlist.jsp"/>">用户信息查询</a>
            <a class="nav-link" href="<c:url value="/user?status=signout"/>">退出登录</a>
        </div>
    </div>
</nav>