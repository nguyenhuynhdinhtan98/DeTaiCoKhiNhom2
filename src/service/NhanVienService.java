package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DanhMucSanPhamDAO;
import dao.HoaDonDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import dto.DanhMucSanPham;
import dto.HoaDon;
import dto.NhanVien;
import dto.SanPham;
import implement.DanhMucSanPhamImpls;
import implement.HoaDonImpls;
import implement.NhanVienImpls;
import implement.SanPhamImpls;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Service
public class NhanVienService implements NhanVienImpls {
	@Autowired
	NhanVienDAO nhanVienDAO;

	@Override
	public NhanVien LayNhanVien(int maNhanVien) {
		NhanVien nhanVien = nhanVienDAO.LayNhanVien(maNhanVien);
		return nhanVien;
	}

	@Override
	public NhanVien KiemTraNhanVien(String taiKhoan, String matKhau) {
		NhanVien nhanVien = nhanVienDAO.KiemTraNhanVien(taiKhoan, matKhau);
		return nhanVien;
	}
}
