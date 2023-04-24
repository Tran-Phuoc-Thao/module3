<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 27/03/2023
  Time: 6:02 CH
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
    <h1> Management</h1>
    <h2>
        <a href="/NhanVien?action=create">Add New NhanVien</a>
    </h2>
    <form action="/NhanVien" method="get" >
        <table style="margin: auto">
            <tr>
                <th>Search by maNhanVien</th>
                <th>Search by hoTen</th>
            </tr>
            <tr>
                <td><input type="text" name="maNhanVien"  size="45"/></td>
                <td><input type="text" name="hoTen"  size="45"/></td>
                <td><input type="submit" value="search" name="action"/></td>
            </tr>

        </table>
    </form>
</center>
<div align="center">

    <table border="1" cellpadding="5">
        <caption><h2>List of NhanVien</h2></caption>
        <tr>
            <th>Ma Nhan Vien</th>
            <th>Ho Ten</th>
            <th>Ngay Sinh</th>
            <th>Dia Chi</th>
            <th>Ngay Bat Dau</th>
            <th>Ngay Ket Thuc</th>
            <th>Luong</th>
            <th>Ten Cong Viec</th>
            <th>Luong Thap Nhat</th>
            <th>Luong Cao Nhat</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="l" items="${list}">
            <tr>
                <td><c:out value="${l.maNhanVien}"/></td>
                <td><c:out value="${l.hoTen}"/></td>
                <td><c:out value="${l.ngaySinh}"/></td>
                <td><c:out value="${l.diaChi}"/></td>
                <td><c:out value="${l.ngayBatDau}"/></td>
                <td><c:out value="${l.ngayKetThuc}"/></td>
                <td><c:out value="${l.luong}"/></td>
                <td><c:out value="${l.congViec.tenCongViec}"/></td>
                <td><c:out value="${l.congViec.luongThapNhat}"/></td>
                <td><c:out value="${l.congViec.luongCaoNhat}"/></td>
                <td>
                    <a href="/NhanVien?action=edit&id=${l.maNhanVien}">Edit</a>
                    <a href="/NhanVien?action=delete&id=${l.maNhanVien}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>