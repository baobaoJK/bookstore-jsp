<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 更新图书</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/admin/book-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="update-book">
    <jsp:include page="/util/admin-navbar.jsp"/>

    <div class="card">
        <div class="card-header">
            <h3>修改图书信息</h3>
        </div>
        <div class="card-body">
            <form action="/book">
                <div class="update-form-item">
                    <label for="id">图书编号：</label>
                    <p name="id" id="id"><%= request.getParameter("id") %></p>
                </div>
                <div class="update-form-item">
                    <label for="bookName">图书名称：</label>
                    <p name="bookName" id="bookName"><%= request.getParameter("bookName") %></p>
                </div>
                <div class="update-form-item">
                    <label for="author">作者：</label>
                    <p name="author" id="author"><%= request.getParameter("author") %></p>
                </div>
                <div class="update-form-item">
                    <label for="bookClass">图书类别：</label>
                    <p name="bookClass" id="bookClass"><%= request.getParameter("bookClass") %></p>
                </div>
                <div class="update-form-item">
                    <label for="price">单价：</label>
                    <input name="price" id="price" value="<%= request.getParameter("price") %>">
                </div>
                <div class="update-form-item">
                    <label for="amount">总数量：</label>
                    <input name="amount" id="amount" value="<%= request.getParameter("amount") %>">
                </div>
                <div class="update-form-item">
                    <label for="surplus">剩余数量：</label>
                    <input name="surplus" id="surplus" value="<%= request.getParameter("surplus") %>">
                </div>
                <div class="update-form-item">
                    <button type="submit" class="btn btn-primary">修改</button>
                </div>
                <div class="update-form-item">
                    <input type="hidden" name="status" value="updatebook">
                    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
