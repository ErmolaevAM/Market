<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marketplace: my cart</title>
    <link href="../../resources/newstyle.css" rel="stylesheet">
</head>
<body>
<header>
    <div class="logo">
        <img src="https://dummyimage.com/200x70/0656b8/ffffff.png&text=MarketPlace">
    </div>
    <div class="topbar">
        <h3 style="padding-left: 20px; display: inline-block;">Welcome to marketplace by Avanesyan and Ermolaev</h3>
        <h3 style="display: inline-block; float: right">You sign in as: ${username}</h3>
    </div>
</header>
<main>
    <div style="display: inline-block">
        <ul type="none" class="leftbar">
            <a href="<a:url value="/allitems"/>" class="ahrefstyle">
                <li class="bottomline">All items</li>
            </a>
            <a href="<a:url value="/myitems"/>" class="ahrefstyle">
                <li class="bottomline">My items</li>
            </a>
            <a href="<a:url value="/additem"/>" class="ahrefstyle">
                <li class="bottomline">Add item</li>
            </a>
            <a href="<a:url value="/logout"/>" class="ahrefstyle">
                <li class="bottomline">Logout</li>
            </a>
        </ul>
    </div>
    <div class="maindivstyle">
        <div style="margin-left: 20px">
            <table border="1" class="tablemain">
                <tbody>
                <tr class="titlerow">
                    <td height="40px" align="middle">Name</td>
                    <td align="middle">Description</td>
                    <td align="middle">Price</td>
                    <td align="middle">Seller</td>
                </tr>
                <c:forEach items="${cartitems}" var="items">
                    <tr class="restrows">
                        <td align="middle"><c:out value="${items.name}"/></td>
                        <td align="middle"><c:out value="${items.description}"/></td>
                        <td align="middle"><c:out value="${items.price}"/></td>
                        <td align="middle"><c:out value="${items.seller.login}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
</body>
</html>
