<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<br>
<%-- <%@page import="java.sql.*"%>
<%!String auther_name;
	String p_o_email;
	String product_name;
	int product_price;
	String product_category;
	String product_detail;
	int product_discount;
	int final_price;
	ResultSet rs;
	String pic;
	String id;%>
<%
id = request.getParameter("id");
HttpSession s1 = request.getSession();
s1.setAttribute("id", id);
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "mysql");
	Statement stmt = con.createStatement();
	rs = stmt.executeQuery("select * from sw_product where id='" + id + "'");
	if (rs.next()) {
		p_o_email = rs.getString(2);
		s1.setAttribute("p_o_email", p_o_email);
		auther_name = rs.getString(3);
		product_name = rs.getString(5);
		product_price = Integer.parseInt(rs.getString(6));
		product_category = rs.getString(7);
		product_detail = rs.getString(8);
		product_discount = Integer.parseInt(rs.getString(10));

		int discount_price = (product_price * product_discount) / 100;
		final_price = product_price - discount_price;
		pic = rs.getString(14);

	}
} catch (Exception e) {

}
%> --%>

<c:set var="discountPrice"
	value="${(product.product_price * product.discount) / 100}" />
<c:set var="finalPrice" value="${product.product_price - discountPrice}" />
<div class="container-fluid">
	<div class="row">
		<div id="p_img" class="col-md-3">
			<a href="#" class="thumbnail"> <img
				style="height: 90%; width: 100%"
				src="${pageContext.request.contextPath}/resources/images/${product.p_i_name}"
				alt="...">
			</a>
		</div>
		<div class="col-md-9 ">
			<h3>${product.product_owner_name}</h3>
			<h5>${product.product_category}|${product.product_name}</h5>
			<hr>
			<h2 class="text text-success">${product.discount}%OFF</h2>
			<h4>
				Price: <strike class="text text-danger">Rs.
					${product.product_price}</strike> Rs. ${finalPrice}
			</h4>

			<p>Inclusive of all taxes</p>
			<select name="color">
				<option selected>Qty</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</select>
			<p>${product.product_details}</p>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#exampleModal5">
				<span class="glyphicon glyphicon-shopping-cart"></span> Add to cart
			</button>
			<a class="btn btn-success" href="customer_login.jsp"> <span
				class="glyphicon glyphicon-euro"></span> Buy now
			</a>

			<%-- 

			<%
			String msg1 = request.getParameter("msg");

			if ("success".equalsIgnoreCase(msg1)) {
			%>
			<span class="text text-success">Added to cart successfully</span>
			<%
			} else if ("notadded".equalsIgnoreCase(msg1)) {
			%>
			<span class="text text-danger">Already added</span>
			<%
			}
			%>



 --%>
			<!-- Modal -->
			<div class="modal fade" id="exampleModal5" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Login Form</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>

						<div class="modal-body">
							<!-- Loginform body starts here -->
							<div class="container">
								<div class="row">
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<form action="add_cart.jsp">
											<label>Email:</label> <input type="Email"
												class="form-control" placeholder="email" name="email"
												required> <label>Password:</label> <input
												type="password" class="form-control" placeholder="password"
												name="pass" required> <br> <input type="hidden"
												name="id"value=<%-- <%=id%> --%>> <input
												type="submit" class="btn btn-primary" value="login">
										</form>
									</div>
								</div>
							</div>
							<!-- Loginform  body ends here -->
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<hr>



<div id="container">
	<div class="row mt-3 mr-2 ml-2">
		<%-- 
		<%!ResultSet rs1;
	int i;%>


		<%
		HttpSession sess = request.getSession();
		String search = (String) sess.getAttribute("search");

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "mysql");
			Statement stmt = con.createStatement();

			rs1 = stmt.executeQuery("select * from sw_product where product_category ='" + product_category + "'");

			while (rs1.next()) {
		%>
 --%>
		<c:forEach var="product" items="${relatedProducts}">
			<div class="col-md-2">
				<%-- <div id="p_img" class="card">
					<span style="background-color: #EFDECD" class="badge badge-default">
						<h5><%=rs.getString(10)%>%off
						</h5>
					</span> <a href="show_item.jsp?id=<%=rs.getString(1)%>"><img
						style="width: 100%" src="images/<%=rs.getString(14)%>"
						class="img-fluid img-thumbnail" alt="Responsive image"></a>

					<div class="card-body">
						<h6>
							Rs.<%=rs.getString(6)%></h6>
						<h6 class="card-title"><%=rs.getString(5)%></h6>
						<p class="card-text"><%=rs.getString(8)%></p>
						<a href="show_item.jsp?id=<%=rs.getString(1)%>"
							class="btn btn-primary">Check Out</a>
					</div>
				</div> --%>
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

		<%-- 		<%
		i++;

		}
		i = 1;
		} catch (Exception e) {
		out.println(e);
		}
		%>
	</div> --%>
	</div>
	<%@ include file="footer.jsp"%>