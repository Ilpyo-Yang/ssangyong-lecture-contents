<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두 개의 수를 입력받아 곱셈하기</title>
<script type="text/javascript">
	// Function Declaration
	function goSubmit(){
		// 정규표현식으로 유효성 검사
		var regExp = /^[0-9]{1,5}$/;
		var frm = document.myFrm;
		
		var num1 = frm.firstNum.value.trim();
		var num2 = frm.secondNum.value.trim();
		
		if(!(regExp.test(num1)&&regExp.test(num2))){
			alert("숫자로만 입력하세요!!");
			frm.firstNum.value="";
			frm.secondNum.value="";
			frm.firstNum.focus();
			return;	// 종료
		}
		
		frm.action = "01Mutiply_result_02.jsp";
	//	frm.method = "GET";	// method 를 명기하지 않으면 기본은 "GET" 이다.
		frm.submit(); 
		
	}// end of function goSubmint() ----------------------------------
</script>
</head>
<body>
   
   <form name="myFrm">
      <p>
	         첫번째 수 : <input type="text" name="firstNum" size="5" maxlength="5" /><br/>
	         두번째 수 : <input type="text" name="secondNum" size="5" maxlength="5" /><br/>
         <input type="button" onclick="goSubmit()" value="계산하기"/>
         <input type="reset" value="취소" />
      </p>
   </form>
</body>
</html>