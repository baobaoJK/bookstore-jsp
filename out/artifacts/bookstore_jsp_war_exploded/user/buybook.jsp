<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="org.bs.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 购买图书</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/user/buy-book.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="buy-book">
    <jsp:include page="/util/navbar.jsp" />
    <% User user = (User) session.getAttribute("user"); %>

    <div class="card">
        <div class="card-header">
            <h2><%= user.getUsername() %> - 网上书城欢迎您选购图书！</h2>
        </div>
        <div class="card-body">
            <form action="/book" method="post">
                <div class="buy-form-item">
                    <p name="name" id="name">图书名称：<%= new String(request.getParameter("bookName"))%>
                    </p>
                </div>
                <div class="buy-form-item">
                    <p>您要购买的数量：<input type="text" name="bookCount" style="width: 50px; height: 24px"> 本</p>
                </div>
                <div class="buy-form-item">
                    <button type="submit" class="btn btn-primary">购买</button>
                </div>
                <div class="buy-form-item">
                    <input type="hidden" name="status" value="addCart">
                    <input type="hidden" name="userId" value="<%= user.getId() %>">
                    <input type="hidden" name="bookName" value="<%= new String(request.getParameter("bookName"))%>">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
