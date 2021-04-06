<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* ★ 에러 있는데 왜 있는지 모름 */
	//컨텍스트 패스명(context path name)을 알아오고자 한다.
	String ctxPath = request.getContextPath();
	// ctxPath => /JSPServletBegin
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET 방식으로 데이터 전송하기</title>
<style type="text/css">
	ul{list-style: none;}
	li{line-height: 200%;}
</style>

<script type="text/javascript" src="<%= ctxPath %>/js/jquery-3.3.1.min.js" method="get">
<%--
	기본경로 src 는 해당 jquery 파일의 properties의 path이지만,
	<%= ctxPath %>/js/jquery-3.3.1.min.js 이런식으로 바꿔서 쓸 수 있음
--%>
</script>

<script type="text/javascript">
	$(function(){
		// 유효성 검사
		$("form[name=memberFrm]").submit(function(){
			
			// 1. 성명은 필수 입력
			var nameLength = $("input:text[name=name]").val().trim().length();
				// alert("확인용 nameLength => "+nameLength);
			if(nameLength==0){
				alert("성명을 입력하세요!!");
				$("input:text[name=name]").val("");
				$("input:text[name=name]").focus();
				return false; // 중요!! submit을 하지 않고 종료한다.
			}
			
			// 2. 학력은 필수 입력
			var schoolVal = $("select[name=school]").val();
				// alert("확인용 schoolVal => "+schoolVal);
			if(schoolVal==""){
				alert("학력을 입력하세요!!");
				$("select[name=school]").focus();
				return false; // 중요!! submit을 하지 않고 종료한다.
			}
			
			// 3. 색상은 필수 입력
			var colorLength = $("input:radio[name=color]").checked().length();
				// alert("확인용 colorLength => "+colorLength);
			if(colorLength==0){
				alert("색상을 선택하세요!!");
				return false; // 중요!! submit을 하지 않고 종료한다.
			}
			
			// 4. 음식은 필수 입력
			var foodLength = $("input:checkbox[name=food]").checked().length();
				// alert("확인용 foodLength => "+foodLength);
			if(foodLength==0){
				alert("음식을 최소 1개 이상 선택하세요!!");
				return false; // 중요!! submit을 하지 않고 종료한다.
			}
		});
		
	});
</script>
</head>

<body>
	<%-- <form action="/JSPServletBegin/01_getMethod.do"> 또는 --%>
	<form name="memeberFrm" action="<%= ctxPath%>/chap03_StandardAction/06_useBeanRegister.jsp" method="post">
		<fieldset>
	      <legend>개인성향 테스트</legend>
	      <ul>
	         <li>
	            <label for="name">성명</label>
	            <input type="text" name="name" placeholder="성명입력"/> 
	         </li>
	         <li>
	            <label for="school">학력</label>
	            <select name="school">
	               <option value="">선택하세요</option>
	               <option value="초대졸">초대졸</option>
	               <option value="대졸">대졸</option>
	               <option value="대학원졸">대학원졸</option>
	            </select>
	         </li>
	         <li>
	            <label for="">좋아하는 색상</label>
	            <div>
	               <label for="red">빨강</label>
	               <input type="radio" name="color" id="red" value="red" />
	               
	               <label for="blue">파랑</label>
	               <input type="radio" name="color" id="blue" value="blue" />
	               
	               <label for="green">초록</label>
	               <input type="radio" name="color" id="green" value="green" />
	               
	               <label for="yellow">노랑</label>
	               <input type="radio" name="color" id="yellow" value="yellow" />
	            </div>
	         </li>
	         <li>
	            <label for="">좋아하는 음식(다중선택)</label>
	            <div>
	                <label for="food1">짜짱면</label>
	               <input type="checkbox" name="food" id="food1" value="짜짱면" />
	               &nbsp;
	               
	               <label for="food2">짬뽕</label>
	               <input type="checkbox" name="food" id="food2" value="짬뽕" />
	               &nbsp;
	               
	               <label for="food3">탕수육</label>
	               <input type="checkbox" name="food" id="food3" value="탕수육" />
	               &nbsp;
	               
	               <label for="food4">양장피</label>
	               <input type="checkbox" name="food" id="food4" value="양장피" />
	               &nbsp;
	               
	               <label for="food5">팔보채</label>
	               <input type="checkbox" name="food" id="food5" value="팔보채" />
	            </div>
	         </li>
	         <li>
	            <input type="submit" value="전송" />
	            <%-- submit 은 이벤트가 click 이 아닌 $("form[name=memberFrm]").submit() 이렇게 해결 --%>
	            <input type="reset" value="취소" />
	         </li>
	      </ul>
	   </fieldset>
   </form>
</body>
</html>
