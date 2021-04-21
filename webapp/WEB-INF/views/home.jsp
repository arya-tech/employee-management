<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home-page</title>
</head>
<body>
	<h2 style="font-family: fantasy;color: red;font-size: 30px">Manager Login</h2>
	<form action="${PageRequest.request.PathContext}/manager/loginCheck/${emailId}/${password}", method="post">
		Email	 :	<input type="text" value="emailId"/><br/><br/>
		Password :	<input type="password" value="password"/><br/><br/>
		<input type="submit" value="Log-In"/>
	</form>
</body>
</html>