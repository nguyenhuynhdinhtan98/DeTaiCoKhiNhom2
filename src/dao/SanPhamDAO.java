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
import implement.SanPhamImpls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImpls {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<SanPham> getAllSanPham() {
		String query = "from SanPham ";
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> result = session.createQuery(query).getResultList();
		return result;
	}

	@Override
	public List<SanPham> getBaSanPham() {
		// TODO Auto-generated method stub

		String query = "from SanPham ";
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> result = session.createQuery(query).setFirstResult(1).setMaxResults(3).getResultList();
		return result;
	}

	@Override
	public List<SanPham> getBonSanPham() {
		// TODO Auto-generated method stub
		String query = "from SanPham ";
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> result = session.createQuery(query).setFirstResult(1).setMaxResults(4).getResultList();
		return result;
	}

	@Override
	@Transactional
	public SanPham ChiTietSanPham(int maSanPham) {
		// TODO Auto-generated method stub
		String query = "from SanPham  where maSanPham=" + maSanPham;
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPhams = (SanPham) session.createQuery(query).getSingleResult();
		return sanPhams;
	}

	@Override
	public List<SanPham> getAllSanPhamWithKeyword(String keyword) {
		String query = "from SanPham where TenSanPham like '%" + keyword + "%'";
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> result = session.createQuery(query).getResultList();
		return result;
	}

	@Override
	@Transactional
	public void removeSanPham(int id) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.load(SanPham.class, id);
		session.delete(sanPham);
	}

	@Override
	@Transactional
	public void ThemSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(sanPham);
	}

	@Override
	@Transactional
	public void CapNhatSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		session.update(sanPham);
	}

}
