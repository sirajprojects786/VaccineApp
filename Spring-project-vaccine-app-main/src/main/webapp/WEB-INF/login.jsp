<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">
<title>LOGIN</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/login.css' />" />
<script>
   $(document).ready(function() {
      $('input').attr('autocomplete', 'off');
   });
</script>

</head>
<body class="body">
<div class="div1">
<header class="header"></header>
</div>
<div class="div2">
	<form action="getLogin" method="post" autocomplete="off" >
	<h1 class="login">LOGIN</h1>
		<label for="email">Email</label> <br>
		<input type="email" id="email" name="email" > <br> 
		<h3>${email}</h3>
		<label for="password">PASSWORD</label><br>
		<input type="password" id="password" name="password">
		<h3>${password}</h3>
		<a  id="fp" href="getForgetPassword">ForgetPassword?</a><br>
		<input type="submit" class="submit" value="LOGIN"><br>
		<p>Don't have an account?<a id="Rr" href="getRegisterData">Register</a></p>
 		
	</form>
</div>
<div class="div4">
	<h3>${mismatch}</h3>
	</div>
<div class="div3">
<footer class="footer"></footer>
</div>

</body>
</html>