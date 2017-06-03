<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 03.06.2017
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to marketplace</title>
</head>
<body>

<div>
    <h1>Marketplace</h1>
    <h3>Enter your login and password</h3>

    <%--<c:url value="/j_spring_security_check" var="loginUrl"/>--%>
    <form name="loginform" action="${loginUrl}" method="post">
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <td>Title:   </td>
                <td><input type='text' name='j_title' value=''></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type='password' name='j_description' /></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type='password' name='j_price' /></td>
            </tr>

            <tr>
                <td colspan='2'>
                    <input name="Enter" type="submit" value="Enter"/>
                </td>
            </tr>
        </table>

        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
    </form>

</div>

</body>
</html>
