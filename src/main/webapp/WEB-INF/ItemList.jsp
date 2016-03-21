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
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
$(function(){
	
	var itemId = $("#itemId").val();
	alert(itemId+"\t clicked");
	$("#quantityId"+itemId).on("click", updateRemainingQuantity);

		
	/* alert("jquery is on");
	$(".validateQuantity").onclick(function(){
		alert("sth is changed in input area");
		var regex = /^[0-9\b]+$/;
		var inputVal=$(".validateQuantity").val();
		alert("sth is changed in input area"+$(".validateQuantity").val());
		if($(".validateQuantity").val()!=null || !regex.test(inputVal) ){
				//alert("you entered\t"+$(".validateQuantity").val());
				alert("sth is changed in input area red"+$(".validateQuantity").val());
				$("input").css("background-color", "red");
			}
		else{
			$("input").css("background-color", "green");
			alert("sth is changed in input area green "+$(".validateQuantity").val());
			}
		}); */
});
function updateRemainingQuantity(){
	alert("Inside function updateRemainingQuantity");
	var itemId = $("#itemId").val();
	alert("item id is\t"+itemId);
	alert("you quantity is \t"+ $("#inputQuantity"+itemId).val());
	alert("total quantity" + $("#hiddenTotalQuantity"+itemId).val());
}

</script> -->
<title>Insert title here</title>
</head>
<body>
           <BR/>
			<h2>Shopping Cart Item List Records</h2>
			<BR/><BR/>
			<fieldset style="width:700px">
			<input type="text" name="search" placeholder="search">
			<button type="button" name="category">CATEGORY</button>
			<button type="button" name="SEARCH">SEARCH</button><br><br>
			<TABLE cellSpacing=1 cellPadding=2 bgcolor=#f0f0f0 width=800 align=left border=2>
			<TR>
			<TH>PRODUCT ID</TH>
			<TH>PRODUCT NAME</TH>
			<TH>PRODUCT QUANTITY</TH>
			<!-- <TH>SELECT QUANTITY</TH> -->
			<TH>PRODUCT PRICE</TH>
			</TR>
			
			
			<c:forEach items="${results}" var="list" >
				<TR>
				<TD>${list.id}</TD>
				
				<TD>${list.itemName}</TD>
				<TD>
				${list.quantity}
<%-- 				<input type="hidden" id="hiddenTotalQuantity${list.id}" value="${list.quantity}"> --%>
				</TD>
			<%-- 	<td>
				<input id="inputQuantity${list.id}" class="validateQuantity" placeholder="number only" pattern="^[0-9]*$" type="number" name="quantity" >
				
				</td> --%>
				<TD>${list.itemPrice}</TD>
				<TD align="center"><a href="AddToCartServlet?id=${list.id}&action=ordernow">order now</a>
				</TD>
				</TR>
	           </c:forEach>
				
				</TABLE>
		 	</fieldset> 
			</body>
</html>
