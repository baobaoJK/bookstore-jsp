<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.bs.pojo.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 订单页面</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/user/order.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>

<div class="order">
    <jsp:include page="/util/navbar.jsp" />

    <div class="card">
        <div class="card-header">
            <h2>订单信息</h2>
        </div>
        <div class="card-body">
            <%
                ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
            %>
            <table class="table table-bordered">
                <tr>
                    <td>订单号</td>
                    <td>提交时间</td>
                    <td>总金额</td>
                    <td>付款</td>
                    <td>发货</td>
                    <td>详细</td>
                </tr>
                <%
                    if (orders != null) {
                        for (int i = 0; i < orders.size(); i++) {
                %>
                <tr>
                    <td><%= orders.get(i).getIndentNo() %>
                    </td>
                    <td><%= orders.get(i).getSubmitTime() %>
                    </td>
                    <td><%= orders.get(i).getTotalPrice() %>
                    </td>
                    <td><%= orders.get(i).getIsPayOff() %>
                    </td>
                    <td><%= orders.get(i).getIsSales() %>
                    </td>
                    <td>
                        <a href="/user/orderlist.jsp?indentNo=<%= orders.get(i).getIndentNo() %>&bookName=<%= orders.get(i).getBookName()%>">查看</a>
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
