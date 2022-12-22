<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

	<!-- title -->
	<title>Check Out</title>

	<!-- favicon -->
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
	
	<!--PreLoader-->
    <div class="loader">
        <div class="loader-inner">
            <div class="circle"></div>
        </div>
    </div>
    <!--PreLoader Ends-->
	
	<!-- header -->

	<!-- end header -->

<jsp:include page="header.jsp"></jsp:include>

	<!-- check out section -->
	<div class="checkout-section mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="checkout-accordion-wrap">
						<div class="accordion" id="accordionExample">
						  <div class="card single-accordion">
						    <div class="card-header" id="headingOne">
						      <h5 class="mb-0">
						        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
						          Billing Address
						        </button>
						      </h5>
						    </div>

						    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
						      <div class="card-body">
						        <div class="billing-address-form">
						        	<form action="placeOrder?location=PlaceOrder.jsp"  method="post">
						        		<p><input type="text" placeholder="Name" name="name" value="${userid.fname} ${userid.lname}"></p>
						        		<p><input type="email" placeholder="Email" name="email" value="${userid.email}"></p>
						        		<p><input type="text" placeholder="Address" name="address" value="${param.address}"></p>
						        		<p><input type="tel" placeholder="Phone" name="mobile" value="${userid.mobile}"></p>
						        		<p><input type="hidden" name="location" value="${param.location}"></p>
						        		
						        </div>
						      </div>
						    </div>
						  </div>
						 
						  
						</div>

					</div>
				</div>
			<c:set var="total" value="${0}"></c:set>
				<div class="col-lg-4">
					<div class="order-details-wrap">
						<table class="order-details">
							<thead>
								<tr>
									<th>Your order Details</th>
									<th>Price</th>
								</tr>
							</thead>
							<tbody class="order-details-body">
							
								<tr>
									<td>Item Name </td>
									<td>Sub-Total</td>
								</tr>
							
							<c:forEach var="cart" items="${kart}">
								<tr>
									<td><c:out value="${cart.itemName}"></c:out></td>
									<td><c:out value="${cart.price*cart.quantity}"></c:out> </td>
									<c:set var="total" value="${total+cart.price*cart.quantity}"> </c:set>
								</tr>
							</c:forEach>
								
							</tbody>
							<tbody class="checkout-details">
								
								<tr>
									<td>Total</td>
									<td><c:out value="${total}"></c:out> </td>
								</tr>
							</tbody>
						</table>
						<c:choose>
						<c:when test="${not empty userid}">
							<input type="submit" value="Place Order">
						</c:when>
						<c:otherwise>
							<a href="login.jsp?location=PlaceOrder.jsp" class="boxed-btn">login</a>
						</c:otherwise>
						</c:choose>
						        	</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end check out section -->

	<!-- logo carousel -->
		<!-- end logo carousel -->

<jsp:include page="footer.jsp"></jsp:include>
	
	<!-- jquery -->
	<script src="assets/js/jquery-1.11.3.min.js"></script>
	<!-- bootstrap -->
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- count down -->
	<script src="assets/js/jquery.countdown.js"></script>
	<!-- isotope -->
	<script src="assets/js/jquery.isotope-3.0.6.min.js"></script>
	<!-- waypoints -->
	<script src="assets/js/waypoints.js"></script>
	<!-- owl carousel -->
	<script src="assets/js/owl.carousel.min.js"></script>
	<!-- magnific popup -->
	<script src="assets/js/jquery.magnific-popup.min.js"></script>
	<!-- mean menu -->
	<script src="assets/js/jquery.meanmenu.min.js"></script>
	<!-- sticker js -->
	<script src="assets/js/sticker.js"></script>
	<!-- main js -->
	<script src="assets/js/main.js"></script>

</body>
</html>