<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Customers</title>
</head>
<body>
<div>

    <h1>Hello world</h1>

    <table>
        <tr>
            <th width="200">Id</th>
            <th width="200">Login</th>
            <th width="200">Password</th>
        </tr>

        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td><c:out value="${customer.login}"/></td>
                <td><c:out value="${customer.password}"/></td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
