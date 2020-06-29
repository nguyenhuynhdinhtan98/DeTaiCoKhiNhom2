package dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nguyễn Huỳnh Đình Tân
 */
@Entity
@Table(name = "ChiTietHoaDon")
public class ChiTietHoaDon implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MaChiTietHoaDon")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maChiTietHoaDon;
	@Column(name = "SoLuong")
	private Integer soLuong;
	@Size(max = 50)
	@Column(name = "GiaTien")
	private String giaTien;
	@JoinColumn(name = "MaHoaDon", referencedColumnName = "MaHoaDon")
	@ManyToOne
	private HoaDon maHoaDon;
	@JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham")
	@ManyToOne
	private SanPham maSanPham;

	public ChiTietHoaDon() {
	}

	public ChiTietHoaDon(Integer maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}

	public Integer getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}

	public void setMaChiTietHoaDon(Integer maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public String getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}

	public HoaDon getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(HoaDon maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public SanPham getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(SanPham maSanPham) {
		this.maSanPham = maSanPham;
	}

	public ChiTietHoaDon(Integer soLuong, @Size(max = 50) String giaTien, SanPham maSanPham) {
		super();
		this.soLuong = soLuong;
		this.giaTien = giaTien;
		this.maSanPham = maSanPham;
	}

	public ChiTietHoaDon(Integer soLuong, @Size(max = 50) String giaTien) {
		super();
		this.soLuong = soLuong;
		this.giaTien = giaTien;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (maChiTietHoaDon != null ? maChiTietHoaDon.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
	
		if (!(object instanceof ChiTietHoaDon)) {
			return false;
		}
		ChiTietHoaDon other = (ChiTietHoaDon) object;
		if ((this.maChiTietHoaDon == null && other.maChiTietHoaDon != null)
				|| (this.maChiTietHoaDon != null && !this.maChiTietHoaDon.equals(other.maChiTietHoaDon))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [maChiTietHoaDon=" + maChiTietHoaDon + ", soLuong=" + soLuong + ", giaTien=" + giaTien
				+ "]";
	}

}
