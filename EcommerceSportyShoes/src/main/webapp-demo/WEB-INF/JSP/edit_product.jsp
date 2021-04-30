<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
<%@include file="_header.jsp" %>
<br>

<div id ="container">
	<h3>Update customer</h3>
	<p/>
		<form:form action="UpdateProduct" modelAttribute="product" method="POST">
			
			<table>
						<tbody>
							<tr>								
								<td><label>Product ID:</label></td>								
								<td><form:input path="productId"/></td>
							</tr>
							<tr>
								<td><label>Enter product Name</label></td>
								<td><form:input path="productName"/></td>
							</tr>
							<tr>
								<td><label>Product Category</label></td>
								<td><form:input path="productCategory"/></td>
							</tr>
							<tr>
								<td><label>Product Price</label></td>
								<td><form:input path="price"/></td>
							</tr>
							<tr>
								<td><label>Product Quantity</label></td>
								<td><form:input path="quantity"/></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="Save" class="add-button"/></td>
							</tr>
						</tbody>
				</table>
		</form:form>
</div>
</body>
</html>