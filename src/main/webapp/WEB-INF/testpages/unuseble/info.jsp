<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="a" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customers</title>
    <link href="../../../resources/newstyle.css" rel="stylesheet">
</head>
<body>
<header>
    <div class="logo">
        <img src="https://dummyimage.com/200x70/0656b8/ffffff.png&text=MarketPlace">
    </div>
    <div class="topbar">
        <h3 style="padding-left: 20px;">Welcome to marketplace by Avanesyan Armen and Ermolaev Alexander</h3>
    </div>
</header>
<main>
    <div style="display: inline-block" >
        <ul type="none" class="leftbar">
            <a href="<a:url value="/myitems"/>" class="ahrefstyle"><li class="bottomline">My Page</li></a>
            <a href="<a:url value="/cart"/>"  class="ahrefstyle"><li class="bottomline">My cart</li></a>
            <a href="<a:url value="/additem"/>" class="ahrefstyle"><li class="bottomline">Add item</li></a>
            <a href="<a:url value="/logout"/>" class="ahrefstyle"><li class="bottomline">Logout</li></a>
        </ul>
    </div>
    <div class="maindivstyle">
        <div style="margin-left: 20px" >
            <table border="1" class="tablemain" >
                <tbody >
                <tr class="titlerow">
                    <td  height="40px" align="middle">ID</td>
                    <td  align="middle">Login</td>
                    <td  align="middle">Password</td>
                </tr>
                <c:forEach items="${customers}" var="customer">
                    <tr class="restrows">
                        <td align="middle"><c:out value="${customer.id}"/></td>
                        <td align="middle"><c:out value="${customer.login}"/></td>
                        <td align="middle"><c:out value="${customer.password}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
</body>
</html>

