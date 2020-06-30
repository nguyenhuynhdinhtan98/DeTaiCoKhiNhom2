package service;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dto.GioHang;
import dto.KhachHang;

/**
 *
 * @author Nguyễn Huỳnh Đình Tân
 */
public class SendEmail {
	public void SendEmail(String to, List<GioHang> gioHangs, KhachHang khachHang) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", MailConfig.HOST_NAME);
		props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", MailConfig.SSL_PORT);

		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Mua sản phẩm thành công với khách hàng - " + khachHang.getHoTen());
			double tongtien = 0;
			StringBuffer content = new StringBuffer().append("Thông tin của khách hàng.\n")
					.append("Tên khách hàng: " + khachHang.getHoTen() + ".\n")
					.append("Số điện thoại: " + khachHang.getSoDienThoai() + ".\n")
					.append("Đia chỉ: " + khachHang.getDiaChi() + ".\n");
			for (GioHang gioHang : gioHangs) {
				tongtien += Double.parseDouble(gioHang.getGiaTien()) * gioHang.getSoLuong();
				content.append("Tên sản phẩm : " + gioHang.getTenSanPham() + "- giá tiền: " + gioHang.getGiaTien()
						+ " - số lượng: " + gioHang.getSoLuong() + " - tổng tiền sản phẩm: "
						+ String.valueOf(Double.parseDouble(gioHang.getGiaTien()) * gioHang.getSoLuong()) + " VND.\n");
			}
			content.append("Tổng tiền là: " + String.valueOf(tongtien) + " VND.\n");
			content.append("Chúc quý khách một ngày vui vẻ." + "\n");
			System.out.println(content);
			message.setText(content.toString());
			// send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
