<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/member.css' />" />
	<script>
   $(document).ready(function() {
      $('input').attr('autocomplete', 'off');
   });
</script>
	
</head>
<body class="body">
	<div class="div1">
		<header class="header">
			<div class="divtag">
			
			<a href="${pageContext.request.contextPath}/viewmembers">VIEW MEMBERS</a>
				</div>
				<div class="logout">
				<a  class="logout1" href="logout">LOGOUT</a>
				</div>
		</header>
	</div>
	<div class="div2">
		<form action="getmember" method="post" id="form" autocomplete="off">
			<h1 class="head">ADD MEMBER</h1>

			<label for="name">NAME</label><br> <input type="text"
				name="name" id="name"><br>
			<h3>${name}</h3>

			<div class="gender">
				<label for="gender">GENDER:</label><br> 
				<input type="radio" value="male" name="gender" required > 
				<label for="male">MALE</label>
				<input type="radio" value="female" name="gender" required> 
				<label for="female">FEMALE</label><br>
				<h3>${gender}</h3>
			</div>

			<div class="dob">
				<label for="dob">DATEOFBIRTH</label> <input type="date" name="dob"
					id="dob"><br>
				<h3>${dob}</h3>
			</div>

			<label for="idProof">SELECT ID PROOF</label><br>
			<div class="select">
				<select name="idProof" id="idProof">
					<option value="AadharCard">AADHAR CARD</option>
					<option value="PanCard">PAN CARD</option>
					<option value="DrivingLicense">DRIVING LICENSE</option>
					<option value="VoterId">VOTER ID</option>
				</select>
				<h3>${idProof}</h3>
			</div>

			<label for="idProofNo">ID PROOF NUMBER</label><br> <input
				type="text" name="idProofNo" id="idProofNo"> <br>
			<h3>${idProofNo}</h3>

			<label for="vaccineType">SELECT VACCINE TYPE </label><br>
			<div class="select">
				<select name="vaccineType" id="vaccineType">
					<option value="CovidShield">COVID SHIELD</option>
					<option value="Covaxin">COVAXIN</option>
					<option value="Sputrik">SPUTRIX</option>
				</select>
				<h3>${vaccineType}</h3>
			</div>

			<label for="dose">SELECT DOSE</label><br>
			<div class="select">
				<select name="dose" id="dose">
					<option value="Dose1">DOSE-1</option>
					<option value="Dose2">DOSE-2</option>
					<option value="Dose3">DOSE-3</option>
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

	<div class="div5">

		<h1 class="tag">MEMBER DETAILS</h1>
		<table class="table "border="1">

			<tr>
				<th>MEMBER_ID</th>
				<th>NAME</th>
				<th>GENDER</th>
				<th>DATE OF BIRTH</th>
				<th>ID PROOF</th>
				<th>ID PROOF NO</th>
				<th>VACCINE TYPE</th>
				<th>DOSE</th>
				<th>DELETE</th>
				<th>EDIT</th>
				
				
			</tr>


			<c:forEach items="${members}" var="member">
				<tr>
					<td>${member.memberId}</td>
					<td>${member.name}</td>
					<td>${member.gender}</td>
					<td>${member.dob}</td>
					<td>${member.idProof}</td>
					<td>${member.idProofNo}</td>
					<td>${member.vaccineType}</td>
					<td>${member.dose}</td>
					<div class="delete">
				<td><a href="delete/${member.idProofNo}">Delete</a></td>
			</div>
			<div class="update">
				<td><a href="edit/${member.memberId}">Edit</a></td>
			</div>
					
				</tr>
			</c:forEach>

		</table>
		
		<h3>${delete}</h3>

	</div>

</body>
</html>