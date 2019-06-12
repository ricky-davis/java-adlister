<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rdavis
  Date: 2019-06-12
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Ads Listing" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />
    <ul>
        <c:forEach items="${ads}" var="i">
            <li>
                <ul>
                    <li>ID: ${i.id}</li>
                    <li>Title: ${i.title}</li>
                    <li>Description: ${i.description}</li>
                    <li>Author: ${i.userId}</li>
                </ul>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
