<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>


	<div class="bg-dark">
            <div class="container">
                <h2 class="pt-2"><span class="text-warning ">FedChoice</span><span class="text-white"> Bank</span></h2>
                <nav class="navbar navbar-expand-lg navbar-light bg-warning mt-5" style=' color: "yellow" '>

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav">
                            <li class="nav-item active">
                                <a class="nav-link" href="Home?msg=Home">Home</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="customerManagement" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Customer Management
                                </a>
                                <div class="dropdown-menu" aria-labelledby="customerManagement">
                                    <a class="dropdown-item" href="CreateCustomer">Create Customer</a>
                                    <a class="dropdown-item" href="CustomerSearch?operation=UpdateCustomer">Update Customer</a>
                                    <a class="dropdown-item" href="CustomerSearch?operation=DeleteCustomer">Delete Customer</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="accountManagement" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Account Management
                                </a>
                                <div class="dropdown-menu" aria-labelledby="accountManagement">
                                    <a class="dropdown-item" href="CreateAccount">Create Account</a>
                                    <a class="dropdown-item" href="AccountSearch?operation=DeleteAccount">Delete Account</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="statusDetails" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Status Details
                                </a>
                                <div class="dropdown-menu" aria-labelledby="statusDetails">
                                    <a class="dropdown-item" href="CustomerStatus">Customer Status</a>
                                    <a class="dropdown-item" href="AccountStatus">Account Status</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="accountOperations" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Account Operations
                                </a>
                                <div class="dropdown-menu" aria-labelledby="accountOperations">
                                    <a class="dropdown-item" href="AccountSearch?operation=Deposit">Deposit</a>
                                    <a class="dropdown-item" href="AccountSearch?operation=Withdraw">Withdraw</a>
                                    <a class="dropdown-item" href="Transfer">Transfer</a>
                                    <a class="dropdown-item" href="Statement">Account Statement</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Logout">Logout</a>
                            </li>

                        </ul>
                    </div>
                </nav>

            </div>
        </div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	

</body>
</html>