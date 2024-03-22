<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="org.bs.util.DataBaseUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 用户管理</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/admin/user-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="user-list">
    <jsp:include page="/util/admin-navbar.jsp"/>

    <div class="card">
        <div class="card-header">
            <h3>网上书城用户情况</h3>
        </div>
        <div class="card-body">
            <table class="table table-bordered">
                <tr>
                    <td>用户ID号</td>
                    <td>用户名</td>
                    <td>真实姓名</td>
                    <td>联系地址</td>
                    <td>联系电话</td>
                    <td>Email</td>
                    <td>操作</td>
                </tr>
                <%
                    DataBaseUtil dataBaseUtil = new DataBaseUtil();
                    Connection connection = dataBaseUtil.getConnection();
                    PreparedStatement preparedStatement;
                    ResultSet resultSet;
                %>
                <%
                    String sql = "select * from user_list";
                    preparedStatement = connection.prepareStatement(sql);
                    resultSet = preparedStatement.executeQuery();
                    resultSet.beforeFirst();

                    while(resultSet.next()) {
                %>
                <tr>
                    <td><%= resultSet.getInt("id") %></td>
                    <td><%= resultSet.getString("user_name") %></td>
                    <td><%= resultSet.getString("names") %></td>
                    <td><%= resultSet.getString("address") %></td>
                    <td><%= resultSet.getString("phone") %></td>
                    <td><%= resultSet.getString("email") %></td>
                    <td><a href="/admin/user.jsp?status=cat&id=<%= resultSet.getInt("id") %>">详细资料</a></td>
                    <td><a href="/user?status=deleteUser&id=<%= resultSet.getInt("id") %>">删除</a></td>
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
