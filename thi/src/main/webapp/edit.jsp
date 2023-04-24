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
                <h2>
                    Edit
                </h2>
            </caption>
            <tr>
                <th> Ma Nhan Vien:</th>
                <td>
                    <input type="text" name="maNhanVien"  size="45"
                    value="<c:out value='${nhanVien.maNhanVien}'/>"
                    />
                </td>
            </tr>
<%--            <td><c:out value="${l.maNhanVien}"/></td>--%>
<%--            <td><c:out value="${l.hoTen}"/></td>--%>
<%--            <td><c:out value="${l.ngaySinh}"/></td>--%>
<%--            <td><c:out value="${l.diaChi}"/></td>--%>
<%--            <td><c:out value="${l.ngayBatDau}"/></td>--%>
<%--            <td><c:out value="${l.ngayKetThuc}"/></td>--%>
<%--            <td><c:out value="${l.luong}"/></td>--%>
<%--            <td><c:out value="${l.congViec.tenCongViec}"/></td>--%>
<%--            <td><c:out value="${l.congViec.luongThapNhat}"/></td>--%>
<%--            <td><c:out value="${l.congViec.luongCaoNhat}"/></td>--%>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="hoTen" size="45"
                           value="<c:out value='${nhanVien.hoTen}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>ngaySinh:</th>
                <td>
                    <input type="text" name="ngaySinh" size="45"
                           value="<c:out value='${nhanVien.ngaySinh}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>diaChi:</th>
                <td>
                    <input type="text" name="diaChi" size="45"
                           value="<c:out value='${nhanVien.diaChi}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>ngayBatDau:</th>
                <td>
                    <input type="text" name="ngayBatDau" size="45"
                           value="<c:out value='${nhanVien.ngayBatDau}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>ngayKetThuc:</th>
                <td>
                    <input type="text" name="ngayKetThuc" size="45"
                           value="<c:out value='${nhanVien.ngayKetThuc}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>luong:</th>
                <td>
                    <input type="text" name="luong" size="45"
                           value="<c:out value='${nhanVien.luong}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>maCongViec:</th>
                <td>
                    <input type="text" name="maCongViec" size="45"
                           value="<c:out value='${nhanVien.congViec.maCongViec}' />"
                    />
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