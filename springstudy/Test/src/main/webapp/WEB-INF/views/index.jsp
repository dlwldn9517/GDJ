<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(document).ready(function() {
		
		$('#btn_all').click(function() {
			location.href="${contextPath}/employee/";
		});
		
	});
</script>
</head>
<body>

	<div>
		<h1>사원등록</h1>
		
		<br>
		
		<form id="frm_reg" action="${contextPath}/emp/register">
			<input type="text" name="empNo" id="empNo" placeholder="사원번호">
			<input type="text" name="empName" id="empName" placeholder="사원명">
			<input type="text" name="depName" id="depName" placeholder="부서명">
			<button>등록</button>
		</form>
	</div>
	
	<hr>

	<div>
		<h1>사원조회</h1>
		
		<br>
		
		<form action="${contextPath}/emp/list">
			<input type="text" name="empNo" id="empNo" placeholder="사원번호">
			<button>조회</button>
			<input type="button" value="전체" id="btn_all">
		</form>
	</div>
	
	<hr>

	<div>
		<h1>사원목록</h1>
		
		<br>
		
		<div>
			<table border="1">
				<tbody>
					<tr>
						<td>사원번호</td>
						<td>사원명</td>
						<td>부서명</td>
						<td>연봉</td>
					</tr>
				</tbody>
			</table>
		</div>
		
	</div>
	
</body>
</html>