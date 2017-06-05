<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>My Items</title>
</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <h2>Welcome ${pageContext.request.userPrincipal.name} | <a
            onclick="document.forms['logoutForm'].submit()">Logout</a>
    </h2>
</c:if>
<h1>My Items</h1>
<div class="table-responsive">
    <table class="table">
        <tr>
            <th width="100">Title</th>
            <th width="200">Description</th>
            <th width="50">Start Price</th>
            <th width="50">Time Left</th>
            <th width="100">Start Bidding Day</th>
            <th width="170">Buy It Now</th>
            <th width="50">Bid Increment</th>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
                <td><c:out value="${item.title}"/></td>
                <td><c:out value="${item.description}"/></td>
                <td><c:out value="${item.startPrice}"/></td>
                <td><c:out value="${item.timeLeft}"/></td>
                <td><c:out value="${item.startBiddingDay}"/></td>
                <td><c:out value="${item.buyItNow}"/></td>
                <td><c:out value="${item.bidIncrement}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>