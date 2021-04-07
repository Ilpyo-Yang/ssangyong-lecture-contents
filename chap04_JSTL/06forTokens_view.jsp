<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- ===== JSTL(JSP Standard Tag Library) 사용하기 ===== --%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forTokens 를 이용하여 친구이름 출력하기</title>
</head>
<body>

	<h2>친구명단 - 1</h2>
	
	<c:if test="${empty requestScope.friendNames1}">
		<span>친구가 없으시군요~~ ^_____^</span>
	</c:if>
	
	<c:if test="${not empty requestScope.friendNames1}">
		<c:set var="arrFriendNames1" value="${ fn:split(requestScope.friendNames1, ',') }" /> 
		<ol>
			<c:forEach var="name" items="${arrFriendNames1}">
				<li>${name}</li>
			</c:forEach>
		</ol>
	</c:if>
	
	<hr style="border: solid 1px red;" />
	
	<h2>친구명단 - 2</h2>
	
	<c:if test="${empty requestScope.friendNames2}">
		<span>친구가 없으시군요~~ ^_____^</span>
	</c:if>
	
	<c:if test="${not empty requestScope.friendNames2}">
		<ul>
			<c:forTokens var="name" items="${requestScope.friendNames2}" delims=",./">
				<%-- forTokens 에서 items="${}" 에 들어오는 것은 배열이나 List가 아닌 하나의 문자열이 들어온다. --%> 
				<%-- 문자열을  , 또는 . 또는 / 으로 잘라서 배열로 만들어 준다. --%> 
				<li>${name}</li>
			</c:forTokens>
		</ul>
	</c:if>

</body>
</html>


