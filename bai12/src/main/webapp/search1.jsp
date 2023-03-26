<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 24/03/2023
  Time: 7:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <a href="users?action=users">List All Users</a>
</h2>
<form method="post" >
    <table style="margin: auto">
    <tr>
        <td>Search by name</td>
        <td><input type="text" name="name"></td>
        <td><input type="submit" value="SEARCH"></td>
    </tr>
    </table>
    <c:if test="${listUser != null}">
    <div align="center">

        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
            </tr>

            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </c:if>
</form>
</body>
</html>
