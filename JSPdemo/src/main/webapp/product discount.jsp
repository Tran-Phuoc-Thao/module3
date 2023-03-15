<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 10/03/2023
  Time: 8:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/productdiscount" method="post">
    <h1>
        product discount calculator
    </h1>
    <table>
        <tr>
            <td style="font-weight: bold">Mô Tả Sản Phẩm</td>
            <td><input type="text" name="mota" placeholder="Nhập mô tả sản phẩm"></td>
        </tr>
        <tr>
            <td style="font-weight: bold">Giá niêm yết của sản phẩm</td>
            <td><input type="text" name="gianiemyet" placeholder="Giá niêm yết"></td>
        </tr>
        <tr>
            <td style="font-weight: bold">Tỷ lệ chiết khấu(%)</td>
            <td><input type="text" name="chietkhau" placeholder="Nhập % chiết khấu"></td>
        </tr>
        <input type = "submit" id = "submit" value = "productdiscount"/>
    </table>
</form>
</body>
</html>
