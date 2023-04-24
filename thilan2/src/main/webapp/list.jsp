
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1> Management</h1>
    <h2>
        <a href="/Product?action=create">Add New Product</a>
    </h2>
    <form action="/Product" method="get" >
        <table style="margin: auto">
            <tr>
                <th>Search by Name</th>
            </tr>
            <tr>
                <td><input type="text" name="name"  size="45"/></td>
                <td><input type="submit" value="search" name="action"/></td>
            </tr>

        </table>
    </form>
</center>
<div align="center">

    <table border="1" cellpadding="5">
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ID</th>
            <th>TEN SAN PHAM</th>
            <th>GIA</th>
            <th>SO LUONG</th>
            <th>MAU SAC</th>
            <th>MO TA</th>
            <th>DANH MUC</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="l" items="${list}">
            <tr>
                <td><c:out value="${l.id}"/></td>
                <td><c:out value="${l.name}"/></td>
                <td><c:out value="${l.gia}"/></td>
                <td><c:out value="${l.soLuong}"/></td>
                <td><c:out value="${l.mauSac}"/></td>
                <td><c:out value="${l.moTa}"/></td>
                <td><c:out value="${l.category.name}"/></td>
                <td>
                    <a href="/Product?action=edit&id=${l.id}">Edit</a>
                    <a href="/Product?action=delete&id=${l.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>