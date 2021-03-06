$(document).ready(function() {
	$("#btnDangNhap").click(function() {
		$(this).addClass("actived");
		$("#btnDangKy").removeClass("actived");
		$("#dangky").show();
		$("#dangnhap").css("display", "none");
	});
	$("#btnDangKy").click(function() {
		$(this).addClass("actived");
		$("#btnDangNhap").removeClass("actived");
		$("#dangnhap").show();
		$("#dangky").css("display", "none");
	});

	$("#add-to-cart").click(function() {
		var masanpham = $("#masanpham").text();
		var tensanpham = $("#tensanpham").text();
		var soLuong = $("#soluong").val();
		if (soLuong > 20) {
			soLuong = "e";
		}
		var giatien = $("#giatien").text();
		var hinhAnh = $("#hinhAnh").attr("src").replace(/^.*[\\\/]/, "");
		$.ajax({
			url: "../api/ThemGioHang",
			type: "GET",
			data: {
				maSanPham: masanpham,
				tenSanPham: tensanpham,
				soLuong: soLuong,
				giaTien: giatien,
				hinhAnh: hinhAnh
			},
			success: function(data) {
				window.location.reload();
			}
		});
	});

	$(".remove-pr").click(function() {
		var self = $(this);
		var masanpham = $(".table").find("tbody").find("tr").attr("name");
		$.ajax({
			url: "api/XoaGioHang",
			type: "GET",
			data: {
				maSanPham: masanpham
			},
			success: function(data) {
				self.closest("tr").remove();
				window.location.reload();
			}
		});
	});
	$(document).ready(function() {
		var masanpham = $(".table").find("tbody").find("tr").attr("name");
		$.ajax({
			url: "api/TongTien",
			type: "GET",
			data: {
				maSanPham: masanpham
			},
			success: function(data) {
				$("#total").html(data);
				$("#totalall").html(data);
			}
		});
	});

	$("#order").click(function() {
		// var masanpham =
		// $(".table").find("tbody").find("tr").attr('name');
		var hoVaTen = $("#hoVaTen").val();
		var sdt = $("#phone").val();
		var diachi = $("#address").val();
		$.ajax({
			url: "api/ThemHoaDon",
			type: "GET",
			data: {
				hoVaTen: hoVaTen,
				soDienThoai: sdt,
				diaChi: diachi
			},
			success: function(data) {
				console.log(data);
				if (data === "1") {
					alert("Vui lòng điền đầy đủ thông tin .");
				} else if (data === "2") {
					alert("Đặt hàng thành công.");
					window.location.reload();
				} else if (data === "3") {
					alert("Không có sản phẩm trong giỏ hàng.");
				}
				event.preventDefault();
			}
		});
	});
	$("#formDatHang").validate({
		rules: {
			hoVaTen: {
				required: true,
				minlength: 5,
				maxlength: 40
			},
			sdt: {
				required: true,
				number: true,
				minlength: 10,
				maxlength: 11
			},
			diachi: {
				required: true,
				minlength: 4,
				maxlength: 50
			}
		},
		messages: {
			hoVaTen: {
				required: "Vui lòng nhập họ và tên",
				minlength: "Tối thiểu 5 ký tự ",
				maxlength: "Tối đa 40 ký tự"
			},
			sdt: {
				required: "Vui lòng nhập số điện thoại",
				minlength: "Tối thiểu 10 ký tự ",
				maxlength: "Tối đa 11 ký tự",
				number: "Bắt buộc nhập số"
			},
			diachi: {
				required: "Vui lòng nhập địa chỉ",
				minlength: "Tối thiểu 4 ký tự ",
				maxlength: "Tối đa 50 ký tự"
			}
		}
	});
	$("#btnRegister").click(function() {
		var hoVaTenDangKy = $("input[name='hoVaTenDangKy']").val();
		var email = $("input[name='emailDangKy']").val();
		var matkhau1 = $("input[name='matKhauDangKy1']").val();
		var matkhau2 = $("input[name='matKhauDangKy2']").val();
		var sodienthoai = $("input[name='dienThoaiDangKy']").val();
		var diachi = $("input[name='diaChiDangKy']").val();
		var gioiTinhDangKy = $("input[name='gioiTinh']:checked").val();
		$.ajax({
			url: "api/DangKyTaiKhoan",
			type: "POST",
			data: {
				hoVaTenDangKy: hoVaTenDangKy,
				emailDangKy: email,
				matKhauDangKy1: matkhau1,
				matKhauDangKy2: matkhau2,
				dienThoaiDangKy: sodienthoai,
				diaChiDangKy: diachi,
				gioiTinhDangKy: gioiTinhDangKy
			},
			success: function(data) {
				if (data == 1) {
					$("#emailfail").css({
						"display": "contents"
					});
				}
				if (data == 2) {
					alert("Kiểm tra thông tin vào form.")
				}
				if (data == 3) {
					window.location.reload();
				}
				if (data == 4) {
					$("#passwordfail").css({
						"display": "contents"
					});
				}
			}
		});
	});

	$("#formDangKy").validate({
		rules: {
			hoVaTenDangKy: {
				required: true,
				minlength: 5,
				maxlength: 40,
			},
			emailDangKy: {
				required: true,
				email: true,
				minlength: 6,
				maxlength: 30,
			},
			matKhauDangKy1: {
				required: true,
				minlength: 4,
				maxlength: 20,
			},
			matKhauDangKy2: {
				required: true,
				minlength: 4,
				maxlength: 20,
				equalTo: "#matKhauDangKy1",
			},
			dienThoaiDangKy: {
				required: true,
				number: true,
				minlength: 10,
				maxlength: 11
			},
			diaChiDangKy: {
				required: true,
				minlength: 4,
				maxlength: 50
			}
		},
		messages: {
			hoVaTenDangKy: {
				required: "Vui lòng nhập họ và tên",
				minlength: "Tối thiểu 5 ký tự ",
				maxlength: "Tối đa 40 ký tự"
			},
			emailDangKy: {
				required: "Vui lòng nhập email",
				email: "Không đúng định dạng email.",
				minlength: "Tối thiểu 6 ký tự ",
				maxlength: "Tối đa 30 ký tự",
			},
			matKhauDangKy1: {
				required: "Vui lòng nhập mật khẩu",
				minlength: "Tối thiểu 4 ký tự ",
				maxlength: "Tối đa 20 ký tự",
			},
			matKhauDangKy2: {
				required: "Vui lòng nhập mật khẩu",
				minlength: "Tối thiểu 4 ký tự ",
				maxlength: "Tối đa 20 ký tự",
				equalTo: "Mật khẩu không trùng",
			},
			dienThoaiDangKy: {
				required: "Vui lòng nhập số điện thoại",
				minlength: "Tối thiểu 10 ký tự ",
				maxlength: "Tối đa 11 ký tự",
				number: "Bắt buộc nhập số",
			},
			diaChiDangKy: {
				required: "Vui lòng nhập địa chỉ",
				minlength: "Tối thiểu 4 ký tự ",
				maxlength: "Tối đa 50 ký tự"
			}
		}
	});

	$("#btnLogin").click(function() {
		var email = $("input[name='emailDangNhap']").val();
		var matkhau = $("input[name='matKhauDangNhap']").val();
		$.ajax({
			url: "api/DangNhap",
			type: "POST",
			data: {
				email: email,
				matkhau: matkhau
			},
			success: function(data) {
				if (data == true) {
					window.location.href = "./";
				} else {
					$("#userfail").css({
						"display": "contents"
					});
				}
			}
		});
	});
	$("#btnLoginAdmin").click(function() {
		var username = $("input[name='username']").val();
		var matkhau = $("input[name='pass']").val();
		$.ajax({
			url: "api/admin-login",
			type: "POST",
			data: {
				username: username,
				matkhau: matkhau
			},
			success: function(data) {
				if (data == true) {
					window.location.href = "./ManageProduct";
				} else {
					$("#userfailadmin").css({
						"display": "contents"
					});
				}
			}
		});
	});

	$("#formDangNhap").validate({
		rules: {
			emailDangNhap: {
				required: true,
				email: true,
				minlength: 6,
				maxlength: 30,
			}
		},
		messages: {
			emailDangNhap: {
				required: "Vui lòng nhập email",
				email: "Không đúng định dạng email.",
				minlength: "Tối thiểu 6 ký tự ",
				maxlength: "Tối đa 30 ký tự",
			}
		}
	});

	$("#dangxuat").click(function() {
		console.log("Log out");
		$.ajax({
			url: "api/DangXuat",
			type: "POST",
			data: {},
			success: function(data) {
				if (data === "logout") {
					window.location.reload();
				}
			}
		});
	});
	$("#dangxuat").click(function() {
		console.log("Log out");
		$.ajax({
			url: "../api/DangXuat",
			type: "POST",
			data: {},
			success: function(data) {
				if (data === "logout") {
					window.location.reload();
				}
			}
		});
	});
	$("#formThemGioHang").validate({
		rules: {
			soluongThemGioHang: {
				number: true,
				required: true,
				min: 1,
				max: 20,
			},
		},
		messages: {
			soluongThemGioHang: {
				number: "Không được nhập chữ.",
				required: "Vui lòng nhập số lượng.",
				min: "Tối thiểu 1 đơn vị.",
				max: "Tối đa 20 đơn vị.",
			},
		}
	});
	$(".removeCategory").click(function() {
		if (confirm('Xoá danh mục ?')) {
			var value = $(this).attr('value')
			$.ajax({
				url: "api/XoaDanhMuc",
				type: "POST",
				data: { value: value, },
				success: function(data) {
					if(data === "1"){
						alert("Danh mục hiện còn tồn tại sản phẩm.");
					}else{
						window.location.href = "ManageCategory";
					}
				}
			});
		}
	});
	$("#formThemSanPham").validate({
		rules: {
			tensanphamadd: {
				required: true,
				minlength: 5,
				maxlength: 45
			},
			giatiemadd: {
				required: true,
				number: true,
				minlength: 4,
			},
			motasanpham: {
				required: true,
				minlength: 50,
			},
			soluongadd: {
				required: true,
				number: true,
				minlength: 1,
			},
			hinhanhadd: {
				required: true,
			},
			madanhmucthemsanpham: {
				number: true,
			},
		},
		messages: {
			tensanphamadd: {
				required: "Vui lòng nhập tên sản phẩm.",
				minlength: "Tối thiểu 5 ký tự ",
				maxlength: "Tối đa 45 ký tự ",
			},
			giatiemadd: {
				required: "Vui lòng nhập số.",
				minlength: "Tối thiểu 4 ký tự ",
				number: "Bắt buộc nhập số",
			},
			motasanpham: {
				required: "Vui lòng nhập mô tả.",
				minlength: "Tối thiểu 50 ký tự ",
			},
			soluongadd: {
				required: "Vui lòng nhập số lượng.",
				minlength: "Tối thiểu 1 ký tự ",
				number: "Bắt buộc nhập số",
			},
			hinhanhadd: {
				required: "Vui lòng nhập hình ảnh.",
			},
			madanhmucthemsanpham: {
				number: "Vui lòng chọn danh mục.",
			}
		}
	});
	$("#btnThemSanPham").click(function() {
		var tensanpham = $("input[name='tensanphamadd']").val();
		var giatien = $("input[name='giatiemadd']").val();
		var hinhAnh = $("input[name='hinhanhadd']").val().replace(/^.*[\\\/]/, '');
		var soluong = $("input[name='soluongadd']").val();
		var mota = $("textarea[name='motasanpham']").val();
		var madanhmucthemsanpham = $("select[name='madanhmucthemsanpham']").val();
		if (madanhmucthemsanpham !== "Chọn danh mục sản phẩm" && hinhAnh !== null && tensanpham.length >= 5 && tensanpham.length <= 45 && giatien >= 1000 && mota.length > 49 && soluong >= 0) {
			$.ajax({
				url: "api/ThemSanPham",
				type: "POST",
				data: {
					tensanpham: tensanpham,
					giatien: giatien,
					hinhAnh: hinhAnh,
					soluong: soluong,
					mota: mota,
					madanhmucthemsanpham: madanhmucthemsanpham
				},
				success: function(data) {
					window.location.href = "ManageProduct";
				}
			});
		}
	});
	$("#formThemDanhMuc").validate({
		rules: {
			tendanhmucadd: {
				required: true,
				minlength: 5,
				maxlength: 45,
			},

			hinhAnhDanhMuc: {
				required: true,
			},

		},
		messages: {
			tendanhmucadd: {
				required: "Vui lòng nhập tên sản phẩm.",
				minlength: "Tối thiểu 5 ký tự ",
				maxlength: "Tối đa 45 ký tự ",
			},

			hinhAnhDanhMuc: {
				required: "Vui lòng nhập hình ảnh.",
			},

		}
	});
	$("#formCapNhatDanhMuc").validate({
		rules: {
			tendanhmuccapnhat: {
				required: true,
				minlength: 5,
				maxlength: 45,
			},
		},
		messages: {
			tendanhmuccapnhat: {
				required: "Vui lòng nhập tên sản phẩm.",
				minlength: "Tối thiểu 5 ký tự ",
				maxlength: "Tối đa 45 ký tự ",
			},
		}
	});
	$("#btnCapNhatDanhMucSanPham").click(function() {
		var madanhmucsanphamcapnhat = $("input[name='madanhmucsanphamcapnhat']").val();
		var tendanhmuccapnhat = $("input[name='tendanhmuccapnhat']").val();
		var hinhAnhDanhMucCapNhat = $("input[name='hinhAnhDanhMucCapNhat']").val().replace(/^.*[\\\/]/, '');
		if (hinhAnhDanhMucCapNhat == "") {
			hinhAnhDanhMucCapNhat = $("input[name='hinhanhhienthicapnhatdanhmuc']").val();
		}
		if (hinhAnhDanhMucCapNhat !== "" && tendanhmuccapnhat.length >= 5 && tendanhmuccapnhat.length <= 45) {
			$.ajax({
				url: "../api/CapNhatDanhMucSanPham",
				type: "POST",
				data: {
					madanhmucsanphamcapnhat: madanhmucsanphamcapnhat,
					tendanhmuccapnhat: tendanhmuccapnhat,
					hinhAnhDanhMucCapNhat: hinhAnhDanhMucCapNhat,
				},
				success: function(data) {
					window.location.href = "../ManageCategory";
				}
			});
		}
	});




	$("#btnThemDanhMucSanPham").click(function() {
		var tendanhmucsanpham = $("input[name='tendanhmucadd']").val();
		var hinhAnhDanhMuc = $("input[name='hinhAnhDanhMuc']").val().replace(/^.*[\\\/]/, '');
		console.log(tendanhmucsanpham + " " + hinhAnhDanhMuc)
		if (hinhAnhDanhMuc !== "" && tendanhmucsanpham.length >= 5 && tendanhmucsanpham.length <= 45) {
			$.ajax({
				url: "api/ThemDanhMucSanPham",
				type: "POST",
				data: {
					tendanhmucsanpham: tendanhmucsanpham,
					hinhAnhDanhMuc: hinhAnhDanhMuc,
				},
				success: function(data) {
					window.location.href = "ManageCategory";
				}
			});
		}
	});
	$("#formCapNhatSanPham").validate({
		rules: {
			tensanphamcapnhat: {
				required: true,
				minlength: 5,
				maxlength: 45,
			},
			giatiensanphamcapnhat: {
				required: true,
				number: true,
				minlength: 4,
			},
			motasanphamcapnhat: {
				required: true,
				minlength: 50,
			},
			soluongsanphamcapnhat: {
				required: true,
				number: true,
				minlength: 1,
			},
		},
		messages: {
			tensanphamcapnhat: {
				required: "Vui lòng nhập tên sản phẩm.",
				minlength: "Tối thiểu 5 ký tự ",
				maxlength: "Tối đa 45 ký tự ",
			},
			giatiensanphamcapnhat: {
				required: "Vui lòng nhập số.",
				minlength: "Tối thiểu 4 ký tự ",
				number: "Bắt buộc nhập số",
			},
			motasanphamcapnhat: {
				required: "Vui lòng nhập mô tả.",
				minlength: "Tối thiểu 50 ký tự ",
			},
			soluongsanphamcapnhat: {
				required: "Vui lòng nhập số lượng.",
				minlength: "Tối thiểu 1 ký tự ",
				number: "Bắt buộc nhập số",
			},

		}
	});
	$("#btnCapNhatSanPhamAdmin").click(function() {
		var masanphamcapnhat = $("input[name='masanphamcapnhat']").val();
		var tensanphamcapnhat = $("input[name='tensanphamcapnhat']").val();
		var giatiensanphamcapnhat = $("input[name='giatiensanphamcapnhat']").val();
		var motasanphamcapnhat = $("textarea[name='motasanphamcapnhat']").val();
		var hinhanhsanphamcapnhat = $("input[name='hinhanhsanphamcapnhat']").val().replace(/^.*[\\\/]/, '');
		if (hinhanhsanphamcapnhat == "") {
			hinhanhsanphamcapnhat = $("input[name='hinhanhhienthicapnhat']").val();
		}
		var soluongsanphamcapnhat = $("input[name='soluongsanphamcapnhat']").val();
		var madanhmucsanphamcapnhat = $("select[name='madanhmucsanphamcapnhat']").val();
		if (masanphamcapnhat !== "" && tensanphamcapnhat.length >= 5 && tensanphamcapnhat.length <= 45 && giatiensanphamcapnhat >= 1000 && motasanphamcapnhat.length > 49 && soluongsanphamcapnhat >= 0 && madanhmucsanphamcapnhat !== "") {
			$.ajax({
				url: "../api/CapNhatSanPham",
				type: "POST",
				data: {
					masanphamcapnhat: masanphamcapnhat,
					tensanphamcapnhat: tensanphamcapnhat,
					giatiensanphamcapnhat: giatiensanphamcapnhat,
					motasanphamcapnhat: motasanphamcapnhat,
					hinhanhsanphamcapnhat: hinhanhsanphamcapnhat,
					soluongsanphamcapnhat: soluongsanphamcapnhat,
					madanhmucsanphamcapnhat: madanhmucsanphamcapnhat
				},
				success: function(data) {
					window.location.href = "../ManageProduct";
				}
			});
		}
	});
	$("#dangxuatnhanvien").click(function() {
		console.log("Log out");
		$.ajax({
			url: "api/DangXuat",
			type: "POST",
			data: {},
			success: function(data) {
				if (data === "logout") {
					window.location.reload();
				}
			}
		});
	});
	$("#dangxuatnhanvien").click(function() {
		console.log("Log out");
		$.ajax({
			url: "../api/DangXuat",
			type: "POST",
			data: {},
			success: function(data) {
				if (data === "logout") {
					window.location.reload();
				}
			}
		});
	});

});