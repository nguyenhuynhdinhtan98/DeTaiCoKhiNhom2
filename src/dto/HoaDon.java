package dto;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "HoaDon")

public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaHoaDon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHoaDon;
    @Size(max = 50)
    @Column(name = "TenKhachHang")
    private String tenKhachHang;
    @Size(max = 30)
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Size(max = 50)
    @Column(name = "DiaChiGiaoHang")
    private String diaChiGiaoHang;
    @Column(name = "TinhTrang")
    private Boolean tinhTrang;
    @Size(max = 30)
    @Column(name = "NgayMua")
    private String ngayMua;
    @Size(max = 30)
    @Column(name = "TongTien")
    private double tongTien;
    @OneToMany(mappedBy = "maHoaDon")
    private List<ChiTietHoaDon> chiTietHoaDonList;
    @JoinColumn(name = "MaKhachHang", referencedColumnName = "MaKhachHang")
    @ManyToOne
    private KhachHang maKhachHang;
    @JoinColumn(name = "MaNhanVien", referencedColumnName = "MaNhanVien")
    @ManyToOne
    private NhanVien maNhanVien;

    public HoaDon() {
    }

    public HoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    @XmlTransient
    public List<ChiTietHoaDon> getChiTietHoaDonList() {
        return chiTietHoaDonList;
    }

    public void setChiTietHoaDonList(List<ChiTietHoaDon> chiTietHoaDonList) {
        this.chiTietHoaDonList = chiTietHoaDonList;
    }

    public KhachHang getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(KhachHang maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public NhanVien getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(NhanVien maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHoaDon != null ? maHoaDon.hashCode() : 0);
        return hash;
    }

    public HoaDon(@Size(max = 50) String tenKhachHang,@Size(max = 30) String soDienThoai, @Size(max = 50) String diaChiGiaoHang,
			Boolean tinhTrang, @Size(max = 30) String ngayMua) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.tinhTrang = tinhTrang;
		this.ngayMua = ngayMua;
	}

	public HoaDon( @Size(max = 50) String tenKhachHang,@Size(max = 30) String soDienThoai,
			@Size(max = 50) String diaChiGiaoHang, Boolean tinhTrang, @Size(max = 30) String ngayMua,
			List<ChiTietHoaDon> chiTietHoaDonList) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.tinhTrang = tinhTrang;
		this.ngayMua = ngayMua;
		this.chiTietHoaDonList = chiTietHoaDonList;
	}

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.maHoaDon == null && other.maHoaDon != null) || (this.maHoaDon != null && !this.maHoaDon.equals(other.maHoaDon))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", tenKhachHang=" + tenKhachHang + ", soDienThoai=" + soDienThoai
				+ ", diaChiGiaoHang=" + diaChiGiaoHang + ", tinhTrang=" + tinhTrang + ", ngayMua=" + ngayMua + "]";
	}
    
}
