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

	$(function() {
		fn_list();
	});
	
	function fn_list() {
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData) {
				$.each(resData, function(i, staff) {
					
					/*
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					$('#stfList').append(tr);
					*/
					$('<tr>')
					.append( $('<td>').text(staff.sno) )
					.append( $('<td>').text(staff.name) )
					.append( $('<td>').text(staff.dept) )
					.append( $('<td>').text(staff.salary) )
					.appendTo('#stfList');
				});
			}
		});
		
	}

</script>
</head>
<body>

	<h3>사원목록</h3>
	<table border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>연봉</td>
			</tr>
		</thead>
		<tbody id="stfList">
			
		</tbody>
	</table>


</body>
</html>