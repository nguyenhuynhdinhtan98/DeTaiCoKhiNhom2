package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DanhMucSanPhamDAO;
import dto.DanhMucSanPham;

import implement.DanhMucSanPhamImpls;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Service
public class DanhMucSanPhamService implements DanhMucSanPhamImpls {
	@Autowired
	DanhMucSanPhamDAO danhMucSanPhamDAO;

	@Override
	public List<DanhMucSanPham> getAllDanhMucSanPham() {
		// TODO Auto-generated method stub
		List<DanhMucSanPham> danhMucSanPhams = danhMucSanPhamDAO.getAllDanhMucSanPham();
		return danhMucSanPhams;
	}

	@Override
	public DanhMucSanPham getAllDanhMucSanPhamById(int maDanhMucSanPham) {
		DanhMucSanPham danhMucSanPhams = danhMucSanPhamDAO.getAllDanhMucSanPhamById(maDanhMucSanPham);
		return danhMucSanPhams;
	}

	@Override
	public DanhMucSanPham getDanhMucSanPhamById(int maDanhMucSanPham) {
		// TODO Auto-generated method stub
		return danhMucSanPhamDAO.getDanhMucSanPhamById(maDanhMucSanPham);
	}

	@Override
	public void removeDanhMuc(int id) {
		danhMucSanPhamDAO.removeDanhMuc(id);

	}

	@Override
	public void ThemDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		danhMucSanPhamDAO.ThemDanhMucSanPham(danhMucSanPham);

	}

	@Override
	public void CapNhatDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		danhMucSanPhamDAO.CapNhatDanhMucSanPham(danhMucSanPham);
	}

}
