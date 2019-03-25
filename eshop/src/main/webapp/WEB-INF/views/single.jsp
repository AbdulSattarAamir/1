<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is single.jsp

<p>${p.productId}</p>
<p>${p.productName}</p>
<p>${p.productPrice}</p>



<a href="addtocart?proid=${p.productId}">add to cart</a>

</body>
</html>
