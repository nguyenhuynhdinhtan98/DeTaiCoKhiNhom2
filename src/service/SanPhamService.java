package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DanhMucSanPhamDAO;
import dao.SanPhamDAO;
import dto.DanhMucSanPham;
import dto.SanPham;
import implement.DanhMucSanPhamImpls;
import implement.SanPhamImpls;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Service
public class SanPhamService implements SanPhamImpls {
	@Autowired
	SanPhamDAO sanPhamDAO;

	@Override
	public List<SanPham> getAllSanPham() {
		// TODO Auto-generated method stub
		List<SanPham> sanPhams = sanPhamDAO.getAllSanPham();
		return sanPhams;
	}

	@Override
	public List<SanPham> getBaSanPham() {
		// TODO Auto-generated method stub
		List<SanPham> sanPhams = sanPhamDAO.getBaSanPham();
		return sanPhams;
	}

	@Override
	public List<SanPham> getBonSanPham() {
		// TODO Auto-generated method stub
		List<SanPham> sanPhams = sanPhamDAO.getBonSanPham();
		return sanPhams;
	}

	public SanPham ChiTietSanPham(int maSanPham) {
		SanPham sanPham = sanPhamDAO.ChiTietSanPham(maSanPham);
		return sanPham;
	}

	@Override
	public List<SanPham> getAllSanPhamWithKeyword(String keyword) {
		List<SanPham> sanPhams = sanPhamDAO.getAllSanPhamWithKeyword(keyword);
		return sanPhams;
	}

	@Override
	public void removeSanPham(int id) {
		sanPhamDAO.removeSanPham(id);
	}

	@Override
	public void ThemSanPham(SanPham sanPham) {
		sanPhamDAO.ThemSanPham(sanPham);
	}

	@Override
	public void CapNhatSanPham(SanPham sanPham) {
		sanPhamDAO.CapNhatSanPham(sanPham);
		
	}

	@Override
	public SanPham getSanPhamById(int maSanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getSanPhamById(maSanPham);
	}
}
