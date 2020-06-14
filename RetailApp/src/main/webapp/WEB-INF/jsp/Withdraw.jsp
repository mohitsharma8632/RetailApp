<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%

    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    
    if(session.getAttribute("uname")==null){  
    	response.sendRedirect("");
    }  
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="WithdrawMoneyAction" method="post">
            <div class="form-group">
              <input type="text" class="form-control form-control-lg" placeholder="Withdraw Amount" name="amount" />
            </div>            <input type="submit" class="btn btn-info btn-block mt-4" value="submit"/>
          </form>

</body>
</html>