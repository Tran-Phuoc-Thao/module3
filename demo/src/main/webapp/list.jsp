<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 17/03/2023
  Time: 6:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>
<body>

<form action="/list" method="get">

    <h1 style="text-align: center">DANH SÁCH SẢN PHẨM</h1>
    <a href="/list?action=create" style="background: blue">CREATE</a>
    <hr>
    <table style="margin: auto">
        <tr>
            <th style="width: 100px;height: auto">ID</th>
            <th style="width: 100px;height: auto">TÊN</th>
            <th style="width: 100px;height: auto">GIÁ</th>
            <th style="width: 100px;height: auto">Ảnh</th>
            <th>UPDATE</th>
            <th>DELETE</th>
        </tr>
        <tr>
            <td colspan="4"><hr></td>
        </tr>
        <c:forEach items="${list}" var="l">
            <tr>
                <td>${l.id}</td>
                <td>${l.ten}</td>
                <td>${l.gia}</td>
                <td><img src="${l.hinhAnh}" style="width: 100px;height: 50px"></td>
                <td><a href="/list?action=update&id=${l.id}">UPDATE</a></td>
                <td><a href="/list?action=delete&id=${l.id}">DELETE</a></td>
            </tr>
            <tr>
                <td colspan="4"><hr></td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
