<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test/form01_select.up 페이지</title>

<style type="text/css">
	
	table{
		border-collapse: collapse;
	}
	th,td{
		border : solid 1px gray;
	}

	th{
		background-color: #eee;
	}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>성명</th>
				<th>주소</th>
			</tr>
		
		</thead>
	
		<tbody>
			<c:forEach var="testvo" items="${requestScope.testVOList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${testvo.name}</td>
					<td>${testvo.address }</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>
</body>
</html>