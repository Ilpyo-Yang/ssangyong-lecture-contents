<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctxPath= request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test.form01 페이지</title>
</head>


<body>

	<form action="form01_insert.up" method="post">
		<table>
			<tr>
				<td>성명</td>
				<td><input type="text" id="name" name="name" /> </td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" id="address" name="address"/></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="전송"/>
				<input type="reset" value="취소"/>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>