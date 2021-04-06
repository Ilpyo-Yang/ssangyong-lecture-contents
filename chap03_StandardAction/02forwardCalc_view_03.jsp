<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// Integer sum = (Integer)request.getAttribute("sum"); 
	int sum = (Integer)request.getAttribute("sum");	
	// ==> autoUnboxing
	// return 타입이 Object 이므로 캐스팅 해주어야 한다.
    int firstNum = (Integer)request.getAttribute("firstNum");
    int secondNum = (Integer)request.getAttribute("secondNum");
    
    
    String s_firstNum = request.getParameter("firstNum");
    String s_secondNum = request.getParameter("secondNum");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산된 결과값을 보여주는 곳</title>
</head>
<body>
	<h3>계산된 결과값-1</h3>
	<%= firstNum%>부터 <%= secondNum%>까지의 합은?<br>
	결과값: <span style="color:red;"><%= sum%></span>
	
	<br><br>
	
	<h3>계산된 결과값-2</h3>
	<%= s_firstNum%>부터 <%= s_secondNum%>까지의 합은?<br>
	결과값: <span style="color:blue;"><%= sum%></span>
</body>
</html>