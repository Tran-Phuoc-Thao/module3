-- cau 2
select * from nhanvien
where (hotennhanvien like 'H%' or hotennhanvien like 'T%' or hotennhanvien like 'K%')
and char_length(hotennhanvien) <= 15;

-- cau 3
select * from khachhang
where year(now()) - year(ngaysinh) between 18 and 50 
and diachikhachhang like '%Đà Nẵng' or diachikhachhang like '%Quảng Trị';

-- câu 4
select makhachhang,hotenkhachhang,count(makhachhang)
from khachhang kh inner join loaikhach lk on kh.maloaikhachhang = lk.maloaikhach
where tenloaikhach = 'Diamond'
group by makhachhang,hotenkhachhang
order by count(makhachhang) asc;

-- cau 5
select kh.makhachhang,hotenkhachhang,lk.tenloaikhach,hd.mahopdong,dv.tendichvu,hd.ngaylamhopdong,hd.ngayketthuc,chiphithue+soluong*gia as 'tongtien'
from hopdongfurama hd inner join khachhang kh on kh.makhachhang = hd.makhachhang
					  inner join dichvu dv on hd.madichvu = dv.madichvu
                      inner join hopdongchitiet hdct on hd.mahopdong = hdct.mahopdong
					  inner join dichvudikem dvdk on hdct.madichvudikem = dvdk.madichvudikem
					  inner join loaikhach lk on lk.maloaikhach = kh.maloaikhachhang;
                      
-- cau 6
select dv.madichvu,dv.tendichvu,dv.dientich,ldv.tenloaidichvu
from dichvu dv inner join loaidichvu ldv on dv.maloaidichvu = ldv.maloaidichvu
			   inner join hopdongfurama hd on hd.madichvu = dv.madichvu
where ngaylamhopdong not in (select ngaylamhopdong
							from hopdongfurama
                            where month(ngaylamhopdong) between 1 and 3 );		
                            
-- cau 7
select dv.madichvu,tendichvu,dientich,songuoitoida,chiphithue,tenloaidichvu
from dichvu dv inner join loaidichvu ldv on dv.maloaidichvu = ldv.maloaidichvu
			   inner join hopdongfurama hd on hd.madichvu = dv.madichvu
where year(ngaylamhopdong) = '2020' and year(ngaylamhopdong) not in (select ngaylamhopdong
																	 from hopdongfurama
                                                                     where year(ngaylamhopdong) = '2021') ;


-- cau 8
select distinct hotenkhachhang
from khachhang;

-- cau 9
select month(hd.ngaylamhopdong) AS thang,
count(kh.makhachhang) AS so_khach_hang_dat_phong
from khachhang kh inner join hopdongfurama hd on kh.makhachhang = hd.makhachhang
where year(hd.ngaylamhopdong) = '2021'
group by thang;
     
-- cau 10
select hd.mahopdong,ngaylamhopdong,ngayketthuc,tiendatcoc,sum(soluong) as 'số lượng dịch vụ đi kèm'
from hopdongfurama hd inner join hopdongchitiet hdct on hd.mahopdong = hdct.mahopdong
group by hd.mahopdong;  

-- cau 11
select hdct.madichvudikem,dvdk.tendichvudikem
from khachhang kh inner join hopdongfurama hd on kh.makhachhang = hd.makhachhang
			      inner join hopdongchitiet hdct on hd.mahopdong = hdct.mahopdong
                  inner join dichvudikem dvdk on hdct.madichvudikem = dvdk.madichvudikem
                  inner join loaikhach lk on lk.maloaikhach = kh.maloaikhachhang
where tenloaikhach = 'Diamond' and (diachikhachhang like '%Vinh' or diachikhachhang like'%Quảng Ngãi');                  

-- cau 12
select hd.mahopdong,nv.hotennhanvien,kh.hotenkhachhang,kh.sodienthoai,dv.tendichvu,sum(soluong),tiendatcoc
from khachhang kh inner join hopdongfurama hd on kh.makhachhang = hd.makhachhang                       
                  inner join dichvu dv on hd.madichvu = dv.madichvu
                  inner join nhanvien nv on nv.manhanvien = hd.manhanvien
                  inner join hopdongchitiet hdct on hd.mahopdong = hdct.mahopdong
where (year(ngaylamhopdong)='2020' and month(ngaylamhopdong) between 10 and 12) 
and ngaylamhopdong not in (select ngaylamhopdong from hopdongfurama
						   where month(ngaylamhopdong) between 1 and 6 and year(ngaylamhopdong)= '2021') ;
                   
