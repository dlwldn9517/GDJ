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
<script src="../js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function() {
		
		$('#frm_insert').submit(function(event) {
			alert('게시글이 등록되었습니다.');
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
		<form id="frm_insert" method="post" action="${contextPath}/free/insert.do">
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
				<textarea id="content" name="content" rows="2" cols="20" placeholder="내용"></textarea>
			</div>
			<div>
				<input type="submit" value="작성완료">
				<input type="reset" value="다시작성">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
</body>
</html>