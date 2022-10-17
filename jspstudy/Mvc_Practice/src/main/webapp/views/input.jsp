<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 너비/높이 입력 폼 : 사각형 버튼, 삼각형 버튼 --%>
	<div>
		<form action="${contextPath}/input.do">
			<div>
				<input type="text" name="width">
				*
				<input type="text" name="height">
				<button>사각형 넓이 확인</button>&nbsp;&nbsp;<button>삼각형 넓이 확인</button>
			</div>
		</form>
	</div>
	
	<%-- 반지름 입력 폼 : 원 버튼 --%>
	<div>
		<form action="${contextPath}/circle.do">
			<input type="text" name="radius">
			<button>원 넓이 확인</button>
		</form>
	</div>

</body>
</html>