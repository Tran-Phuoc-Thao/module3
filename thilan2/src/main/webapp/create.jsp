<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 27/03/2023
  Time: 8:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="Product?action=Product">List All</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th> name:</th>
                <td>
                    <input type="text" name="name"  size="45"/>
                </td>
            </tr>
            <tr>
                <th>gia:</th>
                <td>
                    <input type="text" name="gia"  size="45"/>
                </td>
            </tr>
            <tr>
                <th>So Luong:</th>
                <td>
                    <input type="text" name="soLuong"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>Mau Sac:</th>
                <td>
                    <input type="text" name="mauSac"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>Mo Ta:</th>
                <td>
                    <input type="text" name="moTa"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>Danh Muc:</th>
                <td>
                    <select name="idType">
                        <c:forEach items="${list}" var="congViec">
                            <option value="${congViec.idType}"><c:out value="${congViec.name}"></c:out></option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>