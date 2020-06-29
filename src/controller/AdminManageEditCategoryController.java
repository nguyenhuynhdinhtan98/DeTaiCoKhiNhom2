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
@RequestMapping("/EditCategory")
@SessionAttributes({ "taikhoan", "giohang", "nhanvien" })
public class AdminManageEditCategoryController {
	@Autowired
	NhanVienService nhanVienService;
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;

	@GetMapping("/{maDanhMucSanPham}")
	@Transactional
	public String Default(@PathVariable int maDanhMucSanPham, ModelMap modelMap, HttpSession httpSession,
			HttpServletResponse http) throws IOException {
		DanhMucSanPham danhMucSanPham=danhMucSanPhamService.getDanhMucSanPhamById(maDanhMucSanPham);
		NhanVien nhanVien = (NhanVien) httpSession.getAttribute("nhanvien");
		modelMap.addAttribute("danhmuc",danhMucSanPham);
		System.out.println(danhMucSanPham);
		if (nhanVien != null) {
			modelMap.addAttribute("nhanvien", nhanVien);
		} else {
			http.sendRedirect("../");
		}
		return "edit_category";

	}
}
