package implement;

import java.util.List;

import dto.DanhMucSanPham;
import dto.SanPham;


public interface DanhMucSanPhamImpls {
	List<DanhMucSanPham> getAllDanhMucSanPham();
	DanhMucSanPham getAllDanhMucSanPhamById(int maDanhMucSanPham);
	DanhMucSanPham getDanhMucSanPhamById(int maDanhMucSanPham);
	void ThemDanhMucSanPham(DanhMucSanPham danhMucSanPham);
	void removeDanhMuc(int id);
}
