<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;">${msg}</h2>
          <form action="LoginAction" method="post">
            <div class="form-group">
              <input type="text" class="form-control form-control-lg" placeholder="User Name" name="uname" />
            </div>
            <div class="form-group">
              <input type="password" class="form-control form-control-lg" placeholder="Password" name="password" />
            </div>
            <input type="submit" class="btn btn-info btn-block mt-4" value="submit"/>
          </form>
</body>
</html>