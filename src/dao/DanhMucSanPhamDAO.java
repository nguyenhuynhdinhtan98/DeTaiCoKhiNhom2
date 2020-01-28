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

import javax.transaction.*;

import implement.DanhMucSanPhamImpls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

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

}
