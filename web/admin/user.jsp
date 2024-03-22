<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="org.bs.pojo.User" %>
<%@ page import="org.bs.dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 用户信息</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/admin/user-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="user-list">
    <jsp:include page="/util/admin-navbar.jsp"/>

    <%
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userInfoDao = new UserDao();
        User user = userInfoDao.selectById(id);
    %>

    <div class="card">
        <div class="card-header">
            <h3>用户信息界面</h3>
        </div>
        <div class="card-body user-pane">
            <table class="table table-bordered">
                <tr>
                    <td>ID:</td>
                    <td><%= user.getId() %>
                    </td>
                </tr>
                <tr>
                    <td>用户名:</td>
                    <td><%= user.getUsername() %>
                    </td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><%= user.getPassword() %>
                    </td>
                </tr>
                <tr>
                    <td>真实姓名:</td>
                    <td><%= user.getNames() %>
                    </td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td><%= user.getSex() %>
                    </td>
                </tr>
                <tr>
                    <td>联系地址:</td>
                    <td><%= user.getAddress() %>
                    </td>
                </tr>
                <tr>
                    <td>联系电话:</td>
                    <td><%= user.getPhone() %>
                    </td>
                </tr>
                <tr>
                    <td>邮编:</td>
                    <td><%= user.getPost() %>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><%= user.getEmail() %>
                    </td>
                </tr>
                <tr>
                    <td>注册时间:</td>
                    <td><%= user.getRegTime() %>
                    </td>
                </tr>
                <tr>
                    <td>注册地址:</td>
                    <td><%= user.getRegIpAddress() %>
                    </td>
                </tr>
            </table>
            <a href="/admin/userlist.jsp">返回</a>
        </div>
    </div>
</div>
</body>
</html>
