<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
</head>
<body>

<%
    String status = request.getParameter("status");

    if (status.equals("empty")) {
%>
<h1>请输入用户名和密码</h1>
<%
} else {
%>
<h1>用户名或密码不正确</h1>
<%
    }
%>
</body>
</html>
