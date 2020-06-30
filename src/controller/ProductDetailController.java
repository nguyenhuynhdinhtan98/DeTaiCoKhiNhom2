package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dto.DanhMucSanPham;
import dto.GioHang;
import dto.SanPham;
import service.DanhMucSanPhamService;
import service.SanPhamService;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Controller
@RequestMapping("/productdetail")
@SessionAttributes({ "taikhoan", "giohang" })
public class ProductDetailController {

	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	@Autowired
	SanPhamService sanPhamService;

	@GetMapping("/{maSanPham}")
	@Transactional
	public String Default(@PathVariable int maSanPham, ModelMap modelMap, HttpSession httpSession) {
		int tongSanPhamTrongKho = 0;
		List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		List<DanhMucSanPham> danhMucSanPhams = new ArrayList<>();
		List<SanPham> sanPhams = new ArrayList<>();
		SanPham sanPham = sanPhamService.getSanPhamById(maSanPham);
		danhMucSanPhams = danhMucSanPhamService.getAllDanhMucSanPham();
		sanPhams = sanPhamService.getBaSanPham();
		tongSanPhamTrongKho = sanPham.getSoLuong();
		modelMap.addAttribute("sanpham", sanPham);
		modelMap.addAttribute("sanpham3", sanPhams);
		modelMap.addAttribute("tongSanPhamTrongKho", tongSanPhamTrongKho);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		if (httpSession.getAttribute("taikhoan") != null) {
			modelMap.addAttribute("user", httpSession.getAttribute("taikhoan"));
		}
		return "product_detail";
	}

}
