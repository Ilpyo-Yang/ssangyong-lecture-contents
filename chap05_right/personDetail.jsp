<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="color" value="${psdto.color}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>개별 회원의 성향 결과</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
	td {
		border: solid 1px gray;
	}
	/* table {
		margin-top: 50px;
		border-collapse: collapse;
		width: 750px;
	} */
	table {
		margin-top: 50px;
		border: none !important;
		width: 750px !important;
	}
	td {
		height: 40px;
	}
	td.title {
		font-weight: bold;
		padding-left: 10px;
	}
	td.content {
		padding-left: 20px;
	}
	span#colorbox {
		display:inline-block;
		/* border: solid 1px red; */
		width: 30px;
		height: 30px;
	}
	button {
		margin-right: 20px;
		margin-top: 100px;
	}
</style>
<script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("span#colorbox").css('background-color','${color}');
	});
	
	// Function Declaration
	function deletePerson(){
		var frm = document.delFrm;
		// console.log("확인용 삭제할 회원번호 seq => "+frm.seq.value);
		
		frm.action = "personDelete.do";
		frm.method = "post";
		frm.submit();
	}
	
	function updatePerson(seq){	
		var frm = document.updateFrm;
		// console.log("확인용 삭제할 회원번호 seq => "+frm.seq.value);
		
		frm.action = "personUpdate.do";
		frm.method = "POST";
		frm.submit();
	}
</script>
</head>

<body>
	<div class="container">
		<%-- servlet 에서 이미 null 처리함 --%>
		<h2><span style="color:blue;">${psdto.name}</span>&nbsp;님의 개인성향 결과</h2>
		<%-- <table>--%>
		<table class="table table-bordered"> 
			<tr>
				<td width="30%" class="title">회원번호</td>
				<td class="content">${psdto.seq}</td>
			</tr>
			<tr>
				<td class="title">성명</td>
				<td class="content">${psdto.name}</td>
			</tr>
			<tr>
				<td class="title">학력</td>
				<td class="content">${psdto.school}</td>
			</tr>
			<tr>
				<td class="title">색상</td>
				<td class="content">
					<c:choose>
						<c:when test="${color eq 'red'}"> 빨강 </c:when>
						<c:when test="${color eq 'blue'}"> 파랑 </c:when>
						<c:when test="${color eq 'green'}"> 초록 </c:when>
						<c:when test="${color eq 'yellow'}"> 노랑 </c:when>
						<c:otherwise>기타</c:otherwise>
					</c:choose>
					&nbsp;&nbsp;
					<span id="colorbox"></span>
				</td>
			</tr>
			<tr>
				<td class="title">음식</td>
				<td class="content">${psdto.strFood}</td>
			</tr>
			<tr>
				<td class="title">음식이미지파일명</td>
				<td class="content">
					${psdto.strFoodImgFileName}
				</td>
			</tr>
			<tr>
				<td class="title">음식사진</td>
				<td class="content">
					<c:if test="${not empty psdto.strFoodImgFileName}">
						<c:forTokens var="imgFileName" items="${psdto.strFoodImgFileName}" delims="," varStatus="status">
							<img src="<%= request.getContextPath() %>/chap05_images/${imgFileName}" width="153px" height="114px" />
							<c:if test="${status.count%3 eq 0}"></c:if>
						</c:forTokens>
					</c:if>
					<c:if test="${empty psdto.strFoodImgFileName}">좋아하는 음식이 없습니다.</c:if>				
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center; height: 100px; 
				                       border-left: none; border-right: none; border-bottom: none;">
					<button type="button" class="btn btn-success" onclick="javascript:location.href='personSelect.do'">목록보기</button>
					<button type="button" class="btn btn-danger" onclick="deletePerson()">삭제하기</button>
					<button type="button" class="btn btn-primary" onclick="updatePerson('${psdto.seq}')">내정보수정하기</button>
					<%-- 
						★ js 에서는 문자열의 경우에는 " " 나 ' ' 를 꼭 입력해야 한다. 없으면 undifined 이다.
						왠만하면 문자열로 하자! 다 호환되므로!!!!!
					--%>
					
					<%--DML GET 방식 사용하지 말고 POST 이용하기 --%>
				</td>
			</tr>
		</table>
	</div>
	
	<%-- POST 방식을 통해 회원을 삭제하기 위해서 화면에는 보이지 않는 form 태그를 만든다. --%>
	<form name="delFrm">
		<input type="hidden" name="seq" value="${psdto.seq}"/>
		<input type="hidden" name="name" value="${psdto.name}"/>	
	</form>
	<form name="updateFrm">
		<input type="hidden" name="seq" value="${psdto.seq}"/>
	</form>
	
</body>
</html>