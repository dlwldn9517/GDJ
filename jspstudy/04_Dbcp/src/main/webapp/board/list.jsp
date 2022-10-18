<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 전체 목록</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fontawesome-iconpicker/3.2.0/js/fontawesome-iconpicker.min.js" integrity="sha512-7dlzSK4Ulfm85ypS8/ya0xLf3NpXiML3s6HTLu4qDq7WiJWtLLyrXb9putdP3/1umwTmzIvhuu9EW7gHYSVtCQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>

	<h1>게시글 목록 보기</h1>	
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>제목</td>
					<td>작성일</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boards}" var="board">
					<tr>
						<td>${board.board_no}</td>
						<td>${board.title}</td>
						<td>${board.create_date}</td>
						<td>
							<a href=""><i class="fa-solid fa-x"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>