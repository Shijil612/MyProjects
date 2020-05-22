<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BALANCE CHEK</title>
</head>
<body>
<h1>DEAR CUSTOMER</h1>
<h2>YOUR BALANCE IS=<% out.println(session.getAttribute("balance")); %>rs</h2>
<br>
<a href="home.jsp">HOME</a>

</body>
</html>