/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Gundam
 */
@Entity
@Table(name = "ChiTietSanPham")

public class ChiTietSanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaChiTietSanPham")
    private Integer maChiTietSanPham;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Size(max = 50)
    @Column(name = "NgayNhap")
    private String ngayNhap;
    @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham")
    @ManyToOne
    private SanPham maSanPham;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(Integer maChiTietSanPham) {
        this.maChiTietSanPham = maChiTietSanPham;
    }

    public Integer getMaChiTietSanPham() {
        return maChiTietSanPham;
    }

    public void setMaChiTietSanPham(Integer maChiTietSanPham) {
        this.maChiTietSanPham = maChiTietSanPham;
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

    public SanPham getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(SanPham maSanPham) {
        this.maSanPham = maSanPham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maChiTietSanPham != null ? maChiTietSanPham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietSanPham)) {
            return false;
        }
        ChiTietSanPham other = (ChiTietSanPham) object;
        if ((this.maChiTietSanPham == null && other.maChiTietSanPham != null) || (this.maChiTietSanPham != null && !this.maChiTietSanPham.equals(other.maChiTietSanPham))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return "ChiTietSanPham [maChiTietSanPham=" + maChiTietSanPham + ", soLuong=" + soLuong + ", ngayNhap="
				+ ngayNhap + "]";
	}
    
}
