<%--
  Created by IntelliJ IDEA.
  User: rdavis
  Date: 2019-06-11
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username">
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <br>
        <button type="submit" id="submit">Submit</button>
    </form>
    <%
        if(request.getMethod().equalsIgnoreCase("post")){
            if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("password")){
                response.sendRedirect("/profile.jsp");
            }
        }
    %>
</body>
</html>
