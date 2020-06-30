CREATE DATABASE detaicokhinhom2;

CREATE TABLE KhachHang (
    MaKhachHang INT NOT NULL IDENTITY,
    TenTaiKhoan NVARCHAR(50) NOT NULL,
     MatKhau NVARCHAR(50),
    HoTen NVARCHAR(50),
    DiaChi NVARCHAR(50),
    GioiTinh BIT,
    SoDienThoai NVARCHAR(50),
    PRIMARY KEY (MaKhachHang)
);
CREATE TABLE NhanVien (
    MaNhanVien INT NOT NULL IDENTITY,
	TenTaiKhoan NVARCHAR(50) NOT NULL,
	MatKhau NVARCHAR(50),
    HoTen NVARCHAR(50),
    DiaChi NVARCHAR(50),
    GioiTinh BIT,
    SoDienThoai NVARCHAR(50),
    PRIMARY KEY (MaNhanVien)
);
create table HoaDon(
	MaHoaDon Integer   not null identity,
    TenKhachHang NVARCHAR( 50 ),
    SoDienThoai NVARCHAR(30),
    DiaChiGiaoHang nvarchar(50),
    TinhTrang bit,
	NgayMua NVARCHAR(30),
	TongTien float,
    MaNhanVien Integer,
    MaKhachHang Integer,
    primary key (MaHoaDon),
	FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
    	FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);
create table DanhMucSanPham(
	MaDanhMucSanPham Integer   not null identity,
	TenDanhMuc  NVARCHAR(50),
    HinhDanhMuc  NVARCHAR(50),
	primary key (MaDanhMucSanPham)
);
create table SanPham(
		MaSanPham Integer not null identity,
		MaDanhMucSanPham  Integer ,
		TenSanPham NVARCHAR (400),
		GiaTien  NVARCHAR (50),
		MoTa  NVARCHAR(4000),
		HinhSanPham NVARCHAR(500),
		 SoLuong INTEGER,
	NgayNhap NVARCHAR(50),
		primary key (MaSanPham),
         FOREIGN KEY (MaDanhMucSanPham) REFERENCES DanhMucSanPham(MaDanhMucSanPham)
);
create table ChiTietHoaDon(
  	MaChiTietHoaDon Integer not null identity,
    MaHoaDon INTEGER,
	MaSanPham INTEGER,
    SoLuong INTEGER,
    GiaTien NVARCHAR(50),
	primary key (MaChiTietHoaDon),
	FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham)
);






insert into DanhMucSanPham values ( N'Máy khoan','category-1.jpg');
insert into DanhMucSanPham values (N'Kìm cắt','category-2.jpg');
insert into DanhMucSanPham values (N'Máy phát điện','category-3.jpg');
insert into DanhMucSanPham values (N'Máy CNC','category-4.jpg');
insert into DanhMucSanPham values (N'Thước đo','category-5.jpg');
insert into DanhMucSanPham values (N'Đồ bảo hộ','category-6.jpg');


