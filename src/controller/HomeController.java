package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dto.DanhMucSanPham;
import dto.SanPham;
import service.DanhMucSanPhamService;
import service.SanPhamService;
import service.SendEmail;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Controller
@RequestMapping("/")
@SessionAttributes({ "taikhoan", "giohang" })
public class HomeController {

	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	@Autowired
	SanPhamService sanPhamService;

	@GetMapping
	@Transactional
	public String Default( ModelMap modelMap, HttpSession httpSession) {
		List<DanhMucSanPham> danhMucSanPhams = new ArrayList<>();
		List<SanPham> sanPhams4 = new ArrayList<>();
		sanPhams4 = sanPhamService.getBaSanPham();
		danhMucSanPhams = danhMucSanPhamService.getAllDanhMucSanPham();
		modelMap.addAttribute("danhmuc", danhMucSanPhams);
		modelMap.addAttribute("lay4sanpham", sanPhams4);
		if (httpSession.getAttribute("taikhoan") != null) {
			System.out.println(httpSession.getAttribute("taikhoan"));
			modelMap.addAttribute("user", httpSession.getAttribute("taikhoan"));
		}
		modelMap.addAttribute("giohang", httpSession.getAttribute("giohang"));
		//SendEmail email = new SendEmail();
		// email.SendEmail("nguyenhuynhdinhtan98@gmail.com");
		return "home";
	}
}
