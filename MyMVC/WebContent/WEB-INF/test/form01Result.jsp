<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test/form01_result.up 페이지</title>

<style type="text/css">

	li {
		line-height: 200%;
	}
	
</style>

</head>
<body>
	<ol>
		<li>성명 : ${requestScope.paraMap.name}</li>
		<li>주소 : ${requestScope.paraMap.address}</li>
	</ol>
</body>
</html>