<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Ekart account</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>


</head>
<body>

<div class="container-md border-3 text-center pt-3">
<h1><i>Register for EKart</i></h1>


<form action="registration" method="post" >
${error}<!-- from the request.setAttribute() from CreateAccountServlet class -->
<div class="row mx-auto pt-5">
<div class="col">
FirstName:&nbsp;<input type="text" name="fname" placeholder="FirstName" value="${param.fname}">
LastName:&nbsp;<input type="text" name="lname" placeholder="LastName" value="${param.lname}">
</div>
</div>
<div class="row mx-auto g-3 mt-4 pt-3">
<div class="col">
DOB&nbsp;<input type="date" name="dob" value="${param.dob}">&nbsp;&nbsp;
Mobile&nbsp;<input type="text" name="mobile" value="${param.mobile}">
Email:&nbsp;<input type="email" name="email" placeholder="email with @ must" value="${param.email}">
</div>
<input type="hidden" name="location" value="${param.location}">
<div class="row mx-auto pt-5">
<div class="col col-md col-sm">
Password:&nbsp;<input type="password" name="password" placeholder="Password">
Confirm Password:&nbsp;<input type="password" name="upassword" placeholder="confirm password">
</div>
</div>
<div class="col"><input type="file" value="choose Profile picture" name="profilePic"> </div>
<div class="row mx-auto pt-5">
<div class="col col-md col-sm">
<input type="submit"  value="register" class="btn btn-info">
</div>
</div>

<input type="text" name="userId">
<a href="viewImg">View Image</a>
</div>

</form>
Already have <a href="logging">Account?</a>

</div>

</body>
</html>