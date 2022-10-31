<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>

	<img src="${contextPath}/resources/images/hooray.jpg" width="200px">
	
	<hr>
	
	<h3>Member 관련 요청</h3>
	
	<div>
		<a href="${contextPath}/member/detail1?id=admin&pw=1234">전송</a>	<%-- 파라미터가 있으므로 GET 방식 --%>
	</div>
	
	<div>
		<input type="button" value="전송" id="btn">
	</div>
		<script>
		$('#btn').click(function() {
			location.href='${contextPath}/member/detail2?id=admin&pw=1234';	<%-- GET 방식이다. --%>
		});
	</script>
	
	<form action="" method="">
	
		<button></button>
	</form>

</body>
</html>