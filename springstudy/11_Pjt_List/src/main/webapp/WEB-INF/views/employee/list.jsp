<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	.paginate {
		position: relative;
		min-height: 22px;
		margin-top: 17px;
		text-align: center;
	}
	
	.paginate a:hover, .paginate strong.page {
		border: 1px solid #e0e0e0;
		color: #00c73c;
	}
	
	.paginate a, .paginate strong.page, .low_btn {
	    position: relative;
	    min-width: 20px;
	    height: 20px;
	    margin: -1px 1px;
	    padding: 2px 2px 0;
	    border: 1px solid #fff;
	    font-family: tahoma,helvetica,sans-serif;
	    color: #999;
	    line-height: normal;
	    text-decoration: none;
	    vertical-align: top;
	    letter-spacing: -1px;
	}
	
	
	.blind {
   		border: 1px solid #e0e0e0 !important;
    	color: #00c73c !important;
	}
	
</style>
</head>
<body>

	<div>
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td>사원번호</td>
					<td>사원명</td>
					<td>이메일</td>
					<td>전화번호</td>
					<td>입사일자</td>
					<td>연봉</td>
					<td>커미션</td>
					<td>부서번호</td>
					<td>부서명</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp">
					<tr>
						<td>순번자리</td>
						<td>${emp.employeeId}</td>
						<td>${emp.firstName} ${emp.lastName}</td>
						<td>${emp.email}</td>
						<td>${emp.phoneNumber}</td>
						<td>${emp.hireDate}</td>
						<td>${emp.salary}</td>
						<td>${emp.commissionPct}</td>
						<td>${emp.deptDTO.departmentId}</td>
						<td>${emp.deptDTO.departmentName}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="10" class="paginate">
						${paging}
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>