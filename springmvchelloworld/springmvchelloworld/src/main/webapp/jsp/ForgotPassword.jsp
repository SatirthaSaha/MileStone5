<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./styles/style.css" />
<link rel="stylesheet" type="text/css" href="./styles/Home.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%-- <form:form action="/verifyOtp" modelAttribute="o">
		<form:input path="otp"/>
		<input type="submit" class="btn btn-primary" value="submit">
	</form:form> --%>
	<div class="container">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<div class="card">
							<div class="card-body">
								<h3 class="card-title text-center" align="center">Forgot Password</h3>
								<hr>
								<form:form class="form" role="form" autocomplete="off" action="/forgot" modelAttribute="o">
									<div class="form-group row">
										<label class="col-lg-4 col-form-label form-control-label">Enter Username:</label>
										<div class="col-lg-8">
											<form:input class="form-control" type="text" path="username"/>
										</div>
									</div>
									
									<div class="form-group row">
										<label class="col-lg-4 col-form-label form-control-label"></label>
										<div class="col-lg-8">
											<div class="col-lg-2"></div>
											<div class="col-lg-3">
												<input type="submit" class="btn btn-success" value="Send Mail">
											</div>
											<div class="col-lg-2"></div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>
			</div>
		</div>
</body>
</html>