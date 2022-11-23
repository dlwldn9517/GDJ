<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Optional<String> opt = Optional.ofNullable(request.getParameter("title"));
	String title = opt.orElse("Welcome");
	pageContext.setAttribute("title", title);	// EL 사용을 위함 ( ${title} )
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div>
		
	</div>
	
</body>
</html>