<%@page import="com.cubic.vo.ItemVO"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Cart Info</title>
</head>
<body>
  <a href="ItemList">Continue Shopping</a>
			<TABLE cellSpacing=1 cellPadding=2 bgcolor=#f0f0f0 width=800 align=left border=2>
			<TR>
			<TH>OPTION</TH>
			<TH>PRODUCT ID</TH>
			<TH>PRODUCT NAME</TH>
			<TH>PRODUCT QUANTITY</TH>
			<TH>PRODUCT PRICE</TH>
			</TR>
			
			
			<c:forEach items="${sessionScope.cart}" var="l" >
				<TR>
				<TD align="center">Delete</TD>
				<TD>${l.item.id}</TD>
				
				<TD>${l.item.itemName}</TD>
				<TD>
				${l.quantity}</TD>
			
				<TD>${l.item.itemPrice * l.quantity}</TD>
				<TD align="center"><a href="AddToCartServlet?id=${list.id}&action=ordernow">order now</a>
				</TD>
				</TR>
	           </c:forEach>
				
				</TABLE>
		 	
			</body>
</html>
