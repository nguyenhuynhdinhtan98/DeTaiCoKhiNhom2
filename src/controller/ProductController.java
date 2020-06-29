package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dto.DanhMucSanPham;
import dto.SanPham;
import service.DanhMucSanPhamService;
import service.SanPhamService;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Controller
@RequestMapping("/product")
@SessionAttributes({ "taikhoan", "giohang" })
public class ProductController {

	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	@Autowired
	SanPhamService sanPhamService;

	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap,HttpSession httpSession) {
		List<DanhMucSanPham> danhMucSanPhams=new ArrayList<>();
		List<SanPham> sanPhams=new ArrayList<>();
		danhMucSanPhams = danhMucSanPhamService.getAllDanhMucSanPham();
		sanPhams=sanPhamService.getAllSanPham();
		modelMap.addAttribute("sanpham", sanPhams);
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		if(httpSession.getAttribute("taikhoan") != null) {
			modelMap.addAttribute("user",httpSession.getAttribute("taikhoan"));
		}
		return "product";
	}

}
