<%@page import="com.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
       <%

    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    
    if(session.getAttribute("uname")==null){  
    	response.sendRedirect("index");
    }  
    
    
    %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Account Status</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<style>
		th{
			
		}
	</style>
</head>
<body>
	<%@ include file="Header.jsp" %>
	<div class="container">
		<h4 class="justify-content-center">Account Status</h4>
		<table align="center" border="1">
				<tr class=" bg-warning">
					<th>Customer ID</th>
					<th>Account ID</th>
					<th>Account Type</th>
					<th>Account Status</th>
					<th>Message</th>
					<th>Last Updated</th>
						
				</tr>
			<c:forEach items="${alist}" var="account">
				<tr>
					<td>${account.customerid}</td>
					<td>${account.accountid }</td>
					<td>${account.accountype }</td>
					<td>${account.status } </td>
					<td>${account.message }</td>
					<td>${account.date}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<%@ include file="Footer.jsp" %>   
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>