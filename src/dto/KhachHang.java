package dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gundam
 */
@Entity
@Table(name = "KhachHang")

public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaKhachHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKhachHang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TenTaiKhoan")
    private String tenTaiKhoan;
    @Size(max = 50)
    @Column(name = "MatKhau")
    private String matKhau;
    @Size(max = 50)
    @Column(name = "HoTen")
    private String hoTen;
    @Size(max = 50)
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "GioiTinh")
    private Boolean gioiTinh;
    @Size(max = 50)
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @OneToMany(mappedBy = "maKhachHang")
    private List<HoaDon> hoaDonList;

    public KhachHang() {
    }

    public KhachHang(@NotNull @Size(min = 1, max = 50) String tenTaiKhoan, @Size(max = 50) String matKhau,
			@Size(max = 50) String hoTen, @Size(max = 50) String diaChi, Boolean gioiTinh,
			@Size(max = 50) String soDienThoai) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
	}

	public KhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public KhachHang(Integer maKhachHang, String tenTaiKhoan) {
        this.maKhachHang = maKhachHang;
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public Integer getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

  

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

  

    @XmlTransient
    public List<HoaDon> getHoaDonList() {
        return hoaDonList;
    }

    public void setHoaDonList(List<HoaDon> hoaDonList) {
        this.hoaDonList = hoaDonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKhachHang != null ? maKhachHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.maKhachHang == null && other.maKhachHang != null) || (this.maKhachHang != null && !this.maKhachHang.equals(other.maKhachHang))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau
				+ ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh  + ", soDienThoai=" + soDienThoai + "]";
	}
    
}
