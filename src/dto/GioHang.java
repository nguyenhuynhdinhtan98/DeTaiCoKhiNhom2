package dto;

public class GioHang {
	private int maSanPham;
	private String tenSanPham;
	private String giaTien;
	private String hinhAnh;
	private String tongTien;
	private int soLuong;

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTongTien() {
		return tongTien;
	}

	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}

	public GioHang() {
		super();
	}

	public GioHang(int maSanPham, String tenSanPham, String giaTien, String hinhAnh, String tongTien, int soLuong) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaTien = giaTien;
		this.hinhAnh = hinhAnh;
		this.tongTien = tongTien;
		this.soLuong = soLuong;
	}

	public GioHang(int maSanPham, String tenSanPham, String giaTien, String hinhAnh, int soLuong) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaTien = giaTien;
		this.hinhAnh = hinhAnh;
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "GioHang [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", giaTien=" + giaTien + ", hinhAnh="
				+ hinhAnh + ", tongTien=" + tongTien + ", soLuong=" + soLuong + "]";
	}

}
