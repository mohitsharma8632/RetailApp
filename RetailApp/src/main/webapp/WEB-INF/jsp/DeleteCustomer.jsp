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
			<h4 class="text-center"><strong>Delete Customer</strong></h4>
			<div class="row">
               <div class="offset-md-3 col-md-6">
					<form class="mt-3" action="DeleteCustomerAction" method="post">
                        <div class="form-group row">
                              <label for="ssnId" class="col-12 col-md-4 col-form-label">SSN Id: ${c.ssnid }</label>
                              <input type="hidden" class="form-control col-md-8" id="ssnId" name="ssnid"  value="${c.ssnid }" />
                        </div>
                        <div class="form-group row">
                              <label for="customerId" class="col-12 col-md-4 col-form-label">Customer Id: ${c.customerid }</label>
                              <input type="hidden" class="form-control col-md-8" id="customerId" name="customerid"   value="${c.customerid }"  />
                        </div>
                        <div class="form-group row">
                                    <label for="name" class="col-12 col-md-4 col-form-label">Customer Name: ${c.name }</label>
                                    <input type="hidden" class="form-control col-12 col-md-8" id="name" name="name"   value="${c.name }"  />

                        </div>
                        <div class="form-group row">
                                    <label for="age" class="col-12 col-md-4 col-form-label">Age: ${c.age }</label>
                                    <input type="hidden" class="form-control col-12 col-md-8" id="age" name="age"   value="${c.age }"  />
                        </div>
                        <div class="form-group row">
                                    <label for="address" class="col-12 col-md-4 col-form-label">Address: ${c.address }</label>
                                    <input type="hidden" class="form-control col-12 col-md-8" id="address" name="address"   value="${c.address }"  />
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