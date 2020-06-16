<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if(session.getAttribute("uname")!=null){  
    	response.sendRedirect("Home");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  *, *:before, *:after { box-sizing: border-box; margin: 0; padding: 0; }
 body {
	 font-family: 'Open Sans', Helvetica, Arial, sans-serif;
	 background: #ededed;
}
input, button {
	 border: none; outline: none; background: none;
	 font-family: 'Open Sans', Helvetica, Arial, sans-serif;
}
.container {
	 overflow: hidden;
	 position: relative;
	 width: 900px;
	 height: 550px;
	 margin: 0 auto 100px;
	 background: #fff;
}
.form {
	 position: relative;
	 width: 640px;
	 height: 100%;
	 transition: transform 1.2s ease-in-out;
	 padding: 50px 30px 0;
}
 button {
	 display: block;
	 margin: 0 auto;
	 width: 260px;
	 height: 36px;
	 border-radius: 30px;
	 color: #fff;
	 font-size: 15px;
	 cursor: pointer;
}
 h2 {
	 width: 100%;
	 font-size: 26px;
	 text-align: center;
}
 label {
	 display: block;
	 width: 260px;
	 margin: 25px auto 0;
	 text-align: center;
}
 label span {
	 font-size: 12px;
	 color: #cfcfcf;
	 text-transform: uppercase;
}
 input {
	 display: block;
	 width: 100%;
	 margin-top: 5px;
	 padding-bottom: 5px;
	 font-size: 16px;
	 border-bottom: 1px solid rgba(0, 0, 0, 0.4);
	 text-align: center;
}
 .submit {
	 margin-top: 40px;
	 margin-bottom: 20px;
	 background: #d4af7a;
	 text-transform: uppercase;
}
.sign-in {
	 transition-timing-function: ease-out;
}
 .cont.sign-in {
	 transition-timing-function: ease-in-out;
	 transition-duration: 1.2s;
	 transform: translate3d(640px, 0, 0);
}
  
    </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
  <form action="LoginAction" method="post" class="form sign-in">
    <h2>${msg }</h2>
<br>    <h2>Log in</h2>
    <label> <span></span> <input type="text" placeholder="User Name" name="uname" required/>  </label>
    <label> <span></span> <input type="password" placeholder="Password" name="password" required/> </label>
    <input type="submit" class="submit"  value ="log in">
        </form>
  </div>

</body>
</html>