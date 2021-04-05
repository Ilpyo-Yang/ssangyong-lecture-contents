<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// Integer sum = (Integer)request.getAttribute("sum"); 
	int sum = (Integer)request.getAttribute("sum");	// ==> autoUnboxing
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산된 결과값을 보여주는 곳</title>
</head>
<body>
	<h3>계산된 결과값</h3>
	<br><br>
	결과값: <span style="color:red;"><%= sum%></span>
</body>
</html>