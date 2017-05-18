<%@ page import="ssu.edu.java.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<% User user = (User) request.getAttribute("user"); %>
<h2>Hello World! Alexey and Alexander</h2>
<div>
    <span>ID: </span> <% out.println(user.getId()); %>
    <div>
        <span>NAME: </span> <% out.println(user.getName()); %>
    </div>
</div>
</body>
</html>
