package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dto.DanhMucSanPham;
import dto.KhachHang;
import dto.NhanVien;
import dto.SanPham;

import javax.transaction.*;

import implement.DanhMucSanPhamImpls;
import implement.NhanVienImpls;
import implement.SanPhamImpls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO implements NhanVienImpls {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public NhanVien LayNhanVien(int maNhanVien) {
		String query = "from NhanVien where maNhanVien=" + maNhanVien;
		Session session = sessionFactory.getCurrentSession();
		NhanVien nhanVien = (NhanVien) session.createQuery(query).getSingleResult();
		return nhanVien;
	}

	@Override
	@Transactional
	public NhanVien KiemTraNhanVien(String taiKhoan, String matKhau) {
		String query = "from NhanVien where TenTaiKhoan like '" + taiKhoan + "' and MatKhau like '" + matKhau + "'";
		Session session = sessionFactory.getCurrentSession();
		NhanVien nhanVien =new NhanVien();
		try {
			nhanVien = (NhanVien) session.createQuery(query).getSingleResult();
		} catch (Exception e) {
			
		}
		return nhanVien;
	}



}
