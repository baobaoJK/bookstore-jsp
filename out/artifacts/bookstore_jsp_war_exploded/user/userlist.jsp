<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="org.bs.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 修改信息 </title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/user/user.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>

<div class="user">
    <jsp:include page="/util/navbar.jsp"/>

    <div class="card">
        <div class="card-header">
            <h2>用户信息</h2>
        </div>
        <div class="card-body">
            <%
                User user = (User) session.getAttribute("user");
            %>
            <form action="/user" method="post">
                <table class="table table-bordered">
                    <tr>
                        <td>用户名</td>
                        <td><%= user.getUsername() %>
                        </td>
                    </tr>
                    <tr>
                        <td>姓名</td>
                        <td><input type="text" name="names" value="<%= user.getNames() %>"></td>
                    </tr>
                    <tr>
                        <td>性别</td>
                        <td><%= user.getSex() %>
                        </td>
                    </tr>
                    <tr>
                        <td>地址</td>
                        <td><input type="text" name="address" value="<%= user.getAddress() %>"></td>
                    </tr>
                    <tr>
                        <td>手机</td>
                        <td><input type="text" name="phone" value="<%= user.getPhone() %>"></td>
                    </tr>
                    <tr>
                        <td>邮编</td>
                        <td><input type="text" name="post" value="<%= user.getPost() %>"></td>
                    </tr>
                    <tr>
                        <td>电子邮件</td>
                        <td><input type="text" name="email" value="<%= user.getEmail() %>"></td>
                    </tr>
                </table>
                <input type="hidden" name="status" value="updateUser">
                <input type="hidden" name="id" value="<%= user.getId() %>">
                <button type="submit" class="btn btn-primary">提交</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
