<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="org.bs.dao.OrderDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.bs.pojo.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 订单管理</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/admin/order-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="order-list">
    <jsp:include page="/util/admin-navbar.jsp"/>

    <div class="card">
        <div class="card-header">
            <h3>购书网订单情况</h3>
        </div>
        <div class="card-body">
            <table class="table table-bordered">
                <tr>
                    <td>订单编号</td>
                    <td>用户名</td>
                    <td>下单时间</td>
                    <td>交货时间</td>
                    <td>总金额</td>
                    <td>订货地址</td>
                    <td>付款</td>
                    <td>发货</td>
                    <td>查看</td>
                </tr>
                <%
                    OrderDao orderDao = new OrderDao();
                    orderDao.updateOrder();
                    ArrayList<Order> orders = orderDao.selectAll();
                %>

                <%
                    if(orders != null) {
                        for (int i = 0; i < orders.size(); i++) {
                %>
                <tr>
                    <td><%= orders.get(i).getIndentNo()%></td>
                    <td><%= orders.get(i).getUsername()%></td>
                    <td><%= orders.get(i).getSubmitTime()%></td>
                    <td><%= orders.get(i).getConsignmentTime()%></td>
                    <td><%= orders.get(i).getTotalPrice()%></td>
                    <td><%= orders.get(i).getAddress()%></td>
                    <td><%= orders.get(i).getIsPayOff()%></td>
                    <td><%= orders.get(i).getIsSales()%></td>
                    <td>
                        <a href="/admin/order.jsp?indentNo=<%= orders.get(i).getIndentNo() %>&bookName=<%= orders.get(i).getBookName() %>">详细情况</a>
                        <a href="/order?status=deleteOrder&indentNo=<%= orders.get(i).getIndentNo() %>">删除</a>
                    </td>
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
