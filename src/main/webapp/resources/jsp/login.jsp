<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
</head>
<body>
<h1>Welcome to marketplace</h1>

<div>
    <h2>Enter your login and password</h2>
    <form name='f' action="/" method="post">
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
                    <input name="Enter" type="submit" value="Enter" />
                </td>
            </tr>
        </table>
        <%--<input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />--%>
    </form>
    <a href="/registration">Go to registration</a>
</div>

</body>
</html>