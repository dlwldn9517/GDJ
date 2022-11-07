<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function() {
		
		$('#btn_write').click(function(event) {
			location.href = '${contextPath}/free/list.do';
		});
		
		$('#btn_list').click(function(event) {
			location.href = '${contextPath}/free/list.do';
		});
		
	});
</script>
</head>
<body>
	
	<h1>자유게시판 게시글 작성화면</h1>
	<div>
		<label for="writer"></label>
		<input type="text" id="writer" name="writer" placeholder="작성자">
	</div>
	<div>
		<label for="title"></label>
		<input type="text" id="title" name="title" placeholder="제목">
	</div>
	<div>
		<label for="content"></label>
		<textarea id="content" name="content" rows="5" cols="10" placeholder="내용"></textarea>
	</div>
	<div>
		<input type="submit" value="작성완료" id="btn_write">
		<input type="reset" value="다시작성">
		<input type="button" value="목록" id="btn_list">
	</div>
</body>
</html>