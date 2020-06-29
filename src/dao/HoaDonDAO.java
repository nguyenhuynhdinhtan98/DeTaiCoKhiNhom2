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
import dto.HoaDon;

import javax.transaction.*;

import implement.DanhMucSanPhamImpls;
import implement.HoaDonImpls;

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
public class HoaDonDAO implements HoaDonImpls {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean ThemHoaDon(HoaDon hoaDon) {
		Session session = sessionFactory.getCurrentSession();
		int kt =(int)  session.save(hoaDon);
		if(kt !=0 ) {
			return true;
		}
		else {
			return false;
		}
	}

}
