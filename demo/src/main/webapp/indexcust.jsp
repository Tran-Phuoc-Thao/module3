<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 13/03/2023
  Time: 7:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customer" method="get">
  <h1 style="text-align: center">DANH SÁCH KHÁCH HÀNG</h1>
  <hr>

  <table style="margin: auto">
      <tr>
        <th style="width: 100px;height: auto">Tên</th>
        <th style="width: 100px;height: auto">Ngày Sinh</th>
        <th style="width: 100px;height: auto">Địa Chỉ</th>
        <th style="width: 100px;height: auto">Ảnh</th>
      </tr>
      <tr>
          <td colspan="4"><hr></td>
      </tr>
      <c:forEach items="${list}" var="l">
      <tr>
         <td>${l.ten}</td>
         <td>${l.ngaySinh}</td>
         <td>${l.diaChi}</td>
         <td><img src="${l.anh}" style="width: 100px;height: 50px"></td>
      </tr>
      <tr>
          <td colspan="4"><hr></td>
      </tr>
      </c:forEach>



  </table>
</form>
</body>
</html>
