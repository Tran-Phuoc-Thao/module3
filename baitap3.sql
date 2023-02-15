-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order 
SELECT oID, oDate, oTotalPrice FROM orders;
-- Hiển thị danh sách các khách hàng đã mua hàng
SELECT * FROM customer INNER JOIN orders
ON customer.cID = orders.cID;
-- Hiển thị danh sách sản phẩm được mua bởi các khách
SELECT * FROM product INNER JOIN orderdetail
ON product.pID = orderdetail.pID;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn
SELECT orders.oID AS'Mã hóa đơn', orders.oDate AS'Ngày mua', sum(product.pPrice*orderdetail.odQTY) AS'Tổng tiền' FROM orders
INNER JOIN orderdetail ON orderdetail.oID = orders.oID
INNER JOIN product ON product.pID = orderdetail.pID
GROUP BY orders.oID;