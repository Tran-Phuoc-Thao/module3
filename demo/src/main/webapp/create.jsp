<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 18/03/2023
  Time: 1:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create student</h1>
<form method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" /></td>
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
            <td colspan="2"><input type="submit" name="submit1" style="width: 214px"></td>
        </tr>
    </table>
<%--    <input type="hidden" name="action" value="create">--%>
</form>
</body>
</html>
