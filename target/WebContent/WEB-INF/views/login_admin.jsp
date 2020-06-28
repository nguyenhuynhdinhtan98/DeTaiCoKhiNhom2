<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href='<c:url value="./resources/css/util.css"/>' />
<link rel="stylesheet" href='<c:url value="./resources/css/all.css"/>' />
<link rel="stylesheet" href='<c:url value="./resources/css/main.css"/>' />
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title"
					style="background-image: url(./resources/images/bg-01.jpg);">
					<span class="login100-form-title-1"> Sign In </span>
				</div>
				<div class="login100-form validate-form" method="post"
					action="api/admin-login">
					<div class="wrap-input100 validate-input m-b-26"
						data-validate="Username is required">
						<span class="label-input100">User Name</span> <input
							class="input100" type="text" name="username"
							placeholder="Enter User Name"> <span
							class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-18"
						data-validate="Password is required">
						<span class="label-input100">Password</span> <input
							class="input100" type="password" name="pass"
							placeholder="Enter password"> <span
							class="focus-input100"></span>
						<div class="invalid-feedback" id="userfailadmin">Kiểm tra tài
							khoản.</div>
					</div>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn btnLoginAdmin" id="btnLoginAdmin">Login</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>