<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.bs.pojo.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %></title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/user/book-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="book-list">
    <jsp:include page="/util/navbar.jsp" />

    <div class="card">
        <div class="card-header">
            <h3>电子书店图书列表</h3>
        </div>
        <div class="card-body">
            <% ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books"); %>
            <p>一共有 <%= books.size() %> 本书</p>
            <table class="table table-bordered">
                <tr>
                    <td>图书名称</td>
                    <td>作者</td>
                    <td>图书类别</td>
                    <td>出版社</td>
                    <td>单价</td>
                    <td>数量</td>
                    <td>操作</td>
                </tr>
                <%
                    for (int i = 0; i < books.size(); i++) {
                %>
                <tr>
                    <td><%= books.get(i).getBookName() %>
                    </td>
                    <td><%= books.get(i).getAuthor() %>
                    </td>
                    <td><%= books.get(i).getBookClass() %>
                    </td>
                    <td><%= books.get(i).getPublish() %>
                    </td>
                    <td><%= books.get(i).getPrice() %>
                    </td>
                    <td><%= books.get(i).getSurplus() %>
                    </td>
                    <td>
                        <a href="/user/buybook.jsp?bookName=<%= books.get(i).getBookName() %>">购书</a>
                        <a href="/user/book.jsp?status=cat&id=<%=books.get(i).getId() %>">详细资料</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </div>
</div>
</body>
</html>
