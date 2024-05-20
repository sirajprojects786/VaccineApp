<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterForm</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/register.css' />" />
<script>
   $(document).ready(function() {
      $('input').attr('autocomplete', 'off');
   });
</script>



</head>
<body class="body">
<div class="div1">
<header class="header">
<div class="login"><a   href="login">Login</a></div></header>
</div>
<div class="div2">
	<form action="getData" method="post" id="form" autocomplete="off">
	<h1 class="head">REGISTRATION FORM</h1>
		
		<label for="username">USERNAME</label><br>
		<input type="text" name="username" id="username"><br>
		<h3>${username}</h3>
	
		
		<label for="password">PASSWORD</label><br>
		<input type="password" name="password" id="password" ><br>
		<h3>${password}</h3>
		
		<label for="confirmpassword">CONFIRMPASSWORD</label><br>
		<input type="password" name="confirmpassword" id="confirmpassword" ><br>
		<h3>${confirmpassword}</h3>
		
		<label for="email">EMAIL</label><br>
		<input type="email" name="email" id="email"><br>
		<h3>${email}</h3>
		
		<label for="mobilenumber">MOBILENUMBER</label><br>
		<input type="number" name="mobilenumber"><br>
		<h3>${mobilenumber}</h3>
		
		
		<div class="gender">
		<label for="gender">GENDER:</label><br>
		<input type="radio" value="male" name="gender" required>
		<label for="male" >MALE</label>
		<input type="radio" value="female" name="gender" required>
		<label for="female" >FEMALE</label><br>
		<h3>${gender}</h3>
		</div>
		
		<div class="dob">
		<label for="dob" >DATEOFBIRTH</label>
		<input type="date" name="dob" id="dateofbirth"><br>
		<h3>${dob}</h3>
		</div>
		
		<div class="register">
		<input type="submit" value="Register" id="register">
		</div>
	
	
	</form>
	</div>
	<div class="div3">
	<h1 id="one">${responseMessage}</h1>
	</div>
<div class="div4">
<footer class="footer"></footer>
</div>

</body>
</html>