USE [master]
GO
/****** Object:  Database [detaicokhinhom2]    Script Date: 7/1/2020 9:26:19 AM ******/
CREATE DATABASE [detaicokhinhom2]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'detaicokhinhom2', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\detaicokhinhom2.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'detaicokhinhom2_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\detaicokhinhom2_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [detaicokhinhom2] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [detaicokhinhom2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [detaicokhinhom2] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET ARITHABORT OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [detaicokhinhom2] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [detaicokhinhom2] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET  ENABLE_BROKER 
GO
ALTER DATABASE [detaicokhinhom2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [detaicokhinhom2] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET RECOVERY FULL 
GO
ALTER DATABASE [detaicokhinhom2] SET  MULTI_USER 
GO
ALTER DATABASE [detaicokhinhom2] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [detaicokhinhom2] SET DB_CHAINING OFF 
GO
ALTER DATABASE [detaicokhinhom2] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [detaicokhinhom2] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [detaicokhinhom2] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'detaicokhinhom2', N'ON'
GO
ALTER DATABASE [detaicokhinhom2] SET QUERY_STORE = OFF
GO
USE [detaicokhinhom2]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 7/1/2020 9:26:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaChiTietHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[MaHoaDon] [int] NULL,
	[MaSanPham] [int] NULL,
	[SoLuong] [int] NULL,
	[GiaTien] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaChiTietHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMucSanPham]    Script Date: 7/1/2020 9:26:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMucSanPham](
	[MaDanhMucSanPham] [int] IDENTITY(1,1) NOT NULL,
	[TenDanhMuc] [nvarchar](50) NULL,
	[HinhDanhMuc] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDanhMucSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 7/1/2020 9:26:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[TenKhachHang] [nvarchar](50) NULL,
	[SoDienThoai] [nvarchar](30) NULL,
	[DiaChiGiaoHang] [nvarchar](50) NULL,
	[TinhTrang] [bit] NULL,
	[NgayMua] [nvarchar](30) NULL,
	[TongTien] [float] NULL,
	[MaNhanVien] [int] NULL,
	[MaKhachHang] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 7/1/2020 9:26:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[TenTaiKhoan] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](50) NULL,
	[HoTen] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[GioiTinh] [bit] NULL,
	[SoDienThoai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 7/1/2020 9:26:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[TenTaiKhoan] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](50) NULL,
	[HoTen] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[GioiTinh] [bit] NULL,
	[SoDienThoai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 7/1/2020 9:26:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [int] IDENTITY(1,1) NOT NULL,
	[MaDanhMucSanPham] [int] NULL,
	[TenSanPham] [nvarchar](400) NULL,
	[GiaTien] [nvarchar](50) NULL,
	[MoTa] [nvarchar](4000) NULL,
	[HinhSanPham] [nvarchar](500) NULL,
	[SoLuong] [int] NULL,
	[NgayNhap] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[DanhMucSanPham] ON 

INSERT [dbo].[DanhMucSanPham] ([MaDanhMucSanPham], [TenDanhMuc], [HinhDanhMuc]) VALUES (1, N'Máy khoan', N'category-1.jpg')
INSERT [dbo].[DanhMucSanPham] ([MaDanhMucSanPham], [TenDanhMuc], [HinhDanhMuc]) VALUES (2, N'Kìm cắt', N'category-2.jpg')
INSERT [dbo].[DanhMucSanPham] ([MaDanhMucSanPham], [TenDanhMuc], [HinhDanhMuc]) VALUES (3, N'Máy phát điện', N'category-3.jpg')
INSERT [dbo].[DanhMucSanPham] ([MaDanhMucSanPham], [TenDanhMuc], [HinhDanhMuc]) VALUES (4, N'Máy CNC', N'category-4.jpg')
INSERT [dbo].[DanhMucSanPham] ([MaDanhMucSanPham], [TenDanhMuc], [HinhDanhMuc]) VALUES (5, N'Thước đo', N'category-5.jpg')
INSERT [dbo].[DanhMucSanPham] ([MaDanhMucSanPham], [TenDanhMuc], [HinhDanhMuc]) VALUES (6, N'Đồ bảo hộ', N'category-6.jpg')
SET IDENTITY_INSERT [dbo].[DanhMucSanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKhachHang], [TenTaiKhoan], [MatKhau], [HoTen], [DiaChi], [GioiTinh], [SoDienThoai]) VALUES (1, N'nguyenhuynhdinhtan98@gmail.com', N'1234', N'Tân Nguyễn', N'Số 12 Nguyễn Văn Bảo, Thành phố Hồ Chí Minh', 0, N'09999999999')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([MaNhanVien], [TenTaiKhoan], [MatKhau], [HoTen], [DiaChi], [GioiTinh], [SoDienThoai]) VALUES (1, N'admin', N'admin', N'Nhân Viên', N'Số 12 Nguyễn Văn Bảo, Thành phố Hồ Chí Minh', 0, N'09999999999')
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (1, 1, N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc', N'1900', N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.', N'product-3.jpg', 940, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (2, 1, N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc', N'3900', N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.', N'product-4.jpg', 260, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (3, 1, N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc', N'2900', N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.', N'product-16-1.jpg', 303, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (4, 1, N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc', N'1200', N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.', N'product-16-2.jpg', 4780, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (5, 1, N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc', N'9000', N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.', N'product-16-3.jpg', 250, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (6, 1, N'Máy khoan Nga BNKTOP 900w khoan búa 13mm - Nhập khẩu nguyên chiếc', N'9000', N'Được làm từ chất liệu cao cấp, máy khoan búa BNKTOP sở hữu cho mình độ rắn chắc, bền bỉ, không biến dạng khi chịu lực cao hay có va chạm mạnh góp phần làm tăng tuổi thọ cho sản phẩm, bạn có thể yên tâm sử dụng sản phẩm trong một thời gian dài mà không cần lo lắng về độ bền hay những hư hỏng thường gặp như khi sử dụng các sản phẩm máy khoan khác trên thị trường. Bên cạnh đó, với chất liệu này, sản phẩm có khả năng chống gỉ sét tuyệt đối kể cả khi tiếp xúc thường xuyên với điều kiện ẩm ướt.', N'product-16-4.jpg', 2430, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (7, 2, N'Kìm điện thép Nhật CR-V cao cấp Kapusi Japan 8 inch', N'9000', N'7" Kìm cắt Stanley 84-028 là sản phẩm được nhiều người sử dụng tin dùng bởi tính hữu ích và tiện lợi. Sản phẩm chính hãng của STANLEY sản xuất theo công nghệ hiện đại của Mỹ đảm bảo bạn sẽ yên tâm hơn về chất lượng.', N'product-7.jpg', 20, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (8, 3, N'Máy Phát Điện  HK3000', N'9000', N'Là một trong những máy phát điện hiện đang hot ở thị trường, có thiết kế nhỏ gọn. Máy phát điện sử dụng nguyên liệu xăng giúp tiết kiệm chi phí, sản phẩm đến từ Total, thương hiệu nổi tiếng, chất lượng hàng đầu về công cụ - dụng cụ. Máy có khả năng phát điện, cấp điện cho các thiết bị sử dụng nguồn điện 1 chiều 220V / 50Hz, phù hợp sử dụng tại các gia đình, cung cấp điện cho các thiết bị như: đèn, quạt, nồi cơm điện...', N'product-17.jpg', 254350, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (9, 3, N'Máy phát điện Kama KGE2500X', N'2000', N'Là một trong những máy phát điện hiện đang hot ở thị trường, có thiết kế nhỏ gọn. Máy phát điện sử dụng nguyên liệu xăng giúp tiết kiệm chi phí, sản phẩm đến từ Total, thương hiệu nổi tiếng, chất lượng hàng đầu về công cụ - dụng cụ. Máy có khả năng phát điện, cấp điện cho các thiết bị sử dụng nguồn điện 1 chiều 220V / 50Hz, phù hợp sử dụng tại các gia đình, cung cấp điện cho các thiết bị như: đèn, quạt, nồi cơm điện...', N'product-18.jpg', 2440, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (10, 3, N'Máy phát điện Kama KGE2500X ', N'2000', N'Là một trong những máy phát điện hiện đang hot ở thị trường, có thiết kế nhỏ gọn. Máy phát điện sử dụng nguyên liệu xăng giúp tiết kiệm chi phí, sản phẩm đến từ Total, thương hiệu nổi tiếng, chất lượng hàng đầu về công cụ - dụng cụ. Máy có khả năng phát điện, cấp điện cho các thiết bị sử dụng nguồn điện 1 chiều 220V / 50Hz, phù hợp sử dụng tại các gia đình, cung cấp điện cho các thiết bị như: đèn, quạt, nồi cơm điện...', N'product-19.jpg', 2530, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (11, 4, N'Máy CNC khắc quảng cáo tự động PK-1215', N'9000', N'Máy CNC khắc quảng cáo tự động PK-1215 dòng sản phẩm máy cắt khắc quảng cáo cao cấp của thương hiệu PK Việt Nam, được sản xuất dựa trên công nghệ Nhật Bản. Máy được thiết kế hoàn toàn bằng thép đúc, trang bị hệ thống điều khiển PCI NcStudio, DSP offline hoặc MACH3, với hệ thống làm mát bằng nước cho công suất 2.2kw, tùy chọn 1.5/3.0kw hoặc làm mát không khí. Riêng với những dòng máy cnc 2 trục, 3 trục, 4 trục, 5 trục, 6 trục hay 12 trục được chúng tôi gia công riêng theo yêu cầu của khách hàng.', N'product-16.jpg', 2043, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (12, 4, N'Máy CNC khắc quảng cáo tự động PK-1215', N'9000', N'Máy CNC khắc quảng cáo tự động PK-1215 dòng sản phẩm máy cắt khắc quảng cáo cao cấp của thương hiệu PK Việt Nam, được sản xuất dựa trên công nghệ Nhật Bản. Máy được thiết kế hoàn toàn bằng thép đúc, trang bị hệ thống điều khiển PCI NcStudio, DSP offline hoặc MACH3, với hệ thống làm mát bằng nước cho công suất 2.2kw, tùy chọn 1.5/3.0kw hoặc làm mát không khí. Riêng với những dòng máy cnc 2 trục, 3 trục, 4 trục, 5 trục, 6 trục hay 12 trục được chúng tôi gia công riêng theo yêu cầu của khách hàng.', N'product-18.jpg', 2450, N'20/6/2020')
INSERT [dbo].[SanPham] ([MaSanPham], [MaDanhMucSanPham], [TenSanPham], [GiaTien], [MoTa], [HinhSanPham], [SoLuong], [NgayNhap]) VALUES (13, 5, N'Máy CNC khắc quảng cáo tự động PK-1215', N'3500', N'Máy CNC khắc quảng cáo tự động PK-1215 dòng sản phẩm máy cắt khắc quảng cáo cao cấp của thương hiệu PK Việt Nam, được sản xuất dựa trên công nghệ Nhật Bản. Máy được thiết kế hoàn toàn bằng thép đúc, trang bị hệ thống điều khiển PCI NcStudio, DSP offline hoặc MACH3, với hệ thống làm mát bằng nước cho công suất 2.2kw, tùy chọn 1.5/3.0kw hoặc làm mát không khí. Riêng với những dòng máy cnc 2 trục, 3 trục, 4 trục, 5 trục, 6 trục hay 12 trục được chúng tôi gia công riêng theo yêu cầu của khách hàng.', N'product-18.jpg', 205, N'20/6/2020')
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([MaDanhMucSanPham])
REFERENCES [dbo].[DanhMucSanPham] ([MaDanhMucSanPham])
GO
USE [master]
GO
ALTER DATABASE [detaicokhinhom2] SET  READ_WRITE 
GO
