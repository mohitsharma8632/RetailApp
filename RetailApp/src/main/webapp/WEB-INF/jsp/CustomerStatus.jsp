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

</body>
</html>