<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 19.05.2017
  Time: 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Marketplace: add item</title>
</head>
<body>
<div>
    <h1>Add your item...</h1>

    <form action="/additem" method="post">
        <table border="0" cellpadding="5" cellspacing="0">
            <tr>
                <td>Title</td>
                <td><input type="text" name="item_title" value=""/></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" name="item_price" value=""/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input name="AddItem" type="submit" value="Add item"/>
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
