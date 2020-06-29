package dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MaSanPham")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maSanPham;
	@Size(max = 4000)
	@Column(name = "TenSanPham")
	private String tenSanPham;
	@Size(max = 50)
	@Column(name = "GiaTien")
	private String giaTien;
	@Size(max = 4000)
	@Column(name = "MoTa")
	private String moTa;
	@Size(max = 500)
	@Column(name = "HinhSanPham")
	private String hinhSanPham;
	@Column(name = "SoLuong")
	private Integer soLuong;
	@Size(max = 50)
	@Column(name = "NgayNhap")
	private String ngayNhap;

	@JoinColumn(name = "MaDanhMucSanPham", referencedColumnName = "MaDanhMucSanPham")
	@ManyToOne
	private DanhMucSanPham maDanhMucSanPham;
	@OneToMany(mappedBy = "maSanPham")
	private List<ChiTietHoaDon> chiTietHoaDonList;

	public SanPham() {
	}

	public SanPham(Integer maSanPham) {
		this.maSanPham = maSanPham;
	}

	public Integer getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(Integer maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhSanPham() {
		return hinhSanPham;
	}

	public void setHinhSanPham(String hinhSanPham) {
		this.hinhSanPham = hinhSanPham;
	}

	public DanhMucSanPham getMaDanhMucSanPham() {
		return maDanhMucSanPham;
	}

	public void setMaDanhMucSanPham(DanhMucSanPham maDanhMucSanPham) {
		this.maDanhMucSanPham = maDanhMucSanPham;
	}

	@XmlTransient
	public List<ChiTietHoaDon> getChiTietHoaDonList() {
		return chiTietHoaDonList;
	}

	public void setChiTietHoaDonList(List<ChiTietHoaDon> chiTietHoaDonList) {
		this.chiTietHoaDonList = chiTietHoaDonList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (maSanPham != null ? maSanPham.hashCode() : 0);
		return hash;
	}

	public SanPham(@Size(max = 4000) String tenSanPham, @Size(max = 50) String giaTien, @Size(max = 4000) String moTa,
			@Size(max = 500) String hinhSanPham, Integer soLuong, @Size(max = 50) String ngayNhap) {
		super();
		this.tenSanPham = tenSanPham;
		this.giaTien = giaTien;
		this.moTa = moTa;
		this.hinhSanPham = hinhSanPham;
		this.soLuong = soLuong;
		this.ngayNhap = ngayNhap;
	}

	@Override
	public boolean equals(Object object) {
		
		if (!(object instanceof SanPham)) {
			return false;
		}
		SanPham other = (SanPham) object;
		if ((this.maSanPham == null && other.maSanPham != null)
				|| (this.maSanPham != null && !this.maSanPham.equals(other.maSanPham))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", giaTien=" + giaTien + ", moTa="
				+ moTa + ", hinhSanPham=" + hinhSanPham + "]";
	}

}
