<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//컨텍스트 패스명(context path name)을 알아오고자 한다.
	String ctxPath = request.getContextPath();
	System.out.println("ctxPath => "+ctxPath);
	//ctxPath => /JSPServletBegin	<== WAS(톰캣서버) Document Base Path 설정의 기본값임.
	//ctxPath => /aaa	<== WAS(톰캣서버) Document Base Path 설정을  /aaa 으로 변경한 경우임.
	//ctxPath => 		(아무글자도 없는 것임) <== WAS(톰캣서버) Document Base Path 설정을  / 으로 변경한 경우임.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET/POST 방식으로 데이터 전송하기</title>
<style type="text/css">
	ul{list-style: none;}
	li{line-height: 200%;}
</style>
</head>
<body>
	<%-- <form action="/JSPServletBegin/03_getPostMethod.do"> 또는 --%>
	<form action="<%= ctxPath%>/03_getPostMethod.do" method="get">
	<%-- method 를 생략하면 기본이 get 이다. --%>
	<%-- !! 중요 !! 
		 확장자가 .jsp 또는 .html 인 파일에서 URL 경로를 나타낼때 맨 앞에 / 가 오면
		 그 앞에는 http://ip주소:포트번호 가 자동으로 붙게 된다.
		 <%= ctxPath %> 이 /JSPServletBegin 이다. ★ 절대경로
		 즉, 우리는 http://localhost:9090/JSPServletBegin/03_getPostMethod.do 으로 된다.
	--%>
	<%-- form 태그에서 submit(전송)을 하면 
		 http://localhost:9090/JSPServletBegin/03_getPostMethod.do 으로 데이터를 전송시킨다.
	 --%>
		<fieldset>
	      <legend>개인성향 테스트(GET/POST method)</legend>
	      <ul>
	         <li>
	            <label for="name">성명</label>
	            <input type="text" name="name" id="name" placeholder="성명입력"/> 
	         </li>
	         <li>
	            <label for="school">학력</label>
	            <select name="school" id="school">
	               <option value="고졸">고졸</option>
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
	            <input type="reset" value="취소" />
	         </li>
	      </ul>
	   </fieldset>
   </form>
</body>
</html>