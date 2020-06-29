package implement;

import java.util.List;

import dto.HoaDon;
import dto.KhachHang;
import dto.NhanVien;
import dto.SanPham;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
public interface NhanVienImpls {
	NhanVien LayNhanVien(int maNhanVien);
	NhanVien KiemTraNhanVien(String taiKhoan,String matKhau);
}
