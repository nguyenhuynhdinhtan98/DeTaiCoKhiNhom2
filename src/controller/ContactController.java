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

@Controller
@RequestMapping("/contact")
@SessionAttributes({ "taikhoan", "giohang" })
public class ContactController {
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap,HttpSession httpSession) {
		List<DanhMucSanPham> danhMucSanPhams = new ArrayList<>();
		danhMucSanPhams = danhMucSanPhamService.getAllDanhMucSanPham();
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		return "contact";
	}

}
