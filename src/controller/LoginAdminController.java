package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.DanhMucSanPham;
import dto.GioHang;
import dto.NhanVien;
import service.KhachHangService;
import service.NhanVienService;

@Controller
@RequestMapping("/admin")
public class LoginAdminController {
	@Autowired
	NhanVienService nhanVienService;

	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap, HttpSession httpSession) {
		return "login_admin";
	}
}
