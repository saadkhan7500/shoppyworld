<%@page import="java.sql.*"%>
<%@ include file="../general/header1.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<br>
<br>
<div class="row">
	<div class="col-md-12">
		<table class="table table-bordered bg-info">

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
						<td>${purchase.product_id}</td>
						<td>${purchase.p_o_email}</td>
						<td>${purchase.user_email}</td>
						<td>${purchase.purchase_status}</td>
						<td>${purchase.address}</td>

						<c:choose>
							<c:when test="${purchase.purchase_status eq 'show-vendor'}">
								<td><a class="btn btn-warning"
									href="verify_product.jsp?id=${purchase.product_id}">Deliver_product</a></td>

							</c:when>
							<c:otherwise>
								<td></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="../general/footer.jsp"%>
