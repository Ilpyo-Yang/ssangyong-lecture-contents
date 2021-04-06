<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산된 결과값을 보여주는 곳</title>
</head>
<body>
	<h3>계산된 결과값(EL을 사용한 것) -3</h3>
	${requestScope.firstNum}부터 ${requestScope.secondNum}까지의 합은?<br>
	결과값: <span style="color:green;">${requestScope.sum}</span>
	<%-- 
		 ${requestScope.sum} 에서 . 이하 값은 key 값을 의미한다.
		 requestScope 는 생략이 가능하다.
	 --%>
	<br><br>
	
	<h3>계산된 결과값(EL을 사용한 것) -4</h3>
	${firstNum}부터 ${secondNum}까지의 합은?<br>
	결과값: <span style="color:purple;">${sum}</span>
</body>
</html>