
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
 * @author Gundam
 */
@Entity
@Table(name = "DanhMucSanPham")
public class DanhMucSanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaDanhMucSanPham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDanhMucSanPham;
    @Size(max = 50)
    @Column(name = "TenDanhMuc")
    private String tenDanhMuc;
    @Size(max = 50)
    @Column(name = "HinhDanhMuc")
    private String hinhDanhMuc;
    @OneToMany(mappedBy = "maDanhMucSanPham", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<SanPham> sanPhamList;

    public DanhMucSanPham() {
    }

    public DanhMucSanPham(Integer maDanhMucSanPham) {
        this.maDanhMucSanPham = maDanhMucSanPham;
    }

    public Integer getMaDanhMucSanPham() {
        return maDanhMucSanPham;
    }

    public void setMaDanhMucSanPham(Integer maDanhMucSanPham) {
        this.maDanhMucSanPham = maDanhMucSanPham;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getHinhDanhMuc() {
        return hinhDanhMuc;
    }

    public void setHinhDanhMuc(String hinhDanhMuc) {
        this.hinhDanhMuc = hinhDanhMuc;
    }

    @XmlTransient
    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDanhMucSanPham != null ? maDanhMucSanPham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhMucSanPham)) {
            return false;
        }
        DanhMucSanPham other = (DanhMucSanPham) object;
        if ((this.maDanhMucSanPham == null && other.maDanhMucSanPham != null) || (this.maDanhMucSanPham != null && !this.maDanhMucSanPham.equals(other.maDanhMucSanPham))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return "DanhMucSanPham [maDanhMucSanPham=" + maDanhMucSanPham + ", tenDanhMuc=" + tenDanhMuc + ", hinhDanhMuc="
				+ hinhDanhMuc + "]";
	}
    
    
    
}
