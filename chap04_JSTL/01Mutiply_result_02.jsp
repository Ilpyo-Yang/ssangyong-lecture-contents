<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- ===== JSTL(JSP Standard Tag Library) 사용하기 ===== --%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- == 변수의 선언방법 == --%>
<c:set var="num1" value="${param.firstNum}" />
<c:set var="num2" value="${param.secondNum}" />
<c:set var="result" value="${num1*num2}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두 개의 수를 입력받아 곱셈한 결과를 출력하기</title>
</head>

<body>
	${num1}와 ${num2}의 곱은 ${result}입니다.
	${param.firstNum}와 ${param.secondNum}의 곱은 ${result}입니다.
</body>
</html>