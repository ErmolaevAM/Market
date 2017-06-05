<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marketplace: add your items</title>
    <link href="../../resources/newstyle.css" rel="stylesheet">
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
    <div style="display: inline-block">
        <ul type="none" class="leftbar">
            <a href="<a:url value="/allitems"/>" class="ahrefstyle">
                <li class="bottomline">All items</li>
            </a>
            <a href="<a:url value="/myitems"/>" class="ahrefstyle">
                <li class="bottomline">My items</li>
            </a>
            <a href="<a:url value="/cart"/>" class="ahrefstyle">
                <li class="bottomline">My cart</li>
            </a>
            <a href="<a:url value="/logout"/>" class="ahrefstyle">
                <li class="bottomline">Logout</li>
            </a>
        </ul>
    </div>
    <div class="maindivstyle">
        <div style="margin-left: 20px">
            <h3>Enter your product description</h3>
            <form name="loginform" action="${loginUrl}" method="post">
                <table border="1" cellpadding="5" cellspacing="0" class="tablemain" style="width: 350px">
                    <tr class="titlerow">
                        <td>Title:</td>
                        <td><input type='text' name='j_title' value=''></td>
                    </tr>
                    <tr class="titlerow">
                        <td>Description:</td>
                        <td><input type='text' name='j_description'/></td>
                    </tr>
                    <tr class="titlerow">
                        <td>Price:</td>
                        <td><input type='text' name='j_price'/></td>
                    </tr>
                    <tr class="titlerow">
                        <td colspan='2'>
                            <input name="Enter" type="submit" value="Enter"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</main>
</body>
</html>
