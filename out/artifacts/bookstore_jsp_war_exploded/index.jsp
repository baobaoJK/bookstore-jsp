<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 主页</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
    <style>
        .index {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            width: 100%;
            height: 100%;
            background: url("/assets/images/background.jpg") no-repeat center center;
            background-size: cover;
        }

        button a {
            color: white;
            font-size: 24px !important;
        }
    </style>
</head>
<body>
<div class="index">
    <h1>欢迎使用网上书城！</h1>
    <button class="btn btn-primary">
        <a href="/login.jsp">进 入</a>
    </button>
</div>
</body>
</html>
