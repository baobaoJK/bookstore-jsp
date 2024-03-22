<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.bs.pojo.Order" %>
<%@ page import="org.bs.dao.OrderDao" %>
<%@ page import="org.bs.pojo.Book" %>
<%@ page import="org.bs.dao.BookDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 订单信息</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/user/order.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="order-list">
    <jsp:include page="/util/navbar.jsp"/>

    <div class="card">
        <div class="card-header">
            <h2>网上书城图书订单清单</h2>
        </div>
        <div class="card-body">

            <%
                int indentNo = Integer.parseInt(request.getParameter("indentNo"));
                ArrayList<Order> orders = new OrderDao().selectByIndentNo(indentNo);
            %>

            <table class="table table-bordered">
                <tr>
                    <td>图书名称</td>
                    <td>作者</td>
                    <td>图书类别</td>
                    <td>单价</td>
                    <td>数量</td>
                </tr>
                <%
                    Book book = new BookDao().selectByBookName(orders.get(0).getBookName()).get(0);
                %>
                <tr>
                    <td><%= book.getBookName() %></td>
                    <td><%= book.getAuthor() %></td>
                    <td><%= book.getBookClass() %></td>
                    <td><%= book.getPrice() %></td>
                    <td><%= (int) (orders.get(0).getTotalPrice() / book.getPrice()) %></td>
                </tr>
            </table>
            <table class="table table-bordered">
                <%
                    if (orders != null) {
                        for (int i = 0; i < orders.size(); i++) {
                %>
                <tr>
                    <td>下单用户：</td>
                    <td><%= orders.get(i).getUsername() %>
                    </td>
                <tr>
                <tr>
                    <td>下单时间：</td>
                    <td><%= orders.get(i).getSubmitTime() %>
                    </td>
                </tr>
                <tr>
                    <td>交货时间：</td>

                    <td><%= orders.get(i).getConsignmentTime() %>
                    </td>
                </tr>
                <tr>
                    <td>总金额：</td>
                    <td><%= orders.get(i).getTotalPrice() %>
                    </td>
                </tr>
                <tr>
                    <td>下单地址：</td>
                    <td><%= orders.get(i).getAddress() %>
                    </td>
                </tr>
                <tr>
                    <td>用户备注：</td>
                    <td><%= orders.get(i).getContent() %>
                    </td>
                </tr>
                <tr>
                    <td>是否付款：</td>
                    <td><%= orders.get(i).getIsPayOff() %>
                    </td>
                </tr>
                <tr>
                    <td>是否交货</td>
                    <td><%= orders.get(i).getIsSales() %>
                    </td>
                </tr>
                <%
                        }
                    }
                %>

            </table>
            <a href="/display">关闭窗口</a>
        </div>

    </div>
</body>
</html>
