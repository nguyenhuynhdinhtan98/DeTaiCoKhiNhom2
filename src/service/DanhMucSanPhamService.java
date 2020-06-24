package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DanhMucSanPhamDAO;
import dto.DanhMucSanPham;

import implement.DanhMucSanPhamImpls;

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

	
}
