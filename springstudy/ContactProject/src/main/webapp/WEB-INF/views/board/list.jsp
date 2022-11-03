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
<script>

	$(document).ready(function() {
		
	});

</script>
</head>
<body>

	<div>
		<table border="1">
			<thead>
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>전화</td>
					<td>주소</td>
					<td>이메일</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="5">없음</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">
						<a href="${contextPath}/b/write">신규 연락처 등록하기</a>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>