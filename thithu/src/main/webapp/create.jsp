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
        <a href="NhanVien?action=NhanVien">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Nhan Vien</h2>
            </caption>
            <tr>
                <th> Ma Nhan Vien:</th>
                <td>
                    <input type="text" name="maNhanVien"  size="45"/>
                </td>
            </tr>
            <tr>
                <th>Họ Tên:</th>
                <td>
                    <input type="text" name="hoTen"  size="45"/>
                </td>
            </tr>
            <tr>
                <th>Ngày Sinh:</th>
                <td>
                    <input type="text" name="ngaySinh"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>Địa Chỉ:</th>
                <td>
                    <input type="text" name="diaChi"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>Ngày Bắt Đầu:</th>
                <td>
                    <input type="text" name="ngayBatDau"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>Ngày Kết Thúc:</th>
                <td>
                    <input type="text" name="ngayKetThuc"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>Lương:</th>
                <td>
                    <input type="text" name="luong"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>Công Việc:</th>
                <td>
                    <select name="maCongViec">
                        <c:forEach items="${listCongViec}" var="congViec">
                            <option value="${congViec.maCongViec}"><c:out value="${congViec.tenCongViec}"></c:out></option>
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