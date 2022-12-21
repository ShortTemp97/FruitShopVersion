<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>


</head>
<body>

<div class="container-md text-center">

<form action="logging?location=${param.location}" method="post"><!--  -->
<div class="row mx-auto pt-5">
<h1>Welcome to Ekart...</h1>
<h3><i>Login please!!</i></h3>

	<span>${message}</span>
	<div class="col-md-5 col-sm mx-auto pt-2 pb-2">
	
		UserName:&nbsp;<input type="email" name="mail" placeholder="email" value="${param.mail}">
	</div>
	<input type="hidden" name="location" value="${param.location}">
	<div>
		<div class="col-md-5 col-sm mx-auto pt-2 pb-2">
		Password:&nbsp;<input type="password" name="password" placeholder="password">
		<br>
		</div>
		<input type="submit" class="btn btn-primary" value="login">
		<br><br>
		Create a <a href="register">Account?</a>
	</div>


</div>
</form>

</div>



</body>
</html>