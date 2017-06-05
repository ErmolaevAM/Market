<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marketplace: registration</title>
    <link href="../../resources/newstyle.css" rel="stylesheet">
</head>
<body>
<header>
    <div class="logo">
        <img src="https://dummyimage.com/200x70/0656b8/ffffff.png&text=MarketPlace">
    </div>
</header>
<main>
    <div class="maindivstyle">
        <div>
            <h3>Enter your login and password</h3>
            <form  name="loginform" action="${loginUrl}" method="post">
                <table border="1" cellpadding="5" cellspacing="0" class="tablemain" style="width: 350px">
                    <tr class="titlerow">
                        <td>Login:   </td>
                        <td ><input  type='text' name='j_username' value=''></td>
                    </tr>
                    <tr class="titlerow">
                        <td>Password:</td>
                        <td><input type='password' name='j_password' /></td>
                    </tr>
                    <tr class="titlerow">
                        <td>Confirm password:</td>
                        <td><input type='password' name='j_confirm_password' /></td>
                    </tr>
                    <tr class="titlerow">
                        <td align="middle" colspan='2'>
                            <input  name="Enter" type="submit" value="Enter"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</main>
</body>
</html>

