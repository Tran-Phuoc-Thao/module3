create database furamaResort;
create table vi_tri(
 maViTri int,
 tenViTri nvarchar(45),
 constraint pk_primary_vitri primary key (maViTri)
);
create table trinhDo(
 matrinhdo int,
 tentrinhdo nvarchar(45),
 constraint pk_primary_trinhdo primary key (matrinhdo)
 );
 create table loaikhach(
 maloaikhach int,
 tenloaikhach nvarchar(45),
 constraint pk_primary_loaikhach primary key (maloaikhach)
 );
 create table boPhan(
 mabophan int,
 tenbophan nvarchar(45),
 constraint pk_primary_bophan primary key(mabophan)
 );
 create table loaidichvu(
 maloaidichvu int,
tenloaidichvu nvarchar(45),
constraint pk_primary_loaidichvu primary key(maloaidichvu)
 );
 create table kieuthue(
 makieuthue int ,
 tenkieuthue nvarchar(45),
 constraint pk_primary_kieuthue primary key(makieuthue)
 );
 create table nhanvien(
 manhanvien int,
 hotennhanvien nvarchar(45),
 ngaysinh date,
 socmnd varchar(45),
 luong double,
 sodienthoai varchar(45),
 email varchar(45),
 diachi varchar(45),
 mavitri int,
 matrinhdo int,
 mabophan int,
 constraint pk_nhanvien primary key (manhanvien),
 constraint foreign key fk_nhanvien1(mavitri) references vi_tri(maViTri),
 constraint foreign key fk_nhanvien2(matrinhdo) references trinhDo(matrinhdo),
 constraint foreign key fk_nhanvien3(mabophan) references boPhan(mabophan)
 );
 create table khachhang(
 makhachhang int,
 maloaikhachhang int,
 hotenkhachhang nvarchar(45),
 ngaysinh date,
 gioitinh bit(1),
 socmndkhachhang nvarchar(45),
 sodienthoai nvarchar(45),
 emailkhachhang nvarchar(45),
 diachikhachhang nvarchar(45),
 constraint  primary key (makhachhang),
 constraint  foreign key (maloaikhachhang) references loaikhach(maloaikhach)
 );
 create table dichvu(
 madichvu int,
 tendichvu nvarchar(45),
 dientich int,
 chiphithue double,
 songuoitoida int,
 makieuthue int,
 maloaidichvu int,
 tieuchuanphong nvarchar(10),
 motatiennghikhac nvarchar(45),
 dientichhoboi double,
 sotang int,
 constraint  primary key (madichvu),
 constraint  foreign key (makieuthue) references kieuthue(makieuthue),
 constraint  foreign key (maloaidichvu) references loaidichvu(maloaidichvu)
 );
  create table hopdongfurama(
 mahopdong int,
 ngaylamhopdong datetime,
 ngayketthuc datetime,
 tiendatcoc double,
 manhanvien int,
 makhachhang int,
 madichvu int,
 constraint pk_hopdong primary key (mahopdong),
 constraint foreign key (manhanvien) references nhanvien(manhanvien),
 constraint foreign key (makhachhang) references khachhang(makhachhang),
 constraint foreign key (madichvu) references dichvu(madichvu)
 );
 create table dichvudikem(
 madichvudikem int,
 tendichvudikem nvarchar(45),
 gia double,
 donvi varchar(35),
 trangthai varchar(45),
 constraint primary key(madichvudikem)
 );
  create table hopdongchitiet(
 mahopdongchitiet int,
 mahopdong int,
 madichvudikem int,
 soluong int,
 constraint  primary key(mahopdongchitiet),
 constraint  foreign key(mahopdong) references hopdongfurama(mahopdong),
 constraint  foreign key(madichvudikem) references dichvudikem(madichvudikem)
 );
 insert into vi_tri(maViTri,tenViTri)
 values(1,'giám đốc'),
		(2,'quản lí'),
        (3,'giám sát'),
        (4,'chuyên viên'),
        (5,'phục vụ'),
        (6,'lễ tân');
