package implement;

import java.util.List;

import dto.DanhMucSanPham;


public interface DanhMucSanPhamImpls {
	List<DanhMucSanPham> getAllDanhMucSanPham();
	DanhMucSanPham getAllDanhMucSanPhamById(int maDanhMucSanPham);
}
