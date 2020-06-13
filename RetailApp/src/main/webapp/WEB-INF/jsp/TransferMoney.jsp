<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="TransferMoneyAction" method="post">
            <div class="form-group">
              <input type="text" class="form-control form-control-lg" placeholder="Customer id" name="customerid" />
            </div>
            <div class="form-group">
              <input type="text" class="form-control form-control-lg" placeholder="Source Account type" name="sourceaccountype" />
            </div>
            <div class="form-group">
              <input type="text" class="form-control form-control-lg" placeholder="Target Account type" name="targetaccountype" />
            </div>
            <div class="form-group">
              <input type="text" class="form-control form-control-lg" placeholder="Amount" name="amount" />
            </div>            <input type="submit" class="btn btn-info btn-block mt-4" value="submit"/>
          </form>
</body>
</html>