-- cau 13
select dvdk.madichvudikem,dvdk.tendichvudikem,dvdk.gia,count(dvdk.madichvudikem) as 'số lần'
from khachhang kh inner join hopdongfurama hd on kh.makhachhang = hd.makhachhang
			      inner join hopdongchitiet hdct on hd.mahopdong = hdct.mahopdong
                  inner join dichvudikem dvdk on hdct.madichvudikem = dvdk.madichvudikem 
group by madichvudikem;

-- cau 14
select hd.mahopdong,ldv.tenloaidichvu,tendichvudikem,count(dvdk.madichvudikem) so_lan_dung_dvdk
from hopdongfurama hd inner join dichvu dv on hd.madichvu = dv.madichvu
                      inner join hopdongchitiet hdct on hd.mahopdong = hdct.mahopdong
                      inner join dichvudikem dvdk on hdct.madichvudikem = dvdk.madichvudikem 
                      inner join loaidichvu ldv on ldv.maloaidichvu = dv.maloaidichvu
group by dvdk.madichvudikem
having so_lan_dung_dvdk = 1;

-- cau 15

SELECT 
	ma_nhan_vien,
	ho_ten,
    ten_trinh_do,
    ten_bo_phan,
    so_dien_thoai,
    dia_chi,
    COUNT(hd.ma_nhan_vien) AS so_hop_dong
FROM 
	nhan_vien
    JOIN trinh_do USING (ma_trinh_do)
    JOIN bo_phan USING (ma_bo_phan)
    JOIN hop_dong hd USING (ma_nhan_vien)
WHERE
	YEAR(hd.ngay_lam_hop_dong) BETWEEN 2020 AND 2021
GROUP BY
	hd.ma_nhan_vien
HAVING
	so_hop_dong <= 3;

-- Task 16

DELETE 
FROM 
	nhan_vien nv
		WHERE EXISTS (
			SELECT
				*
			FROM 
				hop_dong hd
			WHERE
				nv.ma_nhan_vien = hd.ma_nhan_vien AND
				YEAR(ngay_lam_hop_dong) NOT BETWEEN 2019 AND 2021
            );

-- Task 17

UPDATE khach_hang kh1
SET 
	ma_loai_khach = 04
WHERE
	kh1.ma_khach_hang IN
     (SELECT ma_khach_hang FROM 
		(SELECT 
			kh2.ma_khach_hang
		FROM
			khach_hang kh2
            JOIN hop_dong hd USING (ma_khach_hang)
            JOIN dich_vu dv USING (ma_dich_vu)
            JOIN hop_dong_chi_tiet hdct USING (ma_hop_dong)
            JOIN dich_vu_di_kem dvdk USING (ma_dich_vu_di_kem)
		WHERE
			ma_loai_khach = 03
            AND YEAR(ngay_lam_hop_dong) = 2021
		GROUP BY
			kh2.ma_khach_hang
		HAVING
			SUM(dv.chi_phi_thue + dvdk.gia * hdct.so_luong) > 10000000
		) AS temp
	);

-- Task 18

DELETE 
FROM 
	khach_hang kh
WHERE
	EXISTS (
		SELECT
			*
		FROM
			hop_dong hd
		WHERE
			ma_khach_hang = kh.ma_khach_hang
            AND YEAR(ngay_lam_hop_dong) < 2021
            );

-- Task 19

UPDATE dich_vu_di_kem dvdk1
SET 
	gia = gia * 2
WHERE
	dvdk1.ma_dich_vu_di_kem IN
     (SELECT ma_dich_vu_di_kem FROM 
		(SELECT 
			dvdk2.ma_dich_vu_di_kem
		FROM
			dich_vu_di_kem dvdk2
            JOIN hop_dong_chi_tiet hdct USING (ma_dich_vu_di_kem)
            JOIN hop_dong hd USING (ma_hop_dong)
		WHERE
			dvdk2.ma_dich_vu_di_kem = dvdk1.ma_dich_vu_di_kem
            AND YEAR(ngay_lam_hop_dong) = 2020
		GROUP BY
			dvdk2.ma_dich_vu_di_kem
		HAVING
			SUM(hdct.so_luong) > 10
		) AS temp
	);

-- Task 20

SELECT
	ma_nhan_vien AS id,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
	nhan_vien
UNION (
	SELECT
		ma_khach_hang AS id,
        ho_ten,
        email,
		so_dien_thoai,
		ngay_sinh,
		dia_chi
	FROM
		khach_hang
        );               
			