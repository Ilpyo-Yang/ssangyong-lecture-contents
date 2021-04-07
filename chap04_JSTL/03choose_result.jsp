<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose 를 사용하여 전송되어져 온 주민번호를 가지고 성별을 파악한 결과물 출력하기</title>
</head>
<body>
	<c:set var="jubun" value="${param.jubun}" />
	<c:set var="len" value="${fn:length(jubun)}" />
	<c:set var="genderno" value="${fn:substring(jubun,6,7)}" />
	
	주민번호 : ${jubun}<br> <%-- EL(Express Language) --%>
	주민번호  문자열 길이 : ${len}<br>
	성별을 나타내주는 숫자 : ${genderno}<br>
	
	<br>
	<c:if test="${len eq 0}">
		<span style="color:red;">주민번호를 입력하지 않으셨습니다!</span>
	</c:if>
	
	<c:if test="${len ne 0 and len ne 13}">
		<span style="color:blue;">주민번호의 길이가 맞지 않습니다!</span>
	</c:if>
	
	<c:if test="${len eq 13}">
		<c:choose>
			<c:when test="${genderno eq '2'}">
				1900년대생 여자입니다.
			</c:when>	<%-- if 와 같은 느낌 --%>
			
			<c:when test="${genderno eq '4'}">
				2000년대생 여자입니다.
			</c:when>	<%-- else if 와 같은 느낌 --%>
			
			<c:otherwise>
				남자입니다.
			</c:otherwise>	<%-- else 와 같은 느낌 --%>
		</c:choose>
		
		<br>
		<c:choose>
			<c:when test="${genderno eq '1' or '3'}">
				남자입니다.
			</c:when>	<%-- if 와 같은 느낌 --%>

			<c:otherwise>
				여자입니다.
			</c:otherwise>	<%-- else 와 같은 느낌 --%>
		</c:choose>
		
	</c:if>
	
</body>
</html>