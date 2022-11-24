<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="../layout/header.jsp">
	<jsp:param value="블로그작성" name="title"/>
</jsp:include>

<script>
	
	// 4,5행에 있는거 없을 때 대신 사용할 수 있게
	// contextPath를 반환하는 자바스크립트 함수
	function getContextPath() {
		var begin = location.href.indexOf(location.origin) + location.origin.length;	// location.href에서 인덱스를 찾아라
		var end = location.href.indexOf("/", begin + 1);	// 어디서부터 찾아야하는지 지정
		return location.href.subString(begin, end);
	}
	
	$(document).ready(function(){
		
		// summernote
		$('#content').summernote({	// id="content"가 summernote로 바뀐다.
			width: 800,
			height: 400,
			lang: 'ko-KR',
			toolbar: [
			    // [groupName, [list of button]]
			    ['style', ['bold', 'italic', 'underline', 'clear']],
			    ['font', ['strikethrough', 'superscript', 'subscript']],
			    ['fontsize', ['fontsize']],
			    ['color', ['color']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']],
			    ['insert', ['link', 'picture', 'video']]
			]
		});
		
		// 목록
		$('#btn_list').click(function(){
			location.href = getContextPath() + '/blog/list';
		});
		
		// 서브밋
		$('#frm_write').submit(function(event){
			if($('#title').val() == ''){
				alert('제목은 필수입니다.');
				event.preventDefault();  // 서브밋 취소
				return;  // 더 이상 코드 실행할 필요 없음
			}
		});
		
	});
	
</script>

	<div>
	
		<h1>작성 화면</h1>
	
		<form id="frm_write" action="${contextPath}/blog/add" method="post">
	
			<div>
				<label for="title">제목</label>
				<input type="text" name="title" id="title">
			</div>
			
			<div>
				<label for="content">내용</label>
				<textarea name="content" id="content"></textarea>				
			</div>
			
			<div>
				<button>작성완료</button>
				<input type="reset" value="입력초기화">
				<input type="button" value="목록" id="btn_list">
			</div>
		
		</form>
		
		
	</div>

</body> <!-- footer가 없으니까 살려야 함 -->
</html>