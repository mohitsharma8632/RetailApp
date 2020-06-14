<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
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
			<h4 class="text-center"><strong>Update Customer</strong></h4>
			<div class="row">
               <div class="offset-md-3 col-md-6">
					<form class="mt-3" action="CreateAccountAction" method="post">
				            <div class="form-group row">
				            	<label for="ssnId" class="col-12 col-md-4 col-form-label">Customer SSN ID</label>
				            	<!-- value to be displayed from obtained java object and input filed is disabled -->
				            	<input type="text" class="form-control col-md-8" id="ssnId" name="ssnId" value=<%= "customer.ssnId" %> disabled="disabled"/>
				            </div>
				            <div class="form-group row">
				            	<label for="cId" class="col-12 col-md-4 col-form-label">Customer ID</label>
				            	<!-- value to be displayed from obtained java object and input filed is disabled -->
				              	<input type="text" class="form-control col-md-8" id="cId" name="cId" value=<%= "customer.id" %> disabled="disabled"/>
				            </div>
				            <div class="form-group row">
				            	<label for="oldCustomerName" class="col-12 col-md-4 col-form-label">Old Customer Name</label>
				            	<!-- value to be displayed from obtained java object and input filed is disabled -->
				            	<input type="text" class="form-control col-md-8" id="oldCustomerName" name="oldCustomerName" value=<%= " customer.name" %> disabled="disabled"/>
				              	
				            </div>
				            <div class="form-group row">
				            	<label for="newCustomerName" class="col-12 col-md-4 col-form-label">New Customer Name<sup style="color:red">*</sup></label>
				              	<input type="text" class="form-control col-md-8"  id="newCustomerName" name="newCustomerName" required/>
				            </div>
				            <div class="form-group row">
				            	<label for="oldAddress" class="col-12 col-md-4 col-form-label">Old Address</label>
				            	<input type="text" class="form-control col-md-8" id="oldAddress" name="oldAddress" value=<%= "customer.address" %> disabled="disabled"/>
				            </div>
				            <div class="form-group row">
				            <label for="newAddress" class="col-12 col-md-4 col-form-label">New Address<sup style="color:red">*</sup></label>
				              <input type="text" class="form-control col-md-8"  id="newAddress" name="newAddress" required/>
				            </div>     
				            <div class="form-group row">
				            	<label for="oldAge" class="col-12 col-md-4 col-form-label">Old Age</label>
				            	<input type="text" class="form-control col-md-8" id="oldAge" name="oldAge" value=<%= "customer.age" %> disabled="disabled"/>
				            </div>
				            <div class="form-group row">
				            <label for="newAge" class="col-12 col-md-4 col-form-label">New Age<sup style="color:red">*</sup></label>
				              <input type="text" class="form-control col-md-8"  id="newAge" name="newAge" required/>
				            </div> 
				            <div class="form-group row">
				            	<span style="color:red">(*) Fields are compulsory</span>
				            </div>
				            <div class="form-group row">
				            	<input type="submit" class="btn btn-dark btn-outline-warning btn-lg offset-md-4" value="Update"/>
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