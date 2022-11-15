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
</head>
<body>

	<!-- 로그인이 안 된 상태 -->
	<c:if test="${loginUser == null}">
		<a href="${contextPath}/user/agree">회원가입페이지</a>	
	</c:if>

	<!-- 로그인이 된 상태 -->
	<c:if test="${loginUser != null}">
		<div>
			<a href="${contextPath}/user/mypage">${loginUser.name}</a> 님 반갑습니다.
		</div>
		<a href="${contextPath}/user/retire">회원탈퇴</a>		
	</c:if>

</body>
</html>