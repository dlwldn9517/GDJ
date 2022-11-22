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
	
	<div>
		<h1>업로드 게시판 정보</h1>
		<ul>
			<li>제목 : ${upload.title}</li>
			<li>내용 : ${upload.content}</li>
			<li>작성일 : ${upload.createDate}</li>
			<li>수정일 : ${upload.modifyDate}</li>
			<li></li>
		</ul>
	</div>

	<hr>
	
	<div>
		<h3>첨부목록</h3>
		<c:forEach items="${attachList}" var="attach">
			<div>
				<a href="">${attach.origin}</a>	<!-- origin : 원본이름 -->
			</div>
		
		</c:forEach>
	</div>

	
</body>
</html>