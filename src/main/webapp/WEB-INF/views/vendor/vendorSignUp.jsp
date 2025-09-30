<%@ include file="../general/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<br>


<div id="form" class="row justify-content-center ">
	<div class=" col-md-6 border border-muted ">

		<h1 class="text text-muted ml-1">Vendor Registration</h1>
		<c:choose>
			<c:when test="${msg == 'success'}">
				<p style="color: green;">
					<img style="height: 220px; width: 280px;"
						src="${pageContext.request.contextPath}/resources/images/succ.gif" />
					successfully registered
				</p>
				<c:remove var="msg2" scope="session" />
			</c:when>

			<c:when test="${msg == 'fail'}">
				<p style="color: green;">
					<img alt=""
						src="${pageContext.request.contextPath}/resources/images/exclamation5.png" />
					Email already exist
				</p>
				<c:remove var="msg2" scope="session" />
			</c:when>

			<c:otherwise>
				<!-- Optionally, show nothing or some default content -->
			</c:otherwise>
		</c:choose>


		<hr>
		<form action="createVendor" onsubmit="return validation()"
			method="post">

			<div class="form-group ">
				<label for="exampleInputEmail1">Email address</label> <input
					type="text" class="form-control bg-info" id="email"
					placeholder="Enter email" name="email" autocomplete="off">
				<span id="msg" class="text text-danger"> </span>
			</div>


			<div class="form-group ">
				<label for="exampleInputEmail1">Name</label> <input type="text"
					id="name" class="form-control bg-info" placeholder="Enter name"
					name="name" autocomplete="off"> <span id="msg1"
					class="text text-danger"> </span>
			</div>


			<div class="form-group ">
				<label for="exampleInputEmail1">Contact</label> <input type="text"
					id="num" class="form-control bg-info" placeholder="Enter contact"
					name="contact" autocomplete="off"> <span id="msg2"
					class="text text-danger"> </span>
			</div>

			<div class="form-group ">
				<label for="exampleInputEmail1">Password</label> <input
					type="password" name="password" class="form-control bg-info"
					id="pass" placeholder="Enter Password" name="password" required
					autocomplete="off">
			</div>

			<div class="form-group ">
				<label for="exampleInputEmail1">Confirm Password</label> <input
					type="password" id="confirm-pass" class="form-control bg-info"
					id="confirm" placeholder="Enter Password Again" name="confirm_pass"
					required autocomplete="off"> <span id="msg3"
					class="text text-danger"> </span>
			</div>



			<input type="submit" class="btn btn-success mb-3" value="submit">


		</form>
	</div>
</div>

<br>
<br>




<script>
	function validation() {
		patt1 = new RegExp("@gmail.com");
		var email = document.getElementById('email').value
		var name = document.getElementById('name').value
		var num = document.getElementById('num').value
		var pass = document.getElementById('pass').value
		var confirm_pass = document.getElementById('confirm-pass').value
		if (!(patt1.test(email))) {
			document.getElementById("msg").innerHTML = "**Enter Valid Email";
			return false;
		}

		else if ((name.length < 3) || (name.length > 15)) {
			document.getElementById("msg1").innerHTML = "name length is not proper";
			return false;
		} else if (isNaN(num) || num.length != 10) {
			document.getElementById("msg2").innerHTML = "**Enter Valid number";
			return false;
		} else if (pass != confirm_pass) {
			document.getElementById("msg3").innerHTML = "**password is not matched";
			return false;
		} else {
			return true;
		}
	}
</script>
</body>
</html>

