package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ChiTietHoaDonDAO;
import dao.DanhMucSanPhamDAO;
import dao.HoaDonDAO;
import dao.SanPhamDAO;
import dto.ChiTietHoaDon;
import dto.DanhMucSanPham;
import dto.HoaDon;
import dto.SanPham;
import implement.ChiTietHoaDonImpls;
import implement.DanhMucSanPhamImpls;
import implement.HoaDonImpls;
import implement.SanPhamImpls;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImpls {
	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDAO;

	@Override
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		boolean kt = chiTietHoaDonDAO.ThemChiTietHoaDon(chiTietHoaDon);
		return kt;
	}
}
