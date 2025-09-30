<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Image</title>
</head>
<body>

<h2>Upload Image for Product ID: ${productId}</h2>

<form action="uploadImage" method="post" enctype="multipart/form-data">
    <input type="hidden" name="productId" value="${productId}" />
    <input type="file" name="file" required />
    <input type="submit" value="Upload" />
</form>

<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>

</body>
</html>