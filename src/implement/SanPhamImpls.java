package implement;

import java.util.List;

import dto.DanhMucSanPham;
import dto.SanPham;

public interface SanPhamImpls {
	List<SanPham> getAllSanPham();
	List<SanPham> getAllSanPhamWithKeyword(String keyword);
	List<SanPham> getBaSanPham();
	List<SanPham> getBonSanPham();
	SanPham ChiTietSanPham(int maSanPham);
	void CapNhatSanPham(SanPham sanPham);
	void ThemSanPham(SanPham sanPham);
	void removeSanPham(int id);
}
