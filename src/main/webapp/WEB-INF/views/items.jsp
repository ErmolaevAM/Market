<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 02.06.2017
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
</head>
<body>
    <h1>Hello world</h1>

    <table>
        <tr>
            <th width="200">Id</th>
            <th width="200">Name</th>
            <th width="200">Description</th>
            <th width="200">Price</th>
            <th width="200">Buyer</th>
            <th width="200">Seller</th>
            <th width="200">Is sold</th>
        </tr>

        <c:forEach items="${items}" var="item">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.description}"/></td>
                <td><c:out value="${item.price}"/></td>
                <td><c:out value="${item.buyer.login}"/></td>
                <td><c:out value="${item.seller.login}"/></td>
                <td><c:out value="${item.sold}"/></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
