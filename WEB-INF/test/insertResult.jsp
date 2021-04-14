<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctxPath = request.getContextPath();
	//     ctxPath = /MyMVC
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 입력 결과 페이지</title>

<script type="text/javascript">

	window.onload = function(){
		alert("데이터 입력 성공!!");
		
		location.href = "<%= ctxPath%>/test/form01_select.up";
	}
</script>

</head>
<body>
	
</body>
</html>