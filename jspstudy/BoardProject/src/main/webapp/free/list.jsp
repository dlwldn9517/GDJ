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
		
		$('#btn_list').click(function(event) {
			location.href = '${contextPath}/free/list.do';
		});
	
		
		$('#btn_add').click(function(event) {
			location.href = '${contextPath}/free/insert.do';
		});
		
		
		$('#btn_remove').click(function(event) {
			location.href = '${contextPath}/free/remove.do';
		});
		
	});

</script>
</head>
<body>

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
					<td>${free.title}</td>
					<td>${free.writer}</td>
					<td>${free.hit}</td>
					<td>
						<input type="button" value="X" class="btn_remove">
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	
</body>
</html>