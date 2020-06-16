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
	<title>Withdraw Money</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<style>
		#ssnId,#cId,#oldCustomerName,#oldAddress,#oldAge{
			border:none;
    		background-image:none;
    		background-color:transparent;
    		-webkit-box-shadow: none;
    		-moz-box-shadow: none;
    		box-shadow: none;
		}
	</style>
</head>
<body>
	<%@ include file="Header.jsp" %>
	<div style='backgroundColor: "lightgrey"'>
		
		<div class="container justify-content-center pt-3">
			<h4 class="text-center"><strong>Withdraw Money</strong></h4>
			<form action="WithdrawAction" method="post">
				<table align="center" class="mt-5">
					<tr>
						<td>Customer ID</td>
						<td class="pl-2"> : </td>
						<td class="pl-2">${a.customerid }</td>
					</tr>
					<tr>
						<td>Account ID</td>
						<td class="pl-2"> : </td>
						<td class="pl-2">${a.accountid }</td>
					</tr>
					<tr>
						<td>Account Type</td>
						<td class="pl-2"> : </td>
						<td class="pl-2">${a.accountype }</td>
					</tr>
					<tr>
						<td>Balance</td>
						<td class="pl-2"> : </td>
						<td class="pl-2">${a.balance }</td>
					</tr>
					<tr></tr>
					<tr>
						<td><label for="withdrawAmount" class="col-form-label">Withdraw Amount</label></td>
						<td>:</td>
						<td><input type="number" class="form-control" id="withdrawAmount" name="amount" style="height:30px"/></td>
					</tr>
					<tr>
						<td><input type="hidden" name="sourceaccountid"  value="${a.accountid }" />
						<input type="hidden"  name="sourceaccounttype"  value="${a.accountype }"  />
						</td>
						<td></td>
						<td><input type="submit" class="btn btn-dark btn-outline-warning btn-lg" value="Submit"/></td>
					</tr>
				</table>
				
			</form>
		</div>
	</div>       
	<%@ include file="Footer.jsp" %>   
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>