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
<form method="post">
  <table style="margin: auto">
      <tr>
        <th style="width: 100px;height: auto">ID</th>
        <th style="width: 100px;height: auto">TÊN</th>
        <th style="width: 100px;height: auto">GIÁ</th>
        <th style="width: 100px;height: auto">Ảnh</th>
      </tr>
      <tr>
        <td colspan="4"><hr></td>
      </tr>
        <tr>
            <td><input name="id" value="${product.id}"></td>
            <td>${product.ten}</td>
            <td>${product.gia}</td>
            <td><img src="${product.hinhAnh}" style="width: 100px;height: 50px"></td>
        </tr>
        <tr>
          <td colspan="4"><hr></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Delete" name="action" style="width: 214px"></td>
        </tr>

  </table>
    <input type="hidden" name="action" value="delete">
</form>
</body>
</html>
