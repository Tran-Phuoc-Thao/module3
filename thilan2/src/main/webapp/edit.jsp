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
        <a href="/Product?action=Product">List All Users</a>
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
                <th> id :</th>
                <td>
                    <input type="text" name="id"  size="45"
                    value="<c:out value='${product.id}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Ten San Pham :</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${product.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>gia :</th>
                <td>
                    <input type="text" name="gia" size="45"
                           value="<c:out value='${product.gia}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>so luong:</th>
                <td>
                    <input type="text" name="soLuong" size="45"
                           value="<c:out value='${product.soLuong}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>mau sac:</th>
                <td>
                    <input type="text" name="mauSac" size="45"
                           value="<c:out value='${product.mauSac}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>mo ta :</th>
                <td>
                    <input type="text" name="moTa" size="45"
                           value="<c:out value='${product.moTa}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>maCongViec:</th>
                <td>
                    <input type="text" name="idType" size="45"
                           value="<c:out value='${product.category.idType}' />"
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