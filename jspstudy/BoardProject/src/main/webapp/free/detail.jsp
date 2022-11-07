<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function(){
		
		$('#btn_edit').click(function(event){
			location.href = '${contextPath}/free/modify.do?freeNo=${free.freeNo}';
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/free/list.do';
		});
		
	});
	
</script>
</head>
<body>
	
	<h1>자유게시판 게시글 상세보기화면</h1>
	
	<div>게시글번호 ${free.freeNo}</div>
	<div>작성자 ${free.writer}</div>
	<div>작성IP ${free.ip}</div>
	<div>조회수 ${free.hit}</div>
	<div>
		제목 <input type="text" id="title" name="title">${free.title}
		<textarea id="content" name="content" rows="5" cols="10">${free.content}</textarea>
	</div>
	<hr>
	<div>
		<input type="button" value="수정" id="btn_edit">
		<input type="button" value="목록" id="btn_list">
	</div>
	
	
</body>
</html>