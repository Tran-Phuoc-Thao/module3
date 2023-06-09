<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<h1>Create new product</h1>
<c:if test="${error != null}">
    <h2 style="color: red">${error}</h2>
</c:if>
<form action="/product" method="post">
    <table>
        <tr>
            <td>ID: </td>
            <td><input type="number" name="id" /></td>
        </tr>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Price: </td>
            <td><input type="number" name="price" /></td>
        </tr>
        <tr>
            <td>Quantity:</td>
            <td><input type="number" name="quantity"></td>
        </tr>
        <tr>
            <td>Origin</td>
            <td><input type="text" name="origin"></td>
        </tr>
        <tr>
            <td><input type="reset" value="Reset"/></td>
            <td><input type="submit" value="Create"/></td>
        </tr>
    </table>

</form>
</body>
</html>
