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
import dto.SanPham;

import javax.transaction.*;

import implement.DanhMucSanPhamImpls;

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
public class DanhMucSanPhamDAO implements DanhMucSanPhamImpls {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<DanhMucSanPham> getAllDanhMucSanPham() {
		String query = "from DanhMucSanPham ";
		Session session = sessionFactory.getCurrentSession();
		List<DanhMucSanPham> result = session.createQuery(query).getResultList();
		return result;
	}

	@Override
	@Transactional
	public DanhMucSanPham getAllDanhMucSanPhamById(int maDanhMucSanPham) {
		String query = "from DanhMucSanPham where MaDanhMucSanPham like '" + maDanhMucSanPham + "'";
		Session session = sessionFactory.getCurrentSession();
		DanhMucSanPham result = (DanhMucSanPham) session.createQuery(query).getSingleResult();
		return result;
	}

	@Override
	@Transactional
	public DanhMucSanPham getDanhMucSanPhamById(int maDanhMucSanPham) {
		Session session = sessionFactory.getCurrentSession();
		return session.load(DanhMucSanPham.class, maDanhMucSanPham);

	}

	@Override
	@Transactional
	public void removeDanhMuc(int id) {
		Session session = sessionFactory.getCurrentSession();
		DanhMucSanPham danhMucSanPham = session.load(DanhMucSanPham.class, id);
		session.delete(danhMucSanPham);
		
	}

	@Override
	@Transactional
	public void ThemDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(danhMucSanPham);
		
	}

	@Override
	@Transactional
	public void CapNhatDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhMucSanPham);
		
	}

}
