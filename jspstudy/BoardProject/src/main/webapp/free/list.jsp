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

	$(document).ready(function() {
		
		$('#btn_detail').click(function(event) {
			location.href = '${contextPath}/free/detail.do?freeNo=' + freeNo;
		});
		
		$('#btn_remove').click(function(event) {
			location.href = '${contextPath}/free/remove.do?freeNo=' + freeNo;
		});
		
	});

</script>
</head>
<body>

	<a href="${contextPath}/free/insert.do">작성하러 가기</a>
	
	<hr>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${free.freeNo}</td>
					<td>
						<input type="text" value="${free.title}" class="btn_detail">
					</td>
					<td>${free.writer}</td>
					<td>${free.hit}</td>
					<td>
						<input type="text" value="X" class="btn_remove">
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	
</body>
</html>