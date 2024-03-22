<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 修改图书数量</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/user/update.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="update">
    <jsp:include page="/util/navbar.jsp"/>

    <div class="card">
        <div class="card-header">
            <h2>修改图书数量界面</h2>
        </div>
        <div class="card-body">
            <form action="/book">
                <div class="update-form-item">
                    <p>图书名称：<%= new String(request.getParameter("bookName")) %></p>
                </div>
                <div class="update-form-item">
                    <p>购买数量：<input type="text" name="amount" value="<%= request.getParameter("amount")%>"></p>
                </div>
                <div class="update-form-item">
                    <button type="submit" class="btn btn-primary">修改</button>
                </div>
                <div class="update-form-item">
                    <input type="hidden" name="bookId"
                           value="<%= Integer.parseInt(request.getParameter("bookId"))%>">
                    <input type="hidden" name="status" value="updateCart">
                </div>
            </form>
            <a href="/cart">返回</a>
        </div>
    </div>
</div>
</body>
</html>