insert into SanPham values (  1,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','1900',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-3.jpg',940,'20/6/2020');
insert into SanPham values ( 1 ,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','3900',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-4.jpg',260,'20/6/2020');
insert into SanPham values ( 1 ,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','2900',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-16-1.jpg',303,'20/6/2020');
insert into SanPham values ( 1 ,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','1200',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-16-2.jpg',4780,'20/6/2020');
insert into SanPham values ( 1 ,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','9000',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-16-3.jpg',250,'20/6/2020');
insert into SanPham values ( 1 ,N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc','9000',N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.','product-16-4.jpg',2430,'20/6/2020');
insert into SanPham values ( 2 ,N'Kìm điện thép Nhật CR-V cao cấp Kapusi Japan 8 inch','9000',N'7" Kìm cắt Stanley 84-028 là sản phẩm được nhiều người sử dụng tin dùng bởi tính hữu ích và tiện lợi. Sản phẩm chính hãng của STANLEY sản xuất theo công nghệ hiện đại của Mỹ đảm bảo bạn sẽ yên tâm hơn về chất lượng.','product-7.jpg',20,'20/6/2020');
insert into SanPham values ( 3 ,N'Máy Phát Điện  HK3000','9000',N'Là một trong những máy phát điện hiện đang hot ở thị trường, có thiết kế nhỏ gọn. Máy phát điện sử dụng nguyên liệu xăng giúp tiết kiệm chi phí, sản phẩm đến từ Total, thương hiệu nổi tiếng, chất lượng hàng đầu về công cụ - dụng cụ. Máy có khả năng phát điện, cấp điện cho các thiết bị sử dụng nguồn điện 1 chiều 220V / 50Hz, phù hợp sử dụng tại các gia đình, cung cấp điện cho các thiết bị như: đèn, quạt, nồi cơm điện...','product-17.jpg',254350,'20/6/2020');
insert into SanPham values (3 ,N'Máy phát điện Kama KGE2500X','2000',N'Là một trong những máy phát điện hiện đang hot ở thị trường, có thiết kế nhỏ gọn. Máy phát điện sử dụng nguyên liệu xăng giúp tiết kiệm chi phí, sản phẩm đến từ Total, thương hiệu nổi tiếng, chất lượng hàng đầu về công cụ - dụng cụ. Máy có khả năng phát điện, cấp điện cho các thiết bị sử dụng nguồn điện 1 chiều 220V / 50Hz, phù hợp sử dụng tại các gia đình, cung cấp điện cho các thiết bị như: đèn, quạt, nồi cơm điện...','product-18.jpg',2440,'20/6/2020');
insert into SanPham values ( 3 ,N'Máy phát điện Kama KGE2500X ','2000',N'Là một trong những máy phát điện hiện đang hot ở thị trường, có thiết kế nhỏ gọn. Máy phát điện sử dụng nguyên liệu xăng giúp tiết kiệm chi phí, sản phẩm đến từ Total, thương hiệu nổi tiếng, chất lượng hàng đầu về công cụ - dụng cụ. Máy có khả năng phát điện, cấp điện cho các thiết bị sử dụng nguồn điện 1 chiều 220V / 50Hz, phù hợp sử dụng tại các gia đình, cung cấp điện cho các thiết bị như: đèn, quạt, nồi cơm điện...','product-19.jpg',2530,'20/6/2020');
insert into SanPham values ( 4 ,N'Máy CNC khắc quảng cáo tự động PK-1215','9000',N'Máy CNC khắc quảng cáo tự động PK-1215 dòng sản phẩm máy cắt khắc quảng cáo cao cấp của thương hiệu PK Việt Nam, được sản xuất dựa trên công nghệ Nhật Bản. Máy được thiết kế hoàn toàn bằng thép đúc, trang bị hệ thống điều khiển PCI NcStudio, DSP offline hoặc MACH3, với hệ thống làm mát bằng nước cho công suất 2.2kw, tùy chọn 1.5/3.0kw hoặc làm mát không khí. Riêng với những dòng máy cnc 2 trục, 3 trục, 4 trục, 5 trục, 6 trục hay 12 trục được chúng tôi gia công riêng theo yêu cầu của khách hàng.','product-16.jpg',2043,'20/6/2020');
insert into SanPham values ( 4 ,N'Máy CNC khắc quảng cáo tự động PK-1215','9000',N'Máy CNC khắc quảng cáo tự động PK-1215 dòng sản phẩm máy cắt khắc quảng cáo cao cấp của thương hiệu PK Việt Nam, được sản xuất dựa trên công nghệ Nhật Bản. Máy được thiết kế hoàn toàn bằng thép đúc, trang bị hệ thống điều khiển PCI NcStudio, DSP offline hoặc MACH3, với hệ thống làm mát bằng nước cho công suất 2.2kw, tùy chọn 1.5/3.0kw hoặc làm mát không khí. Riêng với những dòng máy cnc 2 trục, 3 trục, 4 trục, 5 trục, 6 trục hay 12 trục được chúng tôi gia công riêng theo yêu cầu của khách hàng.','product-18.jpg',2450,'20/6/2020');
insert into SanPham values ( 5 ,N'Máy CNC khắc quảng cáo tự động PK-1215','3500',N'Máy CNC khắc quảng cáo tự động PK-1215 dòng sản phẩm máy cắt khắc quảng cáo cao cấp của thương hiệu PK Việt Nam, được sản xuất dựa trên công nghệ Nhật Bản. Máy được thiết kế hoàn toàn bằng thép đúc, trang bị hệ thống điều khiển PCI NcStudio, DSP offline hoặc MACH3, với hệ thống làm mát bằng nước cho công suất 2.2kw, tùy chọn 1.5/3.0kw hoặc làm mát không khí. Riêng với những dòng máy cnc 2 trục, 3 trục, 4 trục, 5 trục, 6 trục hay 12 trục được chúng tôi gia công riêng theo yêu cầu của khách hàng.','product-18.jpg',205,'20/6/2020');
insert into KhachHang values ('nguyenhuynhdinhtan98@gmail.com','1234',N'Tân Nguyễn',N'Số 12 Nguyễn Văn Bảo, Thành phố Hồ Chí Minh',0,N'09999999999');
insert into NhanVien values ('admin','admin',N'Nhân Viên',N'Số 12 Nguyễn Văn Bảo, Thành phố Hồ Chí Minh',0,N'09999999999');


