package controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import dto.ChiTietHoaDon;
import dto.GioHang;
import dto.HoaDon;
import dto.KhachHang;
import dto.SanPham;
import service.ChiTietHoaDonService;
import service.HoaDonService;
import service.KhachHangService;
import service.NhanVienService;
import service.SanPhamService;
import service.SendEmail;

@Controller
@RequestMapping("/api")
@SessionAttributes({ "taikhoan", "giohang" })
public class AjaxController {
	List<GioHang> gioHangs = new ArrayList<>();
	double tongTienHoaDon = 0;
	@Autowired
	HoaDonService hoaDonService;
	@Autowired
	NhanVienService nhanVienService;
	@Autowired
	KhachHangService khachHangService;

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;

	@GetMapping("/ThemGioHang")
	@ResponseBody
	public String ThemGioHang(@RequestParam int maSanPham, @RequestParam String tenSanPham, @RequestParam int soLuong,
			@RequestParam String giaTien, @RequestParam String hinhAnh, ModelMap modelMap, HttpSession httpSession) {
		System.out.println(maSanPham);
		DecimalFormat format = new DecimalFormat("0.#");
		String tongTien = format.format(soLuong * Integer.parseInt(giaTien));
		if (null == httpSession.getAttribute("giohang")) {
			GioHang gioHang = new GioHang(maSanPham, tenSanPham, giaTien, hinhAnh, soLuong);
			gioHang.setTongTien(tongTien);
			gioHangs.add(gioHang);
			httpSession.setAttribute("giohang", gioHangs);
			return gioHangs.size() + "";
		} else {
			gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraGioHang(maSanPham, httpSession);
			if (vitri == -1) {
				GioHang gioHang = new GioHang(maSanPham, tenSanPham, giaTien, hinhAnh, soLuong);
				gioHang.setTongTien(tongTien);
				gioHangs.add(gioHang);
			} else {
				int soluongmoi = gioHangs.get(vitri).getSoLuong() + 1;
				gioHangs.get(vitri).setSoLuong(soluongmoi);
			}
			return gioHangs.size() + "";
		}
	}

	private int KiemTraGioHang(int maSanPham, HttpSession httpSession) {
		List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		for (int i = 0; i < gioHangs.size(); i++) {
			if (gioHangs.get(i).getMaSanPham() == maSanPham) {
				return i;
			}
		}
		return -1;
	}

	@GetMapping("/TongTien")
	@ResponseBody
	public String LayTongTien(@RequestParam int maSanPham, HttpSession httpSession) {
		System.out.println(maSanPham + " " + " ");
		DecimalFormat format = new DecimalFormat("0.#");
		if (httpSession.getAttribute("giohang") != null) {
			gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			for (GioHang gioHang : gioHangs) {
				tongTienHoaDon += Double.valueOf(gioHang.getTongTien());
			}

		}
		return format.format(tongTienHoaDon);
	}

	@GetMapping("/XoaGioHang")
	@ResponseBody
	public void XoaGioHang(@RequestParam int maSanPham, HttpSession httpSession) {
		if (httpSession.getAttribute("giohang") != null) {
			gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = KiemTraGioHang(maSanPham, httpSession);
			gioHangs.remove(vitri);
		}
	}

	@GetMapping("/ThemHoaDon")
	@ResponseBody
	public String ThemHoaDon(@RequestParam String hoVaTen, @RequestParam String soDienThoai,
			@RequestParam String diaChi, HttpSession httpSession, SessionStatus sessionStatus) {
		String output = "";
		System.out.println(hoVaTen + " " + soDienThoai + " " + diaChi);
		KhachHang khachHang = (KhachHang) httpSession.getAttribute("taikhoan");
		if (hoVaTen.equalsIgnoreCase("") || soDienThoai.equalsIgnoreCase("")
				|| diaChi.equalsIgnoreCase("")) {
			output = "1";
		} else {
			if (httpSession.getAttribute("giohang") == null) {
				output = "3";
			} else {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				Date date = new Date();
				gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
				HoaDon hoaDon = new HoaDon(hoVaTen, soDienThoai, diaChi, false, String.valueOf(dtf.format(now)));
				hoaDon.setMaKhachHang(khachHangService.LayKhachHang(khachHang.getMaKhachHang()));
				hoaDon.setMaNhanVien(nhanVienService.LayNhanVien(1));
				hoaDonService.ThemHoaDon(hoaDon);
				for (GioHang gioHang : gioHangs) {
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(gioHang.getSoLuong(), gioHang.getTongTien());
					chiTietHoaDon.setMaHoaDon(hoaDon);
					chiTietHoaDon.setMaSanPham(sanPhamService.ChiTietSanPham(gioHang.getMaSanPham()));
					chiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);
				}
				//SendEmail email = new SendEmail();
				//email.SendEmail(khachHang.getTenTaiKhoan(),gioHangs,khachHang);
				output = "2";
				httpSession.removeAttribute("giohang");
				sessionStatus.setComplete();
			}
		}
		return output;
	}

	@PostMapping("/DangKyTaiKhoan")
	@ResponseBody
	public String DangKyTaiKhoan(@RequestParam String hoVaTenDangKy,
			@RequestParam String emailDangKy, @RequestParam String matKhauDangKy1, @RequestParam String matKhauDangKy2,
			@RequestParam String dienThoaiDangKy, @RequestParam String diaChiDangKy, @RequestParam int gioiTinhDangKy,
			HttpSession httpSession) {
		String output = "";
		String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern regex = Pattern.compile(emailPattern);
		Matcher matcher = regex.matcher(emailDangKy);
		System.out.println(khachHangService.KiemTraEmailKhachHang(emailDangKy));
		if (khachHangService.KiemTraEmailKhachHang(emailDangKy) == true || matcher.find() == false) {
			output = "1";
		} else {
			if ( hoVaTenDangKy.equals("") || emailDangKy.equals("") || matKhauDangKy1.equals("")
					|| matKhauDangKy2.equals("") || dienThoaiDangKy.equals("")) {
				output = "2";
			} else {
				if (matKhauDangKy1.equals(matKhauDangKy2)) {
					output = "3";
					KhachHang khachHang;
					if (gioiTinhDangKy == 1) {
						khachHang = new KhachHang(emailDangKy, matKhauDangKy1,hoVaTenDangKy,
								dienThoaiDangKy, false, dienThoaiDangKy);
					} else {
						khachHang = new KhachHang(emailDangKy, matKhauDangKy1,hoVaTenDangKy,
								dienThoaiDangKy, true, dienThoaiDangKy);
					}
					khachHangService.ThemKhachHang(khachHang);
				} else {
					output = "4";
				}
			}
		}
		return output;
	}

	@PostMapping("/DangNhap")
	@ResponseBody
	public boolean DangNhap(@RequestParam String email, @RequestParam String matkhau, HttpSession httpSession) {
		KhachHang kt = khachHangService.KiemTraKhachHang(email, matkhau);
		if (kt.getMaKhachHang() != null) {
			httpSession.setAttribute("taikhoan", kt);
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("/DangXuat")
	@ResponseBody
	public String DangXuat(HttpSession httpSession, SessionStatus sessionStatus) {
		if (httpSession.getAttribute("taikhoan") != null) {
			httpSession.removeAttribute("taikhoan");
			sessionStatus.setComplete();
		}
		return "logout";
	}

}
