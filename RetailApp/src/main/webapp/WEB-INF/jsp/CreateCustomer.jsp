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
		
                <div class="container justify-content-center pt-3" >
                    <h4 class="text-center pl-3"><strong>Create Customer Screen</strong></h4>
                    <br/><br/>
                    <div class="row">
                        <div class="offset-md-3 col-md-6">
                            <form class="offset-md-3" action="CreateCustomerAction" method="post"> 
                                <div class="form-group row">
                                    <label for="ssnId" class="col-12 col-md-4 col-form-label">Customer SSN Id<sup style="color:red">*</sup></label>
                                    <input type="text" class="form-control col-md-8" id="ssnId" name="ssnid" required/>

                                </div>
                                <div class="form-group row">
                                    <label for="name" class="col-12 col-md-4 col-form-label">Customer Name<sup style="color:red">*</sup></label>
                                    <input type="text" class="form-control col-12 col-md-8" id="name" name="name" required/>

                                </div>
                                <div class="form-group row">
                                    <label for="age" class="col-12 col-md-4 col-form-label">Age<sup style="color:red">*</sup></label>
                                    <input type="number" class="form-control col-12 col-md-8" id="age" name="age" required/>
                                </div>
                                <div class="form-group row">
                                    <label for="address" class="col-12 col-md-4 col-form-label">Address<sup style="color:red">*</sup></label>
                                    <input type="text" class="form-control col-12 col-md-8" id="address" name="address" required/>
                                </div>
                                <div class="form-group row">
                                    <label for="" class="col-12 col-md-4 col-form-label">State<sup style="color:red">*</sup></label>

                                    <select class="form-control col-12 col-md-8" name="state" id="state" required>
                                    	<option value="">Select</option>
                                        <option value="Madhya Pradesh">Madhya Pradesh</option>
                                        <option value="Uttar Pradesh">Uttar Pradesh</option>
                                        <option value="Maharashtra">Maharashtra</option>
                                        <option value="Gujrat">Gujrat</option>
                                        <option value="Karnataka">Karnataka</option>
                                    </select>

                                </div>
                                <div class="form-group row">
                                    <label for="" class="col-12 col-md-4 col-form-label">City<sup style="color:red">*</sup></label>

                                    <select class="form-control col-12 col-md-8" name="city" id="city" required>
                                    	<option value="">Select</option>
                                        <option value="Indore">Indore</option>
                                        <option value="Pune">Pune</option>
                                        <option value="Mumbai">Mumbai</option>
                                        <option value="Gwalior">Gwalior</option>
                                        <option value="Bangalore">Bangalore</option>
                                        <option value="Ahemdabad">Ahemdabad</option>
                                        <option value="Patna">Patna</option>
                                    </select>

                                </div>
                                <div class="form-group row">
				            		<span style="color:red">(*) Fields are compulsory</span>
				            	</div>
                                <div class="form-group row">
                                    <div class="offset-md-2 col-md-4">
                                        <button type="submit" class="btn btn-lg btn-block btn-dark btn-outline-warning">
                                            <strong>Submit</strong>
                                        </button>
                                    </div>
                                    <div class=" col-md-4">
                                        <button type="reset" class="btn btn-lg btn-block btn-dark btn-outline-warning offset-md-2">
                                            <strong>Reset</strong>
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