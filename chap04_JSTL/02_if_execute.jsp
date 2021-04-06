<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두 개의 문자열을 입력받아서 같은지 다른지 검사하기</title>

<%-- 
	<script type="text/javascript" src="<%= request.getContextPath()%>/jquery-3.3.1.min.js"></script>
	또는
--%>
<script type="text/javascript" src="<%= ctxPath%>/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	$(function(){
		$("form[name=myform]").submit(function(){
			var firstVal = $("input:text[name=first]").val().trim();
			var secondVal = $("input:text[name=second]").val().trim();
			if(firstVal=="" || secondVal=="") {
				alert("문자를 입력하세요!!");
				return false; // submit을 하지 않는다.
			}
		});// end of $("form[name=myform]").submit(function() --------------
		
	});

</script>
</head>
<body>
   <form name="myFrm" action="02if_result.jsp">
      첫번째 입력란 : <input type="text" name="first" />
      두번째 입력란 : <input type="text" name="second" />
      세번째 입력란 : <input type="text" name="third" />
      <br>
      <input type="submit" value="확인" />
      <input type="reset" value="취소" /> 
   </form>
</body>
</html>