<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberEdit</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/member.css' />" />
</head>
<body class="body">
	<div class="div1">
		<header class="header">
			
		</header>
	</div>
	<div class="div2">
		<form action="${pageContext.request.contextPath}/update/${memberId}" method="post" id="form">
			<h1 class="head">EDIT MEMBER</h1>
  			<label for="name">NAME</label><br> 
			<input type="text" name="name" id="name" value="${NAME}"><br>
			<h3>${name}</h3>

			<div class="gender">
				<label for="gender">GENDER:</label><br> 
				<input type="radio" value="male" name="gender" 
				<c:if test="${GENDER eq 'male'}">checked="checked"</c:if>>
				<label for="male">MALE</label>
				<input type="radio" value="female" name="gender"
				<c:if test="${GENDER eq 'female'}">checked="checked"</c:if> >
				<label for="female">FEMALE</label><br>
				<h3>${gender}</h3>
			</div>

			<div class="dob">
				<label for="dob">DATEOFBIRTH</label> 
				<input type="date" name="dob" id="dob" value="${DATE_OF_BIRTH}"><br>
				<h3>${dob}</h3>
			</div>

			<label for="idProof">SELECT ID PROOF</label><br>
			<div class="select">
				<select name="idProof" id="idProof">
					<option value="AadharCard" <c:if test="${ID_PROOF eq 'AadharCard'}">selected</c:if>>AADHAR CARD</option>
					<option value="PanCard"<c:if test="${ID_PROOF eq 'PanCard'}">selected</c:if>>PAN CARD</option>
					<option value="DrivingLicense"<c:if test="${ID_PROOF eq 'DrivingLicense'}">selected</c:if>>DRIVING LICENSE</option>
					<option value="VoterId"<c:if test="${ID_PROOF eq 'VoterId'}">selected</c:if>>VOTER ID</option>
				</select>
				<h3>${idProof}</h3>
			</div>

			<label for="idProofNo">ID PROOF NUMBER</label><br> 
			<input type="text" name="idProofNo" id="idProofNo" value="${ID_PROOF_NO}"> <br>
			<h3>${idProofNo}</h3>

			<label for="vaccineType">SELECT VACCINE TYPE </label><br>
			<div class="select">
				<select name="vaccineType" id="vaccineType">
					<option value="CovidShield"<c:if test="${VACCINE_TYPE eq 'CovidShield'}">selected</c:if>>COVID SHIELD</option>
					<option value="Covaxin"<c:if test="${VACCINE_TYPE eq 'Covaxin'}">selected</c:if>>COVAXIN</option>
					<option value="Sputrik"<c:if test="${VACCINE_TYPE eq 'Sputrik'}">selected</c:if>>SPUTRIX</option>
				</select>
				<h3>${vaccineType}</h3>
			</div>

			<label for="dose">SELECT DOSE</label><br>
			<div class="select">
				<select name="dose" id="dose">
					<option value="Dose1"<c:if test="${DOSE eq 'Dose1'}">selected</c:if>>DOSE-1</option>
					<option value="Dose2"<c:if test="${DOSE eq 'Dose2'}">selected</c:if>>DOSE-2</option>
					<option value="Dose3"<c:if test="${DOSE eq 'Dose3'}">selected</c:if>>DOSE-3</option>
				</select>
				<h3>${dose}</h3>
			</div>

			<div class="register">
				<input type="submit" value="REGISTER" id="register">
			</div>



		</form>
	</div>
	<div class="div3">
		<h1 id="one">${responseMessage}</h1>
		<h1>${Message}</h1>
	</div>
	<div class="div4">
		<footer class="footer"></footer>
	</div>

	

</body>
</html>