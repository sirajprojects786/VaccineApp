<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">
<title>Home</title>


<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/home.css' />" />
</head>
<body class="body">
<div class="div1">
		<header class="header">
	 
	<script>
		        function go() {

			window.location
					.replace(
							"logout",
							'window',
							'toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');

			self.close()

		}
	
	</script>
	
	<%
	String str = request.getParameter("email");
	session.setAttribute("EMAIL",  request.getParameter("email"));

	%>
	
	
	  <h3> user:  <%=session.getAttribute("EMAIL")%></h3>
	
	
	
	
	    <%

	if (session.getAttribute("EMAIL").equals("")) {

	%>    
	<a href="login"><b>Login </b></a>     <%

	} else{
	%>
	<div class="log">
	<a  class="logout" href="javascript:go()">LOGOUT</a></div><%
	}

	%>
			<div class="div2">
				<a href="setmember">ADD MEMBER</a>
			</div>
			
		</header>
	</div>
	<div class="border1">
	<h1><b>REGISTER COUNT</b></h1>
	<h1 class="count" >${memberCount}</h1>
	
	</div>
	<div class="border2">
	<h1>COVID-19</h1>
	<p>COVID-19 most often causes respiratory symptoms that can feel much like a cold, the flu, or pneumonia.
	 COVID-19 may attack more than your lungs and respiratory system.
	 Other parts of your body may also be affected by the disease. 
	 Most people with COVID-19 have mild symptoms, but some people become severely ill.</p>
	
	</div>
	<div class="border3">
	<h1>COVID SHIELD</h1>
	<img alt="image of covid shield" src="resources/images/covashield.jpeg">
	
	</div>
	<div class="border4">
	<h1>COVAXIN</h1>
	<img alt="image of covaxin" src="resources/images/covaxin.jpg">
	
	</div>
	<div class="border5">
	<h1>SPUTRIX</h1>
	<img alt="image of sputnik" src="resources/images/sputnik.jpg">
	
	</div>
	

	<div class="div3">
		<footer class="footer"></footer>
	</div>



</body>
</html>