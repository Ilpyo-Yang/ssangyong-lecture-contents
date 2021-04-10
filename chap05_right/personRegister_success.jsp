<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctxPath = request.getContextPath();
	// ctxPath ==> /JSPServletBegin 이다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 성향 입력한 결과 성공인 경우에 보여주는 페이지</title>
<script type="text/javascript">
	// Function Declaration
	function goSelect () {
		// === !! 암기 !! === //
		// 자바스크립트에서 URL 페이지 이동은 location.href="이동할 URL 경로명"; 으로 하면 된다.
		location.href="<%= ctxPath%>/personSelect.do";
	}
</script>
</head>
<body>
	<h2>개인성향 입력 성공</h2>
	<br>
	
	<%-- <button onclick="javascript:goSelect()">입력결과 조회하기</button> --%>
	<button onclick="goSelect()">입력결과 조회하기</button>
</body>
</html>