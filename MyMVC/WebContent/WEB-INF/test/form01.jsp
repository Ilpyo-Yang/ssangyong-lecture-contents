<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test/form01.up 페이지</title>

<style type="text/css">

	ul {
		list-style-type: none;
	}
	
	li {
		line-height: 200%;
	}
	
	li > label {
		display: inline-block;
		width: 100px;
	}

</style>

</head>
<body>
	<form action="form01_result.up" method="post">
		<ul>
			<li>
			    <label>성명</label>
			    <input type="text" name="name" />
			</li>
			<li>
			    <label>주소</label>
			    <input type="text" name="address" />
			</li>
			<li>
				<input type="submit" value="전송" />&nbsp;
				<input type="reset" value="취소" />
			</li>
		</ul>
	</form>
</body>
</html>