create database detaicokhinhom2;
CREATE TABLE KhachHang (
    MaKhachHang INT NOT NULL AUTO_INCREMENT,
    TenTaiKhoan NVARCHAR(50) NOT NULL,
     MatKhau NVARCHAR(50),
    HoTen NVARCHAR(50),
    DiaChi NVARCHAR(50),
    GioiTinh BOOLEAN,
    SoDienThoai NVARCHAR(50),
    PRIMARY KEY (MaKhachHang)
);
CREATE TABLE NhanVien (
    MaNhanVien INT NOT NULL AUTO_INCREMENT,
	TenTaiKhoan NVARCHAR(50) NOT NULL,
	MatKhau NVARCHAR(50),
    HoTen NVARCHAR(50),
    DiaChi NVARCHAR(50),
    GioiTinh BOOLEAN,
    SoDienThoai NVARCHAR(50),
    PRIMARY KEY (MaNhanVien)
);
create table HoaDon(
	MaHoaDon Integer   not null auto_increment,
    TenKhachHang NVARCHAR( 50 ),
    SoDienThoai NVARCHAR(30),
    DiaChiGiaoHang nvarchar(50),
    TinhTrang boolean,
	NgayMua NVARCHAR(30),
    MaNhanVien Integer,
    MaKhachHang Integer,
    primary key (MaHoaDon),
	FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
    	FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);
create table DanhMucSanPham(
	MaDanhMucSanPham Integer   not null auto_increment,
	TenDanhMuc  NVARCHAR(50),
    HinhDanhMuc  NVARCHAR(50),
	primary key (MaDanhMucSanPham)
);


create table SanPham(
		MaSanPham Integer not null auto_increment,
		MaDanhMucSanPham  Integer ,
		TenSanPham NVARCHAR (10000),
		GiaTien  NVARCHAR (50),
		MoTa  NVARCHAR(10000),
		HinhSanPham NVARCHAR(500),
		primary key (MaSanPham),
         FOREIGN KEY (MaDanhMucSanPham) REFERENCES DanhMucSanPham(MaDanhMucSanPham)
);
create table ChiTietHoaDon(
  	MaChiTietHoaDon Integer not null auto_increment,
    MaHoaDon INTEGER,
	MaSanPham INTEGER,
    SoLuong INTEGER,
    GiaTien NVARCHAR(50),
	primary key (MaChiTietHoaDon),
	FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham)
);
CREATE TABLE ChiTietSanPham (
    MaChiTietSanPham INTEGER NOT NULL AUTO_INCREMENT,
    MaSanPham INTEGER,
    SoLuong INTEGER,
	NgayNhap NVARCHAR(50),
    PRIMARY KEY (MaChiTietSanPham),
    FOREIGN KEY (MaSanPham) REFERENCES SanPham (MaSanPham)
);






insert into DanhMucSanPham values (1, N'Máy khoan','category-1.jpg');
insert into DanhMucSanPham values (2,N'Kìm cắt','category-2.jpg');
insert into DanhMucSanPham values (3,N'Máy phát điện','category-3.jpg');
insert into DanhMucSanPham values (4,N'Máy CNC','category-4.jpg');
insert into DanhMucSanPham values (5,N'Thước đo','category-5.jpg');
insert into DanhMucSanPham values (6,N'Đồ bảo hộ','category-6.jpg');


