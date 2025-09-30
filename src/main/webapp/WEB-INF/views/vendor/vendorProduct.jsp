<%@ include file="../general/header1.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<hr>
<hr>
<hr>
<hr>
<table class="table">

	<thead class="thead-dark">
		<tr>
			<th scope="col">s.no</th>
			<th scope="col">PO_Email</th>
			<th scope="col">PO_name</th>
			<th scope="col">PO_contact</th>
			<th scope="col">P_name</th>
			<th scope="col">P_Price</th>
			<th scope="col">P_category</th>
			<th scope="col">P_details</th>
			<th scope="col">P_status</th>
			<th scope="col"></th>

		</tr>
	</thead>

	<tbody>
		<c:forEach var="product" items="${products}">
			<tr>
				<th scope="row">${product.id}</th>
				<td>${product.product_owner_email}</td>
				<td>${product.product_owner_name}</td>
				<td>${product.product_owner_contact}</td>
				<td>${product.product_name}</td>
				<td>${product.product_price}</td>
				<td>${product.product_category}</td>
				<td>${product.product_details}</td>
				<td>${product.product_status}</td>
				<c:choose>
					<c:when test="${product.p_i_name == null}">
						<td><a class="btn btn-info"
							href="uploadProductImage?id=${product.id }">upload
								image </a></td>
					</c:when>
					<c:otherwise>
						<td><a class="btn btn-success"
							href="uploadProductImage?id=${product.id }">image
								uploaded </a></td>

					</c:otherwise>
				</c:choose>	
			</tr>
		</c:forEach>
	</tbody>

</table>

<br>
<%@ include file="../general/footer.jsp"%>
