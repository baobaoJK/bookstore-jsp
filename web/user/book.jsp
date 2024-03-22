<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="org.bs.pojo.Book" %>
<%@ page import="org.bs.dao.BookDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 图书信息</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/user/book-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="book">
    <jsp:include page="/util/navbar.jsp"/>

    <div class="card">
        <div class="card-header">
            <h2>图书信息</h2>
        </div>
        <div class="card-body">

            <%
                int id = Integer.parseInt(request.getParameter("id"));
                Book book = new BookDao().selectById(id);
            %>

            <table class="table table-bordered">
                <tr>
                    <td>图书名称</td>
                    <td>图书类型</td>
                    <td>作者</td>
                    <td>出版社</td>
                    <td>图书编号</td>
                    <td>图书简介</td>
                    <td>单价</td>
                    <td>库存</td>
                    <td>剩余库存</td>
                </tr>
                <%
                %>
                <tr>
                    <td><%= book.getBookName() %></td>
                    <td><%= book.getBookClass() %></td>
                    <td><%= book.getAuthor() %></td>
                    <td><%= book.getPublish() %></td>
                    <td><%= book.getBookClass() %></td>
                    <td><%= book.getContent() %></td>
                    <td><%= book.getPrice() %></td>
                    <td><%= book.getAmount() %></td>
                    <td><%= book.getSurplus() %></td>
                </tr>
            </table>
            <a href="/display">关闭窗口</a>
        </div>

    </div>
</body>
</html>
