<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 添加图书</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/admin/book-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="add-book">
    <jsp:include page="/util/admin-navbar.jsp"/>

    <div class="card">
        <div class="card-header">
            <h3>添加新的图书信息</h3>
        </div>
        <div class="card-body">
            <form action="/book">
                <div class="add-form-item">
                    <label for="bookName">图书名称：</label>
                    <p><input type="text" name="bookName" id="bookName"></p>
                </div>
                <div class="add-form-item">
                    <label for="author">作者：</label>
                    <p><input type="text" name="author" id="author"></p>
                </div>
                <div class="add-form-item">
                    <label for="publish">出版社：</label>
                    <p><input type="text" name="publish" id="publish"></p>
                </div>
                <div class="add-form-item">
                    <label for="bookClass">所属类别：</label>
                    <p>
                        <select name="bookClass" id="bookClass">
                            <option value="地理">地理</option>
                            <option value="法律">法律</option>
                            <option value="军事">军事</option>
                            <option value="历史">历史</option>
                            <option value="计算机">计算机</option>
                        </select>
                    </p>
                </div>
                <div class="add-form-item">
                    <label for="bookNo">书号：</label>
                    <p><input type="text" name="bookNo" id="bookNo"></p>
                </div>
                <div class="add-form-item">
                    <label for="price">定价：</label>
                    <p><input type="text" name="price" id="price"></p>
                </div>
                <div class="add-form-item">
                    <label for="amount">总数量：</label>
                    <p><input type="text" name="amount" id="amount"></p>
                </div>
                <div class="add-form-item">
                    <label for="content">图书简介：</label>
                    <p><textarea name="content" id="content" cols="0" rows="0"></textarea></p>
                </div>
                <div class="add-form-item">
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
                <div class="add-form-item">
                    <input type="hidden" name="status" value="addbook">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
