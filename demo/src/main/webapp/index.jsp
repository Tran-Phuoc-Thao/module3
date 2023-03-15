<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
            <td><input type="submit" value = "submit"/></td>
        </tr>
        <tr>
            <td>
                Giá Được Giảm
            </td>
            <td>
                Giá Phải Trả là
            </td>
        </tr>
        <tr>
            <td>
                ${lastprice}
            </td>
            <td>
                ${giaphaitra}
            </td>
        </tr>

    </table>
</form>
</body>
</html>