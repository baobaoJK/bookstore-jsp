<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="org.bs.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.bs.pojo.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 购物车</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/user/cart.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="cart">
    <jsp:include page="/util/navbar.jsp" />

    <div class="card">
        <div class="card-header">
            <h2>购物车列表信息</h2>
        </div>
        <div class="card-body">
            <table class="table table-bordered">
                <tr>
                    <td>图书名称</td>
                    <td>作者</td>
                    <td>图书类别</td>
                    <td>单价</td>
                    <td>数量</td>
                    <td>操作</td>
                </tr>
                <%
                    User user = (User) session.getAttribute("user");
                    ArrayList<Cart> books = (ArrayList<Cart>) request.getAttribute("books");
                    if (!books.isEmpty()) {
                        for (int i = 0; i < books.size(); i++) {
                %>
                <tr>
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
                    <td>
                        <a href="/user/update.jsp?bookName=<%= books.get(i).getBookName() %>&amount=<%= books.get(i).getAmount() %>&bookId=<%= books.get(i).getBookId()%>">更新</a>

                        <a href="/book?id=<%= user.getId() %>&status=deleteCart&bookId=<%= books.get(i).getBookId()%>">删除</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </table>

            <div class="link-block">
                <a href="/display">继续购物</a> <br>
                <a href="/book?status=submitCart&id=<%= user.getId() %>&username=<%= user.getUsername() %>">提交购物车</a> <br>
                <a href="/book?status=clearCart&id=<%= user.getId() %>">清空购物车</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
