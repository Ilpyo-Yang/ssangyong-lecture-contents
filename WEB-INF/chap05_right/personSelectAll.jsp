<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*, chap05.oracle.PersonDTO_02" %> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인성향 모든 정보 출력 페이지</title>

<style type="text/css">
	
	table, th, td {
		border: solid 1px gray;
	}
	
	table {
		border-collapse: collapse;
	}
	
	div {
		margin: 30px;
	}
	
	tbody > tr:hover {
		background-color: blue;
		color: white;
		cursor: pointer;
	}
	
	tbody > tr > td:nth-child(1) > span {	/* 크롬에서 F12해서 selector copy 를 해서 편집 */
		/* color: red; */
		display: none;
	}

</style>

<script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("tbody>tr").click(function(){
			// alert("호호");
			var $target = $(event.target);	// <td> 태그이다.
			// console.log("확인용 $target.html() => "+$target.html());
			var seq = $target.parent().find("span").text();
			console.log("확인용 seq => "+seq)
			location.href="personDetail.do?seq="+seq;
		});
	});
</script>
</head>
<body>
	<div>
		<h2>개인성향 모든 정보 출력 페이지(스크립틀릿을 사용하여 작성한 것)</h2>
<%
    List<PersonDTO_02> personList = (List<PersonDTO_02>) request.getAttribute("personList"); 
    
    if(personList.size() > 0) { %>
		<table>
		    <thead>
		    	<tr>
		    		<th>성명</th>
		    		<th>학력</th>
		    		<th>색상</th>
		    		<th>음식</th>
		    		<th>등록일자</th>
		    	</tr>
		    </thead>
		    
		    <tbody>
		    <%
		    	for(PersonDTO_02 psdto : personList) {
		    %>
		        <tr>
		        	<td><span><%= psdto.getSeq()%></span><%= psdto.getName() %></td>
		        	<td><%= psdto.getSchool() %></td>
		        	<td><%= psdto.getColor() %></td>
		        	<td><%= psdto.getStrFood() %></td>
		        	<td><%= psdto.getRegisterday() %></td>
		        </tr> 
		     <% } %>   
		    </tbody>
		</table>
<%  }
    else { %>
    	<span style="color: red;">데이터가 존재하지 않습니다</span>
<%  }
%>		
	</div>
	
	<hr style="border: solid 1px red;">
	
	<div>
		<h2>개인성향 모든 정보 출력 페이지(JSTL을 사용하여 작성한 것)</h2>
		
		<table>
		    <thead>
		    	<tr>
		    		<th>성명</th>
		    		<th>학력</th>
		    		<th>색상</th>
		    		<th>음식</th>
		    		<th>등록일자</th>
		    	</tr>
		    </thead>
		    
		    <tbody>
		    	<c:if test="${not empty requestScope.personList}">
		    		<c:forEach var="psdto" items="${requestScope.personList}"> 
		    			<tr>
		    				<td><span>${psdto.seq}</span>${psdto.name}</td>
		    				<td>${psdto.school}</td>
		    				<td>${psdto.color}</td>
		    				<td>${psdto.strFood}</td>
		    				<td>${psdto.registerday}</td>
		    			</tr>
		    		</c:forEach>
		    	</c:if>
		    	
		    	<c:if test="${empty requestScope.personList}">
		    		<span style="color: red;">데이터가 존재하지 않습니다</span>
		    	</c:if>
		    </tbody>
		</table>   
	</div>
	
	<div>
		<button onclick="javascript:location.href='personRegister.do'">개인성향 입력페이지</button>
	</div>
</body>
</html>