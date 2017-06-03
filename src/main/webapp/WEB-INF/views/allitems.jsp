<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 03.06.2017
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Marketplace: all items</title>
</head>
<body>
<h2>Welcome to marketplace by Avanesyan Armen and Ermolaev Alexander</h2>
<div>
    <div style="display: block">
        <a href="<a:url value="/myitems"/>" style=" display: inline-block; margin-left: 10px ">My Page</a>
        <a href="<a:url value="/cart"/>" style=" display: inline-block; margin-left: 10px ">My cart</a>
        <a href="<a:url value="/additem"/>" style=" display: inline-block; margin-left: 10px ">Add item</a>
        <a href="<a:url value="/logout"/>" style=" display: inline-block; margin-left: 10px ">Logout</a>
        <p href="" style="float: right; display: inline-block">Userlogin</p>

    </div>
    <br>
    <div style="display: block">
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th width="200">Name</th>
                <th width="200">Description</th>
                <th width="200">Price</th>
                <th width="200">Seller</th>
            </tr>

            <c:forEach items="${allitems}" var="items">
                <tr>
                    <td><c:out value="${items.name}"/></td>
                    <td><c:out value="${items.description}"/></td>
                    <td><c:out value="${items.price}"/></td>
                    <td><c:out value="${items.seller}"/></td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
