<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//컨텍스트 패스명(context path name)을 알아오고자 한다.
	String ctxPath = request.getContextPath();
	// System.out.println("ctxPath => "+ctxPath);
%>

<%--
	view 단의 파일을 WEB-INF 안에 넣으면 직접적으로 볼 수가 없다.
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인성향 정보 수정하기~~</title>
<style type="text/css">
	div#container{
		/* border:solid 1px red; */
		width: 80%;
		margin: 50px auto;
	}
	fieldset {
		width: 50%;
	}
	ul{list-style: none;}
	li{line-height: 200%;}
</style>
<script type="text/javascript" src="<%= ctxPath%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

	$(function(){
		//alert("호호");
		
		// 1. 성명 등록하기
		$("input#name").val('${psdto.name}');	// ★ val 내에 따옴표 주의하기!! 꼭 써줘야 한다.
		
		// 2. 학력 입력해주기
		$("select#school").val('${psdto.school}');
		
		// 3. 색상 입력해주기
		var userChoiceColor = "${psdto.color}";
		// console.log("확인용 userChoiceColor => "+userChoiceColor);
		$("input:radio[name=color]").each(function(index, item){		
			// console.log("확인용 value => "+$(item).prop("value"));
			// 확인용 value => red
			// 확인용 value => blue
			// 확인용 value => green
			// 확인용 value => yellow
			
			if($(item).prop("value")==userChoiceColor) {
				$(item).prop("checked", true);
				return false;	// for 문의 break; 와 같은 뜻이다.
			}
		});
		
		
		// 4. 음식 입력해주기
		var userChoiceFood = "${psdto.strFood}";
		// console.log("확인용 userChoiceFood => "+userChoiceFood);
		// 확인용 userChoiceFood => 짜짱면,짬뽕,탕수육
		// 확인용 userChoiceFood => 없음
		
		if("없음"!=userChoiceFood){
			var arrFood = userChoiceFood.split(",");
			
			arrFood.forEach(function(food){
				$("input:checkbox[name=food]").each(function(index, item){		
					if($(item).prop("value")==food) {
						$(item).prop("checked", true);
					}
				});
			});
		}	
		
		
		// === 유효성 검사하기 === //
		$("form[name=myFrm]").submit(function(){
			var nameLength = $("input#name").val().trim().length();
			if(nameLength == 0) {
				alert("성명을 입력하세요!!");
				return false;	// submit 을 하지 않는다.
			}
			var schoolVal = $("select#school").val();
			if(schoolVal == "") {
				alert("학력을 선택하세요!!");
				return false;	// submit 을 하지 않는다.
			}
			var colorLength = $("input:radio[name=color]:checked").length();
			if(colorLength == 0) {
				alert("색상을 선택하세요!!");
				return false;	// submit 을 하지 않는다.
			}
			/* var foodLength = $("input:checkbox[name=food]:checked").length();
			if(foodLength == 0) {
				alert("음식을 선택하세요!!");
				return false;	// submit 을 하지 않는다.
			}*/ 
		});
	}); 
</script>
</head>
<body>
	<div id="container">
	<form name="myFrm" action="<%= ctxPath%>/personUpdateEnd.do" method="post">
		<fieldset>
	      <legend>${psdto.name} 님 성향 정보 수정하기</legend>
	      <ul>
	         <li>
	         	<input type="hidden" name="seq" value="${psdto.seq}"  readonly />
	            <label for="name">성명</label>
	            <input type="text" name="name" id="name" placeholder="성명입력"/> 
	         </li>
	         <li>
	            <label for="school">학력</label>
	            <select name="school" id="school">
	               <option value="">선택하세요</option>
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
	            <input type="submit" value="수정완료" />
	            <input type="reset" value="수정취소" />
	         </li>
	      </ul>
	   </fieldset>
   </form>
   </div>
</body>
</html>