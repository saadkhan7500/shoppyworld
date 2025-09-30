
<%@ include file="../general/header1.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Navbar ends here -->

<br>
<div class="row jumbotron">
	<div class="col-md-12">
		<h1>Welcome! ${vendor.name}</h1>
		<p>We provide you to best and pure deals on your branded
			products.. The price you mention for your product is directly seen by
			the user who visit our website for shopping. So please enter the
			valid Price for your Product</p>
	</div>

</div>
<div class="row ">
	<div class="col-md-3">
		<div id="p_img" class="thumbnail">
			<a href="addProduct"> <img style="width: 70%; height: 70%"
				src="${pageContext.request.contextPath}/resources/images/product.png">
				<h4 class="btn btn-info">Add new product</h4>
			</a>
		</div>
	</div>
	<div class="col-md-3">
		<div id="p_img" class="thumbnail">
			<a href="vendorProduct?email=${vendor.email}"> <img style="width: 70%; height: 70%"
				src="${pageContext.request.contextPath}/resources/images/seshe.png">
				<h4 class="btn btn-info">
					My product <span style="font-size: 20px;"
						class="badge badge-warning">
						<%-- <%=notify %> --%>
					</span>
				</h4>
			</a>
		</div>
	</div>

	<div class="col-md-3">
		<div id="p_img" class="thumbnail">
			<a href="#"> <img style="width: 70%; height: 70%"
				src="${pageContext.request.contextPath}/resources/images/money.png">
				<h4 class="btn btn-info">Total product Sale</h4>
			</a>
		</div>

	</div>

	<div class="col-md-3">
		<div id="p_img" class="thumbnail">
			<a href="vendorToBeDeliverProduct?email=${vendor.email}"> <img style="width: 70%; height: 70%"
				src="${pageContext.request.contextPath}/resources/images/deliver.png">
				<h4 class="btn btn-info">Item to be deliver</h4>
			</a>
		</div>
	</div>
</div>
<%@ include file="../general/footer.jsp"%>
