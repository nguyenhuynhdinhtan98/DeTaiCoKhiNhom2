package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dto.DanhMucSanPham;
import dto.HoaDon;
import dto.KhachHang;
import dto.SanPham;

import javax.transaction.*;

import implement.DanhMucSanPhamImpls;
import implement.HoaDonImpls;
import implement.KhachHangImpls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
/**
*
* @author Nguyễn Huỳnh Đình Tân
*/
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class KhachHangDAO implements KhachHangImpls {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public KhachHang LayKhachHang(int maKhachHang) {
		String query = "from KhachHang where maKhachHang=" + maKhachHang;
		Session session = sessionFactory.getCurrentSession();
		KhachHang khachHang = (KhachHang) session.createQuery(query).getSingleResult();
		return khachHang;
	}

	@Override
	@Transactional
	public KhachHang KiemTraKhachHang(String taiKhoan, String matKhau) {
		String query = "from KhachHang where TenTaiKhoan like '" + taiKhoan + "' and MatKhau like '" + matKhau + "'";
		Session session = sessionFactory.getCurrentSession();
		KhachHang khachHang =new KhachHang();
		try {
			 khachHang = (KhachHang) session.createQuery(query).getSingleResult();
		} catch (Exception e) {
			
		}
		return khachHang;

	}

	@Override
	@Transactional
	public boolean ThemKhachHang(KhachHang khachHang) {
		Session session = sessionFactory.getCurrentSession();
		int kt = (int) session.save(khachHang);
		if (kt != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean KiemTraEmailKhachHang(String taiKhoan) {
		String query = "from KhachHang where TenTaiKhoan like '" + taiKhoan + "'";
		Session session = sessionFactory.getCurrentSession();
		List<KhachHang> khachHangs = (List<KhachHang>) session.createQuery(query).getResultList();
		//System.out.println(khachHangs);
		if (khachHangs.size() != 0) {
			return true;
		} else {
			return false;
		}
	}
}
