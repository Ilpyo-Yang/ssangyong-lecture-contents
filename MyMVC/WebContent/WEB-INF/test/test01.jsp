<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String ctxPath = request.getContextPath();
	//		/MyMVC
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test/test01.up 페이지</title>
</head>
<body>
	<ol>
		<li>
			<label>성명</label><span>${paraMap.name}</span>
		</li>
		<li>		
			<label>사진</label><img src="<%= ctxPath %>/personimages/${paraMap.imgFilename}" />
		</li>
	</ol>
</body>
</html>