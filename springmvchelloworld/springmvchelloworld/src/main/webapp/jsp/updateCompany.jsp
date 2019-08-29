<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,com.example.stockspring.model.Company,com.example.stockspring.model.User"
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
	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	<c:if test="${sessionScope.user.id==null}">
		<%
			response.sendRedirect("/Home");
		%>
	</c:if>
	<c:if test="${(sessionScope.user.usertype).equals('user') }">
	<%response.sendRedirect("/AccessDenied"); %>
	</c:if>
	<%
		User user = (User) request.getAttribute("user");
		System.out.println(user);
	%>
	<%
		List<Company> companyList = (List) request.getAttribute("companyList");
		System.out.println("+++++++++++++++++++++++++");
		System.out.println(companyList);
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
				<spring:url value="/importData" var="url1" htmlEscape="true" />
				<li><a href="${url1}">Import Data</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Manage Company<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<spring:url value="/insertCompany" var="url2" htmlEscape="true" />
						<li><a href="${url2 }" style="color: white;">Add Company</a></li>
						<spring:url value="/companyList" var="url3" htmlEscape="true" />
						<li><a href="${url3 }" style="color: white;">Update
								Company</a></li>
						<spring:url value="/companyList" var="url3" htmlEscape="true" />
						<li><a href="${url3 }" style="color: white;">List of all
								Companies</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Manage Exchange<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<spring:url value="/registerStock" var="url4" htmlEscape="true" />
						<li><a href="${url4 }" style="color: white;">Register New
								Stock Exchange</a></li>
						<spring:url value="/listStock" var="url5" htmlEscape="true" />
						<li><a href="${url5 }" style="color: white;">List Stock
								Exchange</a></li>
					</ul></li>
				<spring:url value="/updateIPODetails" var="url6" htmlEscape="true" />
				<li><a href="${url6 }">Update IPO details</a></li>

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
						<h3 class="card-title text-center" align="center">Update a
							Company</h3>
						<hr>
						<table>
							<thead>
								<tr>
									<th>Company Code</th>
									<th>Company Name</th>
									<th>Turnover</th>
									<th>CEO</th>
									<th>Board of Directors</th>
									<th>Sector Id</th>
									<th>Brief WriteUp</th>
									<th>Stock Code</th>

									<th style="border-right: none;"></th>
								</tr>
							</thead>
							<tbody id="myTable">
								<%
									for (int i = 0; i < companyList.size(); i++) {
										Company e = (Company) companyList.get(i);
								%>
								<%-- <tr>
									<td><%=e.getCompany_code()%></td>
									<td><%=e.getCompany_Name()%></td>
									<td><%=e.getTurnover()%></td>
									<td><%=e.getCeo()%></td>
									<td><%=e.getBoardOfDirectors()%></td>
									<td><%=e.getSector_id()%></td>
									<td><%=e.getBreifwriteup()%></td>
									<td><%=e.getStock_Code()%></td>
									<%
										String val = Integer.toString(e.getCompany_code());
									%>
									<spring:url value="/editCompany/{<%=val%>}" var="uc"
										htmlEscape="true" />
									<td style="border-right: none;"><a type="button"
										class="btn btn-success" href="${uc }">Edit</a></td>
									<spring:url value="/deleteCompany/${e.getCompany_code }"
										var="dc" htmlEscape="true" />
									<td style="border-right: none;"><a type="button"
										class="btn btn-danger" href="dc">Delete</a></td>
								</tr> --%>
								<%
									}
								%>
								<c:forEach items="${companyList}" var="companyList" varStatus="status">
									<tr>
										<td>${companyList.company_code}</td>
										<td>${companyList.company_Name}</td>
										<td>${companyList.turnover}</td>
										<td>${companyList.ceo}</td>
										<td>${companyList.boardOfDirectors}</td>
										<td>${companyList.sector_id}</td>
										<td>${companyList.breifwriteup}</td>
										<td>${companyList.stock_Code}</td>
										<td style="border-right: none;"><a type="button" class="btn btn-success"
											href="<c:url value='/editCompany/${companyList.company_code}' />">Edit</a></td>
									</tr>
								</c:forEach>
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