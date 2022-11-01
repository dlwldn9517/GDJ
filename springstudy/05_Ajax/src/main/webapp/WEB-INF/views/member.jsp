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

	<form id="frm_member">
		<div>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id">
		</div>
		<div>
			<label for="pw">패스워드</label>
			<input type="password" name="pw" id="pw">
		</div>
		<div>
			<input type="button" value="전송1" id="btn1">
			<input type="button" value="전송2" id="btn2">
			<input type="button" value="전송3" id="btn3">
		</div>
	</form>
	
	<hr>
	
	<div id="result"></div>


</body>
</html>