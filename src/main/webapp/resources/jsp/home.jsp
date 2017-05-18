<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<div>
    <div>
        <table>
            <tr>
                <td><h1>Welcome to market place by ermolaxe...</h1></td>
                <td>
                    <form action="/logout" method="get">
                        <button>Logout</button>
                    </form>
                </td>
                <td>
                    <form action="/additem" method="get">
                        <button>Add item</button>
                    </form>
                </td>
            </tr>
        </table>
    </div>

    <table border="2" cellpadding="2">
        <tr>
            <th>Title</th>
            <th>Price</th>
            <th>Is bought</th>
            <th>Buyer</th>
        </tr>
        <c:forEach var="item" items="${itemList}">
            <tbody>
            <td>${item.getTitle()}</td>
            <td>${item.getPrice()}</td>
            <td>${item.isBought()}</td>
            <td>${item.getBuyer()}</td>
            </tbody>
        </c:forEach>
    </table>

</div>




</body>
</html>
