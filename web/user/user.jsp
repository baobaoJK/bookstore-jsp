<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="org.bs.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 用户页面</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/user/user.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>

<div class="user">
    <jsp:include page="/util/navbar.jsp" />

    <div class="card">
        <div class="card-header">
            <h2>用户信息</h2>
        </div>
        <div class="card-body">
            <table class="table table-bordered">
                <tr>
                    <td>用户名</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>地址</td>
                    <td>手机</td>
                    <td>邮编</td>
                    <td>电子邮件</td>
                    <td>注册时间</td>
                    <td>注册地址</td>
                </tr>
                <%
                    User user = (User) session.getAttribute("user");
                %>
                <tr>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getNames() %></td>
                    <td><%= user.getSex() %></td>
                    <td><%= user.getAddress() %></td>
                    <td><%= user.getPhone() %></td>
                    <td><%= user.getPost() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getRegTime() %></td>
                    <td><%= user.getRegIpAddress() %></td>
                </tr>
            </table>
            <a href="/user/userlist.jsp">更改信息</a>
        </div>
    </div>
</div>
</body>
</html>
