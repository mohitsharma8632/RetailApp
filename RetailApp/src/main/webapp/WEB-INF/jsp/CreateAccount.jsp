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
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<%@ include file="Header.jsp" %>  
<h1>${msg}</h1>
	<div style='backgroundColor: "lightgrey"'>
		
		<div class="container justify-content-center pt-3">
			<h4 class="text-center"><strong>Create Account</strong></h4>
			<div class="row">
               <div class="offset-md-3 col-md-6">
					<form class="mt-3" action="CreateAccountAction" method="post">
				            <div class="form-group row">
				            	<label for="cid" class="col-12 col-md-4 col-form-label">Customer Id<sup style="color:red">*</sup></label>
				              	<input type="number" class="form-control col-md-8" id="cid" name="customerid" required/>
				            </div>
				            <div class="form-group row">
				            	<label for="accountType" class="col-12 col-md-4 col-form-label">Account Type<sup style="color:red">*</sup></label>
				              	<input type="text" class="form-control col-md-8"  id="accountType" name="accountype" required/>
				            </div>
				            <div class="form-group row">
				            <label for="depositAmount" class="col-12 col-md-4 col-form-label">Deposit Amount<sup style="color:red">*</sup></label>
				              <input type="number" class="form-control col-md-8"  id="depositAmount" name="balance" required/>
				            </div>    
				            <div class="form-group row">
				            	<span style="color:red">(*) Fields are compulsory</span>
				            </div> 
				            <div class="form-group row">
				            	<input type="submit" class="btn btn-dark btn-outline-warning btn-lg offset-md-4" value="submit"/>
				            </div>       
				            
				       
				    </form>
		        </div>
		    </div>
		          
		</div>
		
		
		
	</div>       
	<%@ include file="Footer.jsp" %>   
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>