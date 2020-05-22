<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer the amound</title>
</head>
<body>
<form action="Transfer">
<h2>YOUR BALANCE IS=<% out.println(session.getAttribute("balance")); %>rs</h2>
Recvr accno=<input type="text" name="raccno" placeholder="enter the acc no" required="required">

amount Rs=<input type="text" name="amt" placeholder="ebnter he amount" required="required" >
<input type="submit" value="send">
</form>

</body>
</html>