package controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import dto.ChiTietHoaDon;
import dto.DanhMucSanPham;
import dto.GioHang;
import dto.HoaDon;
import dto.KhachHang;
import dto.NhanVien;
import dto.SanPham;
import service.ChiTietHoaDonService;
import service.DanhMucSanPhamService;
import service.HoaDonService;
import service.KhachHangService;
import service.NhanVienService;
import service.SanPhamService;
import service.SendEmail;

/**
 *
 * @author Nguyễn Huỳnh Đình Tân
 */
@Controller
@RequestMapping("/api")
@SessionAttributes({ "taikhoan", "giohang", "nhanvien" })
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
	DanhMucSanPhamService danhMucSanPhamService;

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
			@RequestParam String diaChi, HttpSession httpSession, SessionStatus sessionStatus, WebRequest request) {
		String output = "";
		KhachHang khachHang = (KhachHang) httpSession.getAttribute("taikhoan");
		if (hoVaTen.length() < 5 || soDienThoai.length() < 9 || diaChi.length() < 4) {	
			output = "1";
		} else {
			if (httpSession.getAttribute("giohang") == null) {
				output = "3";
			} else {
				gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
				double TongTien = 0;
				for (GioHang gioHang : gioHangs) {
					TongTien = TongTien + Double.parseDouble(gioHang.getTongTien());
				}
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				Date date = new Date();
				HoaDon hoaDon = new HoaDon(hoVaTen, soDienThoai, diaChi, false, String.valueOf(dtf.format(now)));
				hoaDon.setTongTien(TongTien);
				hoaDon.setMaKhachHang(khachHangService.LayKhachHang(khachHang.getMaKhachHang()));
				hoaDon.setMaNhanVien(nhanVienService.LayNhanVien(1));
				hoaDonService.ThemHoaDon(hoaDon);
				for (GioHang gioHang : gioHangs) {
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(gioHang.getSoLuong(), gioHang.getTongTien());
					SanPham sanPhamCapNhatSoLuong = sanPhamService.getSanPhamById(gioHang.getMaSanPham());
					System.out.println(sanPhamCapNhatSoLuong);
					sanPhamCapNhatSoLuong.setSoLuong(sanPhamCapNhatSoLuong.getSoLuong() - gioHang.getSoLuong());
					chiTietHoaDon.setMaHoaDon(hoaDon);
					chiTietHoaDon.setMaSanPham(sanPhamService.ChiTietSanPham(gioHang.getMaSanPham()));
					sanPhamService.CapNhatSanPham(sanPhamCapNhatSoLuong);
					chiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);
				}
				SendEmail email = new SendEmail();
				email.SendEmail(khachHang.getTenTaiKhoan(), gioHangs, khachHang);
				output = "2";
				httpSession.removeAttribute("giohang");
				sessionStatus.setComplete();
				httpSession.setAttribute("taikhoan", khachHang);
			}
		}
		httpSession.setAttribute("taikhoan", khachHang);
		return output;
	}

	@PostMapping("/DangKyTaiKhoan")
	@ResponseBody
	public String DangKyTaiKhoan(@RequestParam String hoVaTenDangKy, @RequestParam String emailDangKy,
			@RequestParam String matKhauDangKy1, @RequestParam String matKhauDangKy2,
			@RequestParam String dienThoaiDangKy, @RequestParam String diaChiDangKy, @RequestParam int gioiTinhDangKy,
			HttpSession httpSession) {
		String output = "";
		String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern regex = Pattern.compile(emailPattern);
		Matcher matcher = regex.matcher(emailDangKy);
		if (khachHangService.KiemTraEmailKhachHang(emailDangKy) == true || matcher.find() == false) {
			output = "1";
		} else {
			if (hoVaTenDangKy.length() < 5 || emailDangKy.equals("") || matKhauDangKy1.length() < 4
					|| matKhauDangKy2.length() < 4 || dienThoaiDangKy.length() < 10 || diaChiDangKy.length() < 4) {
				output = "2";
			} else {
				if (matKhauDangKy1.equals(matKhauDangKy2)) {
					output = "3";
					KhachHang khachHang;
					if (gioiTinhDangKy == 1) {
						khachHang = new KhachHang(emailDangKy, matKhauDangKy1, hoVaTenDangKy, diaChiDangKy, false,
								dienThoaiDangKy);
					} else {
						khachHang = new KhachHang(emailDangKy, matKhauDangKy1, hoVaTenDangKy, diaChiDangKy, true,
								dienThoaiDangKy);
					}
					khachHangService.ThemKhachHang(khachHang);
				} else {
					output = "4";
				}
			}
		}
		System.out.println(output);
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

	@RequestMapping(value = "/admin-login", method = RequestMethod.POST)
	@ResponseBody
	public boolean DangNhapAdmin(@RequestParam String username, @RequestParam String matkhau, HttpSession httpSession) {
		NhanVien kt = nhanVienService.KiemTraNhanVien(username, matkhau);
		if (kt.getMaNhanVien() != null) {
			httpSession.setAttribute("nhanvien", kt);
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
		}
		if (httpSession.getAttribute("nhanvien") != null) {
			httpSession.removeAttribute("nhanvien");
		}
		sessionStatus.setComplete();
		return "logout";
	}

	@RequestMapping(value = "/ThemSanPham", method = RequestMethod.POST)
	@ResponseBody
	public String ThemSanPham(@RequestParam String tensanpham, @RequestParam String giatien,
			@RequestParam String hinhAnh, @RequestParam int soluong, @RequestParam String mota,
			@RequestParam int madanhmucthemsanpham) {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = dateFormat.format(date);
		DanhMucSanPham danhMucSanPham = danhMucSanPhamService.getDanhMucSanPhamById(madanhmucthemsanpham);
		SanPham sanPham = new SanPham(tensanpham, giatien, mota, hinhAnh, soluong, strDate);
		sanPham.setMaDanhMucSanPham(danhMucSanPham);
		System.out.println(sanPham);
		sanPhamService.ThemSanPham(sanPham);
		return "";
	}

	@RequestMapping(value = "/ThemDanhMucSanPham", method = RequestMethod.POST)
	@ResponseBody
	public String ThemDanhMucSanPham(@RequestParam String tendanhmucsanpham, @RequestParam String hinhAnhDanhMuc) {
		DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
		danhMucSanPham.setTenDanhMuc(tendanhmucsanpham);
		danhMucSanPham.setHinhDanhMuc(hinhAnhDanhMuc);
		System.out.println(danhMucSanPham);
		danhMucSanPhamService.ThemDanhMucSanPham(danhMucSanPham);
		return "";
	}

	@RequestMapping(value = "/CapNhatDanhMucSanPham", method = RequestMethod.POST)
	@ResponseBody
	public String CapNhatDanhMucSanPham(@RequestParam int madanhmucsanphamcapnhat,
			@RequestParam String tendanhmuccapnhat, @RequestParam String hinhAnhDanhMucCapNhat) {
		DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
		danhMucSanPham.setMaDanhMucSanPham(madanhmucsanphamcapnhat);
		danhMucSanPham.setTenDanhMuc(tendanhmuccapnhat);
		danhMucSanPham.setHinhDanhMuc(hinhAnhDanhMucCapNhat);
		System.out.println(danhMucSanPham);
		danhMucSanPhamService.CapNhatDanhMucSanPham(danhMucSanPham);
		return "";
	}

	@RequestMapping(value = "/CapNhatSanPham", method = RequestMethod.POST)
	@ResponseBody
	public String CapNhatSanPham(@RequestParam int masanphamcapnhat, @RequestParam String tensanphamcapnhat,
			@RequestParam String giatiensanphamcapnhat, @RequestParam String hinhanhsanphamcapnhat,
			@RequestParam int soluongsanphamcapnhat, @RequestParam String motasanphamcapnhat,
			@RequestParam int madanhmucsanphamcapnhat) {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = dateFormat.format(date);
		DanhMucSanPham danhMucSanPham = danhMucSanPhamService.getDanhMucSanPhamById(madanhmucsanphamcapnhat);
		SanPham sanPham = new SanPham(tensanphamcapnhat, giatiensanphamcapnhat, motasanphamcapnhat,
				hinhanhsanphamcapnhat, soluongsanphamcapnhat, strDate);
		sanPham.setMaSanPham(masanphamcapnhat);
		sanPham.setMaDanhMucSanPham(danhMucSanPham);
		System.out.println(sanPham);
		sanPhamService.CapNhatSanPham(sanPham);
		return "";
	}

	@RequestMapping(value = "/XoaDanhMuc", method = RequestMethod.POST)
	@ResponseBody
	public String XoaDanhMuc(@RequestParam int value) {
		danhMucSanPhamService.removeDanhMuc(value);
		return "";
	}
}
