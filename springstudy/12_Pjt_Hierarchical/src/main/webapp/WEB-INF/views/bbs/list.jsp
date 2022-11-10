<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    @import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css');
</style>
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		if('${recordPerPage}' != '') {
			$('#recordPerPage').val(${recordPerPage});
		} else {
			$('#recordPerPage').val(10);			
		}
		
		
		$('#recordPerPage').change(function() {
			location.href = '${contextPath}/bbs/list?recordPerPage=' + $(this).val();
		});
		
	});
</script>
</head>
<body>

	<div>
		<a href="${contextPath}/bbs/write">작성하러가기</a>
	</div>

	<div>
		<select id="recordPerPage">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
		</select>
	</div>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td>작성자</td>
					<td>제목</td>
					<td>IP</td>
					<td>작성일</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<%-- <c:forEach>에서는 id를 여러개 생성하기 때문에 여러개 생성 가능한 class를 사용한다 --%>
				<%-- <form data-aaa="${bbs.bbsNo} > data-데이터이름 : 데이터이름은 아무거나 상관없다 --%>
				<%-- alert( $(this).parent().data('aaa') );    .data('데이터이름') : 데이터 값 가져오는 메소드 --%>
				<c:forEach var="bbs" items="${bbsList}" varStatus="vs">
					<c:if test="${bbs.state == 1}">
						<tr>
							<td>${beginNo - vs.index}</td>
							<td>${bbs.writer}</td>
							<td>${bbs.title}</td>
							<td>${bbs.ip}</td>
							<td>${bbs.createDate}</td>
							<td>
								<form method="post" action="${contextPath}/bbs/remove">
									<input type="hidden" name="bbsNo" value="${bbs.bbsNo}">
									<a class="lnk_remove" id="lnk_remove${bbs.bbsNo}"><i class="fa-solid fa-trash-can"></i></a>
								</form>
								<script>
									$('#lnk_remove${bbs.bbsNo}').click(function(){
										if(confirm('삭제할까요?')){
											$(this).parent().submit();
										}
									});
								</script>
							</td>
						</tr>
					</c:if>
					<c:if test="${bbs.state == 0}">
						<tr>
							<td>${beginNo - vs.index}</td>
							<td colspan="5">삭제된 게시글입니다</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">${paging}</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>