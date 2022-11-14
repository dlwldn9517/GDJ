<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>

	$(function() {
		fn_idCheck();
	});
	
	// 1. 아이디 중복체크 & 정규식
	function fn_idCheck() {
		$('#id').keyup(function() {
			// 정규식
			
			
			// 중복체크
			$.ajax({
				
				/* 요청 */
				type: 'get',
				url: '${contextPath}/user/checkReduceId',
				data: 'id=' + $(this).val(),
				
				/* 응답 */
				dataType: 'json',
				success: function(resData) {	// resData = {"isUser" : true, "isRetireUser": false}
					if(resData.isUser || resData.isRetireUser) {
						$('#msg_id').text('이미 사용중이거나 탈퇴한 아이디입니다.');
					} else {
						$('#msg_id').text('사용 가능한 아이디입니다.')
					}
				}
			});
		});
	}

</script>
</head>
<body>

	<div>
		
		<h1>회원 가입</h1>
		
		<div>* 표시는 필수 입력사항입니다.</div>
		
		<hr>
		
		<form id="frm_join" action="${contextPath}/user/join" method="post">
		
			<!-- 약관 동의 여부 -->
			<input type="hidden" name="location" value="${location}">
			<input type="hidden" name="promotion" value="${promotion}">
			
			<!-- 아이디 -->
			<div>
				<label for="id">아이디*</label>
				<input type="text" name="id" id="id">
				<span id="msg_id"></span>
			</div>
			
		
		</form>
	</div>

</body>
</html>