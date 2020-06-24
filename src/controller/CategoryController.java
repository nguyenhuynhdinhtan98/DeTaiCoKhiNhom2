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

import dto.ChiTietSanPham;
import dto.DanhMucSanPham;
import dto.GioHang;
import dto.SanPham;
import service.DanhMucSanPhamService;
import service.SanPhamService;

@Controller
@RequestMapping("/category")
@SessionAttributes({ "taikhoan", "giohang" })
public class CategoryController {

	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	@Autowired
	SanPhamService sanPhamService;

	@GetMapping("/{maDanhMucSanPham}")
	@Transactional
	public String Default(@PathVariable int maDanhMucSanPham, ModelMap modelMap, HttpSession httpSession) {
		int tongSanPhamTrongKho = 0;
		List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		List<DanhMucSanPham> danhMucSanPhams = new ArrayList<>();
		List<SanPham> sanPhams = new ArrayList<>();
		danhMucSanPhams = danhMucSanPhamService.getAllDanhMucSanPham();
		DanhMucSanPham danhMucSanPham = danhMucSanPhamService.getAllDanhMucSanPhamById(maDanhMucSanPham);
		modelMap.addAttribute("sanpham", danhMucSanPham);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		if (httpSession.getAttribute("taikhoan") != null) {
			modelMap.addAttribute("user", httpSession.getAttribute("taikhoan"));
		}
		return "category";
	}

}
