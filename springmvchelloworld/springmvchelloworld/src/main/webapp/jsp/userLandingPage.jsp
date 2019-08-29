<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,com.example.stockspring.model.User"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./styles/style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%response.setHeader("Cache-Control","no-cache");
	  response.setHeader("Cache-Control","no-store");
	  response.setHeader("Pragma","no-cache");
	  response.setDateHeader ("Expires", 0); %>
	<c:if test="${sessionScope.user.id==null}">
		<%response.sendRedirect("/Home"); %>
	</c:if> 
	<c:if test="${(sessionScope.user.usertype).equals('admin') }">
	<%response.sendRedirect("/AccessDenied"); %>
	</c:if>
	<%
		User user = (User) request.getAttribute("user");
	%>
	<div class="header">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid" style="background: black">
				<div class="navbar-header">
					<img alt="logo" src="./images/logo.png">
				</div>
				<div class="navbar-header">
					<a class="navbar-brand" href="#" style="color: white"><b>&nbsp;Stock
							Exchange Chart</b></a>
				</div>
				<ul class="nav navbar-nav">
					<spring:url value="/getIPODetails" var="url6" htmlEscape="true" />
					<li><a href="${url6 }">IPOs</a></li>
					<spring:url value="/compareCompany" var="url1" htmlEscape="true" />
					<li><a href="${url1}">Compare Company</a></li>
					<spring:url value="/graph" var="url2" htmlEscape="true" />
					<li><a href="${url2 }">Stock Graph</a></li>
				</ul>
				<div class="nav navbar-nav navbar-right" id="logout">
					<form:form action="/logout" method="GET">
						<button class="btn navbar-btn">Logout</button>
					</form:form>
				</div>
			</div>
		</nav>
	</div>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<img class="aligncenter" alt="userphoto"
			src="./images/Profilepicture.jfif" width="200px" height="200px"
			style="padding-left: 40px;"><br>
		<hr>
		<p class="aligncenter" style="color: white;">ID:
			${sessionScope.user.id }</p>
		<hr>
		<p class="aligncenter" style="color: white;">Name:
			${sessionScope.user.username }</p>
		<hr>
		<p class="aligncenter" style="color: white;">Mail ID:
			${sessionScope.user.email }</p>
		<hr>
		<p class="aligncenter" style="color: white;">Contact Number:
			${sessionScope.user.mobilenumber }</p>
		<hr>

	</div>
	<span style="font-size: 30px; color: white; cursor: pointer"
		onclick="openNav()">&#9776;</span>
	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
		}
	</script>
	<div class="container">
		<!-- Code starts from here -->
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="./images/carousel1.jpg" alt="Los Angeles"
						style="width: 100%; height: 100%">
				</div>

				<div class="item">
					<img src="./images/carousel2.jpg" alt="Chicago"
						style="width: 100%; height: 100%">
				</div>

				<div class="item">
					<img src="./images/carousel3.jpg" alt="New york"
						style="width: 100%; height: 100%">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>


		<!-- Code ends here -->
	</div>
	<div class="footer">
		<h4>Copyright © 2019 Stock Exchange Chart-All Rights Reserved</h4>
	</div>

</body>
</html>