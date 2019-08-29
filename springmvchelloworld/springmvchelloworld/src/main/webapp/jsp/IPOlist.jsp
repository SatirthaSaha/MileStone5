<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,com.example.stockspring.model.Ipo_planned,com.example.stockspring.model.User"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		System.out.println(user);
	%>
	<%
		List<Ipo_planned> IPOList = (List) request.getAttribute("IPOList");
		System.out.println("+++++++++++++++++++++++++");
		System.out.println(IPOList);
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
		<div class="row">

			<div class="col-sm-10">
				<div class="card">
					<div class="card-body">
						<h3 class="card-title text-center" align="center">List of
							IPOs</h3>
						<hr>
						<table>
							<thead>
								<tr>
									<th>ID</th>
									<th>Company Code</th>
									<th>Stock Exchange</th>
									<th>Total no. of shares</th>
									<th>Open Date Time</th>
									<th>Price/Share</th>
									<th style="border-right: none;">Remarks</th>
								</tr>
							</thead>
							<tbody id="myTable">
								<%
										for (int i = 0; i < IPOList.size(); i++) {
											Ipo_planned e = (Ipo_planned) IPOList.get(i);
									%>
								<tr>
									<td><%=e.getId() %></td>
									<td><%=e.getCompany_code()%></td>
									<td><%=e.getStock_exchange()%></td>
									<td><%=e.getTotal_no_of_shares()%></td>
									<td><%=e.getOpen_date_time()%></td>
									<td>₹<%=e.getPrice_per_share()%></td>
									<td style="border-right: none;"><%=e.getRemarks()%></td>
								</tr>
								<%}%>

							</tbody>
						</table>
					</div>
				</div>
			</div>


		</div>
		<!-- Code ends here -->
	</div>
	<div class="footer">
		<h4>Copyright © 2019 Stock Exchange Chart-All Rights Reserved</h4>
	</div>

</body>
</html>