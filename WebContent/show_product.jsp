<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1" style="width:100%">
<tr>
<td> 
	<c:forEach items="${cat_list}" var="cat">
		<a href="Controller?id=show_product&cat_id=<c:out value="${cat.getId()}"> </c:out>"><br>
		<c:out value="${cat.getName()}"> </c:out>
		</a>
	</c:forEach>
</td>

<td>
<h1> All Products </h1>
	<c:forEach var="p" items="${list}" >
		<c:if test="${p.getCat().getId() == cid }" >
			
			<h3> <c:out value="${p.getPname()}" /> </h3>
			Price: Rs. <c:out value="${p.getPrice()}" /> <br>
			<c:out value="${p.getShort_desc() }" /> <br>
			<a href="Controller?id=show_product_detail&pid=<c:out value="$(p.getPid()}"> </c:out>">
			View Details </a> &nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#"> Add To Cart </a>
			<hr>
		</c:if>
	</c:forEach>

</table>
</body>
</html>