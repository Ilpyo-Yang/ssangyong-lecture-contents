<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String friendNames1 = "김성경,채연하,한서연,박서준,박보영";
	String friendNames2 = "이제훈,고수.강동원,주원/이순신";
    
	request.setAttribute("friendNames1", friendNames1);
	request.setAttribute("friendNames2", friendNames2);
	
    RequestDispatcher dispatcher = request.getRequestDispatcher("06forTokens_view.jsp"); 
    dispatcher.forward(request, response);
%> 

