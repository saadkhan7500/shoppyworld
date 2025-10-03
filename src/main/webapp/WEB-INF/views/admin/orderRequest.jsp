<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>OnLine Shopping Site</title>
</head>
<body>
	<!-- Navbar starts here -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="btn btn-outline-danger" href="index1.jsp"><i
			style="font-size: 26px" class="fab fa-speakap"></i> Shoppe World</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index1.jsp"> <span class="glyphicon glyphicon-home "></span>Home
						<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="about.jsp">About
						us</a></li>
				<li class="nav-item"><a class="nav-link" href="session_out.jsp">Logout</a>
				</li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Category </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Mobile</a> <a
							class="dropdown-item" href="#">Electronic</a> <a
							class="dropdown-item" href="#">Womens wear</a> <a
							class="dropdown-item" href="#">Kids wear</a>


						<div class="dropdown-divider">Mens wear</div>

						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>
				<li class="nav-item">
					<!-- Modal -->
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

	<br>
	<br>
	<br>
	<div class="row">
		<div class="col-md-12">
			<table class="table">

				<thead class="thead-dark">
					<tr>
						<th scope="col">Product_ID</th>
						<th scope="col">Product_owner_email</th>
						<th scope="col">User_email</th>
						<th scope="col">Purchase_status</th>
						<th scope="col">User_address</th>
						<th scope="col"></th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="purchase" items="${purchases}">
						<tr>
							<td>${purchase.id }</td>
							<td>${purchase.p_o_email }</td>
							<td>${purchase.user_email }</td>
							<td>${purchase.purchase_status }</td>
							<td>${purchase.address}</td>
							<c:choose>
								<c:when test="${purchase.purchase_status eq 'request'}">

									<td><a class="btn btn-warning"
										href="informVendor?id=${purchase.id}">Inform
											Vendor</a></td>
									<td><a class="btn btn-danger"
										href="Disallow.jsp?id=<%-- <%=rs.getString(1)%> --%>">Send
											Email</a></td>
								</c:when>
								<c:otherwise>
									<td></td>
									<td><a class="btn btn-danger"
										href="final_email.jsp?id=<%-- <%=rs.getString(1)%> --%>&user_email=<%-- <%=rs.getString(3)%> --%>">Send
											Email</a></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<%@ include file="../general/footer.jsp"%>