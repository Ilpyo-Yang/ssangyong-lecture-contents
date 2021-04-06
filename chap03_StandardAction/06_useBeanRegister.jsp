<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form 태그를 이용한 데이터 전송시 useBean 을 사용하여 결과보여주기</title>
</head>
<body>
	<h2>개인성향 입력 결과 정보(JSP 표준액션 중 useBean 을 사용한 것)</h2>

<%--	
	<jsp:useBean id="psdto" class="chap03.PersonDTO"/>
	<jsp:setProperty property="name" name="psdto" value="${param.name}" />
	<jsp:setProperty property="school" name="psdto" value="${param.school}" />
	<jsp:setProperty property="color" name="psdto" value="${param.color}" />
	<jsp:setProperty property="food" name="psdto" value="${paramValues.food}" />
	 request.parameterValues 와 동일 
--%>
	<%-- 
	          또는 위의 것을 아래의 것으로 대체가 가능하다. 
		  단, 전제조건은 06_useBeanForm_execute_01.jsp 파일의 form 태그 내에 있는 name 값으로 준 것이 chap03.PersonDTO 의 field 명과 같아야 한다. 
	--%>
	<jsp:setProperty property="*" name="psdto"/>
	
	<ul>
		<li>성명: <jsp:getProperty property="name" name="psdto" /></li>
		<li>학력: <jsp:getProperty property="school" name="psdto" /></li>
		<li>색상: <jsp:getProperty property="color" name="psdto" /></li>
		<li>음식: <jsp:getProperty property="strFood" name="psdto" /></li>
	</ul>
</body>
</html>