<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div class="top-header-area" id="sticker">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12 text-center">
					<div class="main-menu-wrap">
						<!-- logo -->
						<div class="site-logo">
							<a href="index">
								<img src="assets/img/logo.png" alt="">
							</a>
						</div>
						<!-- logo -->

						<!-- menu start -->
						<nav class="main-menu">
							<ul>
								<li class="current-list-item"><a href="#">Home</a>
									<ul class="sub-menu">
										<li><a href="index">Static Home</a></li>
										<li><a href="index_2.jsp">Slider Home</a></li>
									</ul>
								</li>
								<li><a href="about.jsp">About</a></li>
								<li><a href="#">Pages</a>
									<ul class="sub-menu">
										<li><a href="404.jsp">404 page</a></li>
										<li><a href="about.jsp">About</a></li>
										<li><a href="cart.jsp">Cart</a></li>
										<li><a href="checkout.jsp">Check Out</a></li>
										<li><a href="contact.jsp">Contact</a></li>
										<li><a href="news.jsp">News</a></li>
										<li><a href="shop.jsp">Shop</a></li>
									</ul>
								</li>
								<li><a href="news.jsp">News</a>
									<ul class="sub-menu">
										<li><a href="news.jsp">News</a></li>
										<li><a href="single-news.jsp">Single News</a></li>
									</ul>
								</li>
								<li><a href="contact.jsp">Contact</a></li>
								<li><a href="shop.jsp">Shop</a>
									<ul class="sub-menu">
										<li><a href="shop.jsp">Shop</a></li>
										<li><a href="checkout.jsp">Check Out</a></li>
										<li><a href="single-product.jsp">Single Product</a></li>
										<li><a href="cart.jsp">Cart</a></li>
										<li><a href="cart.jsp">login</a></li>
									</ul>
								</li>
								<li>
									<div class="header-icons">
										<a class="shopping-cart" href="cart.jsp"><i class="fas fa-shopping-cart">${kart.size()}</i></a>
										<a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>
										
									</div>
								</li>
								<li>
								<c:choose>
								
								<c:when test="${not empty userid}">
								<h3 class="text-warning">Welcome ${userid.fname}</h3>
								<a href="logout">Logout</a>
								</c:when>
								<c:otherwise><a href="login">Login</a><a href="register">Register</a> </c:otherwise>
								</c:choose>
								</li>
							</ul>
						</nav>
						<a class="mobile-show search-bar-icon" href="#"><i class="fas fa-search"></i></a>
						<div class="mobile-menu"></div>
						<!-- menu end -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- search area -->
	<div class="search-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<span class="close-btn"><i class="fas fa-window-close"></i></span>
					<div class="search-bar">
						<div class="search-bar-tablecell">
							<h3>Search For:</h3>
							<input type="text" placeholder="Keywords" name="fruit">
							<button type="submit" >Search <i class="fas fa-search"></i></button>
							<!-- need to work on the search -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end search arewa -->
	
	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg" >
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<p>Fresh and Organic</p>
						<h1>Check Out Product</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->
