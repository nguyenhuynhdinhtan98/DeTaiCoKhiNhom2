package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DanhMucSanPhamDAO;
import dao.HoaDonDAO;
import dao.SanPhamDAO;
import dto.DanhMucSanPham;
import dto.HoaDon;
import dto.SanPham;
import implement.DanhMucSanPhamImpls;
import implement.HoaDonImpls;
import implement.SanPhamImpls;

@Service
public class HoaDonService implements HoaDonImpls {
	@Autowired
	HoaDonDAO hoaDonDAO;

	@Override
	public boolean ThemHoaDon(HoaDon hoaDon) {
		boolean kt = hoaDonDAO.ThemHoaDon(hoaDon);
		return kt;
	}
}
