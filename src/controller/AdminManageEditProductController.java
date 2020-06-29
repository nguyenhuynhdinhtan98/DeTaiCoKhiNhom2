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
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Controller
@RequestMapping("/EditProduct")
@SessionAttributes({ "taikhoan", "giohang", "nhanvien" })
public class AdminManageEditProductController {
	@Autowired
	NhanVienService nhanVienService;
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;

	@GetMapping("/{maSanPham}")
	@Transactional
	public String Default(@PathVariable int maSanPham, ModelMap modelMap, HttpSession httpSession,
			HttpServletResponse http) throws IOException {
		SanPham sanPham = sanPhamService.ChiTietSanPham(maSanPham);
		modelMap.addAttribute("sanpham", sanPham);
		NhanVien nhanVien = (NhanVien) httpSession.getAttribute("nhanvien");
		modelMap.addAttribute("danhmuc", danhMucSanPhamService.getAllDanhMucSanPham());
		modelMap.addAttribute("selectedRole", sanPham.getMaDanhMucSanPham().getMaDanhMucSanPham());
		if (nhanVien != null) {
			modelMap.addAttribute("nhanvien", nhanVien);
		} else {
			http.sendRedirect("../");
		}
		return "edit_product";

	}
}
