<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.bs.util.WebInfo" %>
<%@ page import="org.bs.dao.BookDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.bs.dao.OrderDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= WebInfo.getWebName() %> - 订单信息</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/app.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/admin/order-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-4.6.2-dist/css/bootstrap.min.css"/>">
</head>
<body>
<div class="order">
    <jsp:include page="/util/admin-navbar.jsp"/>

    <%
        int indentNo = Integer.parseInt(request.getParameter("indentNo"));
        String bookName = request.getParameter("bookName");
        BookDao bookDao = new BookDao();
        ArrayList<org.bs.pojo.Book> books = bookDao.selectByBookName(bookName);
        OrderDao dataBasePoolIndent = new OrderDao();
        ArrayList<org.bs.pojo.Order> orders = dataBasePoolIndent.selectByIndentNo(indentNo);

        float totalPrice = orders.get(0).getTotalPrice();
        float price = books.get(0).getPrice();
        float count = totalPrice / price;
    %>

    <div class="card">
        <div class="card-header">
            <h3>订单清单</h3>
        </div>
        <div class="card-body">
            <table class="table table-bordered">
                <tr>
                    <td>图书名称</td>
                    <td>作者</td>
                    <td>图书类别</td>
                    <td>单价</td>
                    <td>数量</td>
                </tr>
                <tr>
                    <td><%= books.get(0).getBookName() %></td>
                    <td><%= books.get(0).getAuthor() %></td>
                    <td><%= books.get(0).getBookClass() %></td>
                    <td><%= books.get(0).getPrice() %></td>
                    <td><%= count %></td>
                </tr>
                <tr>
                    <td colspan="5">购买的总金额是：<%= orders.get(0).getTotalPrice() %> 总数量是：<%= count %></td>
                </tr>
                <form action="/order" method="post">
                    <table class="table table-bordered">
                        <tr>
                            <td>下单用户：</td>
                            <td><%= orders.get(0).getUsername()%></td>
                        </tr>
                        <tr>
                            <td>下单时间：</td>
                            <td><%= orders.get(0).getSubmitTime()%></td>
                        </tr>
                        <tr>
                            <td>交货时间：</td>
                            <td><%= orders.get(0).getConsignmentTime()%></td>
                        </tr>
                        <tr>
                            <td>总金额：</td>
                            <td><%= orders.get(0).getTotalPrice()%></td>
                        </tr>
                        <tr>
                            <td>下单地址：</td>
                            <td><%= orders.get(0).getAddress()%></td>
                        </tr>
                        <tr>
                            <td>用户备注：</td>
                            <td><%= orders.get(0).getContent() %></td>
                        </tr>
                        <tr>
                            <td>是否付款：</td>
                            <td>
                                <input type="radio" name="isPay" value="是">是
                                <input type="radio" name="isPay" value="否" checked="checked">否
                            </td>
                        </tr>
                        <tr>
                            <td>是否交货：</td>
                            <td>
                                <input type="radio" name="isSales" value="是">是
                                <input type="radio" name="isSales" value="否" checked="checked">否
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><button type="submit" class="btn btn-primary">更新</button></td>
                        </tr>

                        <input type="hidden" name="indentNo" value="<%= orders.get(0).getIndentNo() %>">
                        <input type="hidden" name="status" value="updateOrder">
                    </table>
                </form>
                <a href="/admin/orderlist.jsp">关闭窗口</a>
            </table>
        </div>
    </div>
</div>
</body>
</html>
