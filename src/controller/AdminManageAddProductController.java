package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dto.DanhMucSanPham;
import dto.GioHang;
import dto.NhanVien;
import dto.SanPham;
import service.DanhMucSanPhamService;
import service.KhachHangService;
import service.NhanVienService;
import service.SanPhamService;

@Controller
@RequestMapping("/AddProduct")
@SessionAttributes({ "taikhoan", "giohang", "nhanvien" })
public class AdminManageAddProductController {
	@Autowired
	NhanVienService nhanVienService;
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;

	@GetMapping
	public String Default(ModelMap modelMap, HttpSession httpSession, HttpServletResponse http) throws IOException {
		NhanVien nhanVien = (NhanVien) httpSession.getAttribute("nhanvien");
		modelMap.addAttribute("danhmuc", danhMucSanPhamService.getAllDanhMucSanPham());
		if (nhanVien != null) {
			modelMap.addAttribute("nhanvien", nhanVien);
		} else {
			http.sendRedirect("./");
		}
		return "add_product";

	}
}
