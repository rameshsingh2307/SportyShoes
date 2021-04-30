<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<%@include file="_header.jsp" %>
	<br>
	<div id="container">
	
		<div id="content">
			
			<table>
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Product Category</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="productIter" items="${product}">
						<c:url var="delete" value="/delete">
							<c:param name="productId" value="${productIter.productId}"/>
						</c:url>
						
						<c:url var="update" value="/update">
							<c:param name="productId" value="${productIter.productId}"/>
						</c:url>
						<tr>
							<td>${productIter.productName}</td>
							<td>${productIter.productCategory}</td>
							<td>${productIter.price}</td>
							<td>${productIter.quantity}</td>	
							<td><a href="${delete}">Delete</a> | <a href="${update}">Update</a></td>		
						</tr>		
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	
	</div>
</body>
</html>