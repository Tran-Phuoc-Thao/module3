<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 07/06/2023
  Time: 8:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="tinhTien" method="post">
    <caption style="margin: auto">Chuyển Đổi Tiền Tệ</caption>
    <table>
        <tr>
            <td>
                Tiền Việt Nam :
            </td>
            <td>
                <input type="text" name="inputTien">
            </td>
        </tr>
        <tr>
            <td>
                Tiền Cần Chuyển :
            </td>
            <td>
                <select name="outputTien">
                    <option value="22">USD</option>
                    <option value="25">EURO</option>
                    <option value="16">JPY(Yen Nhat)</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
            <button type="submit">submit</button>
            </td>
        </tr>
        <c:if test="${ketQua != null}">
            <tr>
                <td>
                ${ketQua}
                </td>
            </tr>
        </c:if>


    </table>
</form>
</body>
</html>
