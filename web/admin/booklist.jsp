<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="org.bs.dao.BookDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.bs.pojo.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 图书管理页面</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/admin/book-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="book-list">
    <jsp:include page="/util/admin-navbar.jsp"/>

    <div class="card">
        <div class="card-header">
            <h3>网上书城书店图书情况</h3>
        </div>
        <div class="card-body">
            <table class="table table-bordered">
                <tr>
                    <td>编号</td>
                    <td>图书名</td>
                    <td>作者</td>
                    <td>类别</td>
                    <td>单价</td>
                    <td>总数量</td>
                    <td>剩余数</td>
                    <td>操作</td>
                </tr>
                <%
                    BookDao dataBasePool = new BookDao();
                    ArrayList<Book> books = dataBasePool.selectAll();

                    if (books != null) {
                        for (int i = 0; i < books.size(); i++) {
                %>
                <tr>
                    <td><%= books.get(i).getId() %>
                    </td>
                    <td><%= books.get(i).getBookName() %>
                    </td>
                    <td><%= books.get(i).getAuthor() %>
                    </td>
                    <td><%= books.get(i).getBookClass() %>
                    </td>
                    <td><%= books.get(i).getPrice() %>
                    </td>
                    <td><%= books.get(i).getAmount() %>
                    </td>
                    <td><%= books.get(i).getSurplus() %>
                    </td>
                    <td>
                        <a href="/admin/updatebook.jsp?id=<%= books.get(i).getId() %>&bookName=<%= books.get(i).getBookName() %>&author=<%= books.get(i).getAuthor() %>&bookClass=<%= books.get(i).getBookClass() %>&price=<%= books.get(i).getPrice() %>&amount=<%= books.get(i).getAmount() %>&surplus=<%= books.get(i).getSurplus() %>">修改</a>
                        <a href="/book?status=deletebook&id=<%= books.get(i).getId() %>">删除</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </div>
    </div>

</div>
</body>
</html>
