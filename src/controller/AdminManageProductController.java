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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dto.DanhMucSanPham;
import dto.GioHang;
import dto.NhanVien;
import dto.SanPham;
import service.KhachHangService;
import service.NhanVienService;
import service.SanPhamService;

@Controller
@RequestMapping("/ManageProduct")
@SessionAttributes({ "taikhoan", "giohang", "nhanvien" })
public class AdminManageProductController {
	@Autowired
	NhanVienService nhanVienService;
	@Autowired
	SanPhamService sanPhamService;

	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap, HttpSession httpSession, HttpServletResponse http) throws IOException {
		List<SanPham> sanPhams = new ArrayList<>();
		sanPhams = sanPhamService.getAllSanPham();
		modelMap.addAttribute("sanpham", sanPhams);
		NhanVien nhanVien = (NhanVien) httpSession.getAttribute("nhanvien");
		if (nhanVien != null) {
			modelMap.addAttribute("nhanvien", nhanVien);
		} else {
			http.sendRedirect("./");
		}
		return "manage_product";

	}
}
