<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 18.05.2017
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div>
    <h1>Registration page</h1>
    <form name='f' action="/registration" method="post">
        <table border="0" cellpadding="5" cellspacing="0">
            <tr>
                <td>Your login:   </td>
                <td><input type='text' name='j_username' value=''></td>
            </tr>
            <tr>
                <td>Your password:</td>
                <td><input type='password' name='j_password' /></td>
            </tr>

            <tr>
                <td colspan='2'>
                    <input name="Enter" type="submit" value="Sign up" />
                </td>
            </tr>

        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />

    </form>
</div>
</body>
</html>