insert  into trinhDo(matrinhdo,tentrinhdo)
	values(1,'trung cấp'),
		  (2,'cao đẳng'),
		  (3,'đại học'),
		  (4,'sau đại học');
 insert into loaikhach(maloaikhach,tenloaikhach)
 VALUES  (1,'Diamond'),
		(2,'Platinium'),
		(3,'Gold'),
		(4,'Silver'),
		(5,'Member');
 insert into  khachhang (makhachhang,hotenkhachhang,ngaysinh,gioitinh,socmndkhachhang,sodienthoai,emailkhachhang,diachikhachhang,maloaikhachhang)
 VALUES 	 (1,'Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
         (2,'Trần Cao Vân','1990-4-12',1,'488641231','031238123','vancao2702@gmail.com','K67/47 Hà Huy Tập, Đà Nẵng',2),
         (3,'Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
		 (4,'Nguyễn Văn Chí','1990-5-11',1,'4886712393','09123712321','chinguyen123@gmail.com','Nguyễn Văn Cừ, Hà Nội',1),
         (5,'Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
         (6,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
         (7,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
         (8,'Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
         (9,'Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1);
insert into boPhan(mabophan,tenbophan)
VALUES 	(1,'Sale-Marketing'),
		(2,'Hành Chính'),
		(3,'Phục Vụ'),
		(4,'Quản Lý');
 insert into kieuthue(makieuthue,tenkieuthue)
 VALUES (1,'year'),
	   (2,'month'),
	   (3,'day'),
	   (4,'hour');
insert into loaidichvu(maloaidichvu,tenloaidichvu)
VALUES  (1,'Villa'),
		(2,'House'),
		(3,'Room');   
insert into nhanvien(manhanvien,hotennhanvien,ngaysinh,socmnd,luong,sodienthoai,email,diachi,mavitri,matrinhdo,mabophan)     
VALUES  (1, 'Nguyễn Ngọc Trung Bảo', '2003-6-25', '206493602', 1000, '0389056171', 'baokx2k3@gmail.com', 'Thăng Bình', 1, 4, 4 ),
		(2, 'Nguyễn Ngọc Huy Bảo', '2003-6-25', '206493603', 800, '0329002453', 'hbkx22kx3@gmail.com', 'Thăng Bình', 3, 2, 1 ),
        (3, 'Huỳnh Văn Nam', '2003-3-10', '206493154', 1000, '0321724124', 'namhuynh@gmail.com', 'Thăng Bình', 2, 1, 4 ),
        (4, 'Phạm Nguyễn Trường Tín', '2003-5-12', '206412171', 900, '0312388242', 'tinpham@gmail.com', 'Núi Thành', 4, 1, 2 ),
		(5, 'Võ Nguyễn Phát', '2003-6-19', '206492131', 1100, '0312324912', 'phatvo@gmail.com', 'Nông Sơn', 1, 3, 4 ),
		(6, 'Dương Tấn Tài', '2003-2-12', '206437123', 500, '0342417234', 'taiduong@gmail.com', 'Duy Xuyên', 6, 1, 1 ),
		(7, 'Trần Công Nhật', '2003-11-8', '206812337', 650, '0981234412', 'nhattran@gmail.com', 'Phú Ninh', 5, 2, 3 ),
		(8, 'Nguyễn Đức Việt', '2003-4-12', '206781231', 480, '0931231284', 'vietnguyen@gmail.com', 'Thăng Bình', 6, 1, 4 ),
		(9, 'Ngô Ngọc Huy', '2003-9-11', '206152351', 700, '09137127312', 'huyngo@gmail.com', 'Núi Thành', 3, 1, 4 ),
		(10, 'Kiều Nhật Tân', '2003-10-12', '206812312', 800, '0313192412', 'tankieu@gmail.com', 'Thăng Bình', 4, 2, 4 ),
		(11, 'Phạm Thị Thuý Hằng', '2003-5-24', '206123144', 800, '0283183211', 'hangpham@gmail.com', 'Thăng Bình', 5, 2, 3);
insert into dichvu(madichvu,tendichvu,dientich,chiphithue,songuoitoida,tieuchuanphong,motatiennghikhac,dientichhoboi,sotang,makieuthue,maloaidichvu)
VALUES  (1,'Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1),
		(2,'House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',NULL,3,2,2),
		(3,'Room Twin 01',5000,1000000,2,'normal','Có tivi',NULL,NULL,4,3),
		(4,'Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1),
		(5,'House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',NULL,2,3,2),
		(6,'Room Twin 02',3000,900000,2,'normal','Có tivi',NULL,NULL,4,3);
select * from dichvu;
insert into hopdongfurama(mahopdong,ngaylamhopdong,ngayketthuc,tiendatcoc,manhanvien,makhachhang,madichvu)
VALUES  (1,'2020-12-08','2020-12-08',0,3,1,3),
		(2,'2020-07-14','2020-07-21',200000,7,3,1),
		(3,'2021-03-15','2021-03-17',50000,3,4,2),
		(4,'2021-01-14','2021-01-18',100000,7,5,5),
		(5,'2021-07-14','2021-07-15',0,7,2,6),
		(6,'2021-06-01','2021-06-03',0,7,7,6),
		(7,'2021-09-02','2021-09-05',100000,7,4,4),
		(8,'2021-06-17','2021-06-18',150000,3,4,1),
		(9,'2020-11-19','2020-11-19',0,3,4,3),
		(10,'2021-04-12','2021-04-14',0,10,3,5),
		(11,'2021-04-25','2021-04-25',0,2,2,1),
		(12,'2021-05-25','2021-05-27',0,7,8,1);
select * from hopdongfurama;
insert into dichvudikem(madichvudikem,tendichvudikem,gia,donvi,trangthai)
VALUES  (1,'Karaoke',10000,'giờ','tiện nghi, hiện tại'),
		(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
		(3,'Thuê xe đạp',20000,'chiếc','tốt'),
		(4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
		(5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
		(6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');
select * from dichvudikem;
insert into hopdongchitiet(mahopdongchitiet,soluong,mahopdong,madichvudikem)
VALUES  (1,5,2,4),
		(2,8,2,5),
		(3,15,2,6),
		(4,1,3,1),
		(5,11,3,2),
		(6,1,1,3),
		(7,2,1,2),
		(8,2,12,2);