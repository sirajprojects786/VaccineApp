<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForgetPassword</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/forgetpassword.css' />" />
</head>
<body class="body">
<div class="div1">
<header class="header">

<div class="login"><a   href="login">Login</a></div>
</header>
</div>
<div class="div2">
<form action="getNewPassword" method="post">
<h1 class="change">CHANGE PASSWORD</h1>
		<label for="email">Email</label> <br>
		<input type="email" id="email" name="email" > <br> 
		<h3>${email}</h3>
		
		<label for="password">Password</label> <br>
		<input type="password" id="password" name="password" > <br> 
		<h3>${password}</h3>
		
		<label for="confirmPaassword">ConfirmPassword</label><br> 
		<input type="password" id="confirmPassword" name="confirmPassword" > <br>
		<h3>${confirmpassword}</h3> 
		
		<input class="submit" type="submit" value="RESETPASSWORD">
		<h1 class="data" >${data }</h1>
</form>
</div>
<div class="div3">
<footer class="footer"></footer>
</div>

</body>
</html>