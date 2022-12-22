<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin/owners</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>



	<link rel="shortcut icon" type="image/png" href="assets/img/favicon.png">
	<!-- google font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
	<!-- fontawesome -->
	<link rel="stylesheet" href="assets/css/all.min.css">
	<!-- bootstrap -->
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<!-- owl carousel -->
	<link rel="stylesheet" href="assets/css/owl.carousel.css">
	<!-- magnific popup -->
	<link rel="stylesheet" href="assets/css/magnific-popup.css">
	<!-- animate css -->
	<link rel="stylesheet" href="assets/css/animate.css">
	<!-- mean menu css -->
	<link rel="stylesheet" href="assets/css/meanmenu.min.css">
	<!-- main style -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- responsive -->
	<link rel="stylesheet" href="assets/css/responsive.css">

</head>
<body>

<jsp:include page="adminHeader.jsp"></jsp:include>

<form action="addOwner" method="post"></form>
<div class="container-md-5 px-5 py-3 my-4 mx-4 border">
<div class="row px-4">

<div class="col-md col-sm-3 px-3 g-2 d-flex justify-content-center">
<h2><i class="text-success">Add the Local Owners</i></h2><br>
</div>

</div>

<div class="row justify-content-center px-4">

<div class="col-auto">
    <label for="inputPassword6" class="col-form-label">Owner Name :</label>
  </div>
  <div class="col-auto">
    <input type="text" id="inputPassword6" class="form-control" name="ownername" placeholder="Owner Name">
  </div>
  <div class="col-auto">
    <label for="inputfile" class="col-form-label">Owner Pic :</label>
  </div>
  <div class="col-auto">
    <input type="file" id="inputfile" class="form-control" name="ownerpic">
  </div>

</div>

 <div class="col-auto">
    <label for="inputtextfeild" class="col-form-label">Description</label>
  </div>
  <div class="col-auto">
    <input type="textarea" id="inputtextfeild" class="form-control" placeholder="About the Owner" name="desc">
  </div>
<div class="col align-items-center g-2"><input type="submit" value="Add Local Owner"> </div>
</div>
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>