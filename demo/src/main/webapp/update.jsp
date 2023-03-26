<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 20/03/2023
  Time: 6:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="delete" method="post">
    <h1>${product.id}</h1>
    <table>

        <tr>
            <td><input type="hidden" value="${product.id}"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Gia</td>
            <td><input type="text" name="gia" /></td>
        </tr>
        <tr>
            <td>Anh</td>
            <td><input type="text" name="anh"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="submit2" style="width: 214px"></td>
        </tr>
    </table>
        <input type="hidden" name="action" value="update">
</form>
</body>
</html>
