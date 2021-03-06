package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dto.DanhMucSanPham;
import dto.GioHang;
import service.DanhMucSanPhamService;
import service.SanPhamService;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Controller
@RequestMapping("/cart")
@SessionAttributes({ "taikhoan", "giohang" })
public class CartController {

	@Autowired
	DanhMucSanPhamService taiKhoanService;
	@Autowired
	SanPhamService sanPhamService;

	@GetMapping
	public String Default(ModelMap modelMap, HttpSession httpSession) {
		List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		List<DanhMucSanPham> danhMucSanPhams = new ArrayList<>();
		danhMucSanPhams = taiKhoanService.getAllDanhMucSanPham();
		modelMap.addAttribute("giohang", gioHangs);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		if(httpSession.getAttribute("taikhoan") != null) {
			modelMap.addAttribute("user",httpSession.getAttribute("taikhoan"));
		}
		return "cart";
	}

}
