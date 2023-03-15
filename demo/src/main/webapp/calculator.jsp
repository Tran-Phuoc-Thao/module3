
<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 15/03/2023
  Time: 7:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator" method="post">
  <h1>SIMPLE CALCULATOR</h1>
  <table>
    <tr>
      <td>A</td>
      <td><input type="text" name="a" placeholder="Nhap a" ></td>
    </tr>
    <tr>
      <td colspan="2" >
        <select name="pheptoan" style="width: 200px;height: 25px;text-align: center;font-size: 20px">
        <option value="1">Cong</option>
        <option value="2">Tru</option>
        <option value="3">Nhan</option>
        <option value="4">Chia</option>
      </select></td>
    </tr>
    <tr>
      <td>B</td>
      <td><input type="text" name="b" placeholder="Nhap b"></td>
    </tr>
    <tr>
      <td colspan="2"><button type="submit" style="width: 200px;height: 25px">Tinh</button></td>
    </tr>

  </table>

</form>
</body>
</html>