insert into SanPham values (1,  1,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','1900000',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-3.jpg');
insert into SanPham values (2, 1 ,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','3900000',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-4.jpg');
insert into SanPham values (3, 1 ,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','2900000',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-16-1.jpg');
insert into SanPham values (5, 1 ,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','4900000',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-16-2.jpg');
insert into SanPham values (6, 1 ,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','900000',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-16-3.jpg');
insert into SanPham values (7, 1 ,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','900000',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-16-4.jpg');
insert into SanPham values (8, 2 ,N'Kìm điện thép Nhật CR-V cao cấp Kapusi Japan 8 inch','900000',N'7" Kìm cắt Stanley 84-028 là sản phẩm được nhiều người sử dụng tin dùng bởi tính hữu ích và tiện lợi. Sản phẩm chính hãng của STANLEY sản xuất theo công nghệ hiện đại của Mỹ đảm bảo bạn sẽ yên tâm hơn về chất lượng.','product-7.jpg');
insert into SanPham values (9, 3 ,N'Máy Phát Điện  HK3000','900000',N'Là một trong những máy phát điện hiện đang hot ở thị trường, có thiết kế nhỏ gọn. Máy phát điện sử dụng nguyên liệu xăng giúp tiết kiệm chi phí, sản phẩm đến từ Total, thương hiệu nổi tiếng, chất lượng hàng đầu về công cụ - dụng cụ. Máy có khả năng phát điện, cấp điện cho các thiết bị sử dụng nguồn điện 1 chiều 220V / 50Hz, phù hợp sử dụng tại các gia đình, cung cấp điện cho các thiết bị như: đèn, quạt, nồi cơm điện...','product-17.jpg');
insert into SanPham values (10,3 ,N'Máy phát điện Kama KGE2500X','20000',N'Là một trong những máy phát điện hiện đang hot ở thị trường, có thiết kế nhỏ gọn. Máy phát điện sử dụng nguyên liệu xăng giúp tiết kiệm chi phí, sản phẩm đến từ Total, thương hiệu nổi tiếng, chất lượng hàng đầu về công cụ - dụng cụ. Máy có khả năng phát điện, cấp điện cho các thiết bị sử dụng nguồn điện 1 chiều 220V / 50Hz, phù hợp sử dụng tại các gia đình, cung cấp điện cho các thiết bị như: đèn, quạt, nồi cơm điện...','product-18.jpg');
insert into SanPham values (11, 3 ,N'Máy phát điện Kama KGE2500X ','900000',N'Là một trong những máy phát điện hiện đang hot ở thị trường, có thiết kế nhỏ gọn. Máy phát điện sử dụng nguyên liệu xăng giúp tiết kiệm chi phí, sản phẩm đến từ Total, thương hiệu nổi tiếng, chất lượng hàng đầu về công cụ - dụng cụ. Máy có khả năng phát điện, cấp điện cho các thiết bị sử dụng nguồn điện 1 chiều 220V / 50Hz, phù hợp sử dụng tại các gia đình, cung cấp điện cho các thiết bị như: đèn, quạt, nồi cơm điện...','product-19.jpg');
insert into SanPham values (12, 4 ,N'Máy CNC khắc quảng cáo tự động PK-1215','900000',N'Máy CNC khắc quảng cáo tự động PK-1215 dòng sản phẩm máy cắt khắc quảng cáo cao cấp của thương hiệu PK Việt Nam, được sản xuất dựa trên công nghệ Nhật Bản. Máy được thiết kế hoàn toàn bằng thép đúc, trang bị hệ thống điều khiển PCI NcStudio, DSP offline hoặc MACH3, với hệ thống làm mát bằng nước cho công suất 2.2kw, tùy chọn 1.5/3.0kw hoặc làm mát không khí. Riêng với những dòng máy cnc 2 trục, 3 trục, 4 trục, 5 trục, 6 trục hay 12 trục được chúng tôi gia công riêng theo yêu cầu của khách hàng.','product-16.jpg');
insert into SanPham values (13, 4 ,N'Máy CNC khắc quảng cáo tự động PK-1215','900000',N'Máy CNC khắc quảng cáo tự động PK-1215 dòng sản phẩm máy cắt khắc quảng cáo cao cấp của thương hiệu PK Việt Nam, được sản xuất dựa trên công nghệ Nhật Bản. Máy được thiết kế hoàn toàn bằng thép đúc, trang bị hệ thống điều khiển PCI NcStudio, DSP offline hoặc MACH3, với hệ thống làm mát bằng nước cho công suất 2.2kw, tùy chọn 1.5/3.0kw hoặc làm mát không khí. Riêng với những dòng máy cnc 2 trục, 3 trục, 4 trục, 5 trục, 6 trục hay 12 trục được chúng tôi gia công riêng theo yêu cầu của khách hàng.','product-18.jpg');
insert into SanPham values (14, 5 ,N'Máy CNC khắc quảng cáo tự động PK-1215','900000',N'Máy CNC khắc quảng cáo tự động PK-1215 dòng sản phẩm máy cắt khắc quảng cáo cao cấp của thương hiệu PK Việt Nam, được sản xuất dựa trên công nghệ Nhật Bản. Máy được thiết kế hoàn toàn bằng thép đúc, trang bị hệ thống điều khiển PCI NcStudio, DSP offline hoặc MACH3, với hệ thống làm mát bằng nước cho công suất 2.2kw, tùy chọn 1.5/3.0kw hoặc làm mát không khí. Riêng với những dòng máy cnc 2 trục, 3 trục, 4 trục, 5 trục, 6 trục hay 12 trục được chúng tôi gia công riêng theo yêu cầu của khách hàng.','product-18.jpg');
insert into KhachHang values (1,'nguyenhuynhdinhtan98@gmail.com','1234','Tan','123',false,'1234567890');
insert into NhanVien values (1,'admin','admin','Nhan Vien','123',false,'1234567');

select * from NhanVien;
select * from SanPham;
select * from khachhang;
select * from DanhMucSanPham;
select * from hoadon;
select * from chitiethoadon;


select * from SanPham where tensanpham like '%a%';



