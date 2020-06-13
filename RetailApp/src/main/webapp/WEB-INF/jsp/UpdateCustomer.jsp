<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateCustomerAction" method="post">
            <div class="form-group">
              <input type="text" class="form-control form-control-lg" placeholder="New Name" name="name" />
            </div>
            <div class="form-group">
              <input type="text" class="form-control form-control-lg" placeholder="New Address" name="address" />
            </div>
            <div class="form-group">
              <input type="text" class="form-control form-control-lg" placeholder="New Age" name="age" />
            </div>            <input type="submit" class="btn btn-info btn-block mt-4" value="submit"/>
          </form>

</body>
</html>