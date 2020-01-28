package implement;

import java.util.List;

import dto.HoaDon;
import dto.KhachHang;
import dto.SanPham;

public interface KhachHangImpls {
	KhachHang LayKhachHang(int maKhachHang);
	KhachHang KiemTraKhachHang(String taiKhoan,String matKhau);
	boolean KiemTraEmailKhachHang(String taiKhoan);
	boolean ThemKhachHang(KhachHang khachHang);
}
