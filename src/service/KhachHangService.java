package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DanhMucSanPhamDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import dto.DanhMucSanPham;
import dto.HoaDon;
import dto.KhachHang;
import dto.NhanVien;
import dto.SanPham;
import implement.DanhMucSanPhamImpls;
import implement.HoaDonImpls;
import implement.KhachHangImpls;
import implement.NhanVienImpls;
import implement.SanPhamImpls;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Service
public class KhachHangService implements KhachHangImpls {
	@Autowired
	KhachHangDAO khachHangDAO;

	@Override
	public KhachHang LayKhachHang(int maKhachHang) {
		KhachHang khachHang = khachHangDAO.LayKhachHang(maKhachHang);
		return khachHang;
	}

	@Override
	public KhachHang KiemTraKhachHang(String taiKhoan, String matKhau) {
		KhachHang kt  = khachHangDAO.KiemTraKhachHang(taiKhoan, matKhau);
		return kt;
	}

	@Override
	public boolean ThemKhachHang(KhachHang khachHang) {
		boolean kt = khachHangDAO.ThemKhachHang(khachHang);
		return kt;
	}

	@Override
	public boolean KiemTraEmailKhachHang(String taiKhoan) {
		boolean kt  = khachHangDAO.KiemTraEmailKhachHang(taiKhoan);
		return kt;
	}
}
