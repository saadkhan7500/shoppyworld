<%@ include file="header.jsp"%>
<%-- <%@page import="java.sql.*"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- banner starts here -->
<div class="container mt-3">
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
		</ol>
		<div class="carousel-inner">

			<div class="carousel-item active">
				<img class="d-block w-100"
					src="${pageContext.request.contextPath}/resources/images/b1.jpg"
					alt="First slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="${pageContext.request.contextPath}/resources/images/b2.jpg"
					alt="Second slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="${pageContext.request.contextPath}/resources/images/b3.jpg"
					alt="Third slide">
			</div>
			<div style="height: 50%;" class="carousel-item ">
				<img class="d-block w-100"
					src="${pageContext.request.contextPath}/resources/images/courosel-image1.png"
					alt="Fourth slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</div>
<hr>
<!-- banner ends here -->
<!-- card starts here -->

<div id="container">
	<div class="row mt-3 mr-2 ml-2">
		<c:forEach var="product" items="${products}">
			<div class="col-md-2">
				<div id="p_img" class="card">
					<span style="background-color: #EFDECD" class="badge badge-default">
						<h5>${product.discount}%off</h5>
					</span> <a href="show_item.jsp?id=${product.id}"> <img
						style="width: 100%; height: 300px"
						src="${pageContext.request.contextPath}/resources/images/${product.p_i_name}"
						class="img-fluid img-thumbnail" alt="Responsive image" />
					</a>
					<div class="card-body">
						<h6>Rs.${product.product_price}</h6>
						<h6 class="card-title">${product.product_name}</h6>
						<p class="card-text">${product.product_details}</p>
						<a href="checkoutProduct?id=${product.id}" class="btn btn-primary">Check
							Out</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<hr>

<!-- card ends here -->
<div class="container">
	<div class="row mt-2">
		<div class="col-sm-4">
			<img
				src="${pageContext.request.contextPath}/resources/images/card11.jpg"
				class="img-fluid" alt="Responsive image">
		</div>
		<div class="col-sm-4">
			<img
				src="${pageContext.request.contextPath}/resources/images/card12.jpg"
				class="img-fluid" alt="Responsive image">
		</div>
		<div class="col-sm-4">
			<img
				src="${pageContext.request.contextPath}/resources/images/card13.jpg"
				class="img-fluid" alt="Responsive image">

		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
