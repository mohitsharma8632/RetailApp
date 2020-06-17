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
	<title>Deposit Money</title>
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
		
                <div class="container justify-content-center pt-3" >
                    <h4 class="text-center pl-3"><strong>Tranfer Money</strong></h4>
                    <br/><br/>
                    <div class="row">
                        <div class="offset-md-3 col-md-6">
                            <form class="offset-md-3" action="TransferAction" method="post"> 
                                <div class="form-group row">
                                    <label for="customerId" class="col-12 col-md-4 col-form-label">Source Account Id</label>
                                    <input type="text" class="form-control col-md-8" id="customerId" name="sourceaccountid" required/>

                                </div>
                                <div class="form-group row">
                                    <label for="sourceAccountType" class="col-12 col-md-4 col-form-label">Source Account Type</label>
                                    <input type="text" class="form-control col-12 col-md-8" id="sourceAccountType" name="sourceaccounttype" required/>

                                </div>
                                <div class="form-group row">
                                    <label for="targetAccountType" class="col-12 col-md-4 col-form-label">Target Account id</label>
                                    <input type="text" class="form-control col-12 col-md-8" id="targetAccountType" name="targetaccountid" required/>
                                </div>
                                <div class="form-group row">
                                    <label for="targetAccountType" class="col-12 col-md-4 col-form-label">Target Account Type</label>
                                    <input type="text" class="form-control col-12 col-md-8" id="targetAccountType" name="targetaccounttype" required/>
                                </div>
                                <div class="form-group row">
                                    <label for="tranferAmount" class="col-12 col-md-4 col-form-label">Transfer Amount</label>
                                    <input type="number" class="form-control col-12 col-md-8" id="tranferAmount" name="amount" required/>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="offset-md-2 col-md-5">
                                        <button type="submit" class="btn btn-lg btn-block btn-dark btn-outline-warning">
                                            <strong>Transfer</strong>
                                        </button>
                                    </div>
                                    
                              </div>
                       </form>
                 </div>
             </div>
         </div >
      </div>
	<%@ include file="Footer.jsp" %>   
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>