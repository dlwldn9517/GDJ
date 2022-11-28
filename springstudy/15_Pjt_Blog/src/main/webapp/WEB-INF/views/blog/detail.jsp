<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="../layout/header.jsp">
	<jsp:param value="${blog.blogNo}번 블로그" name="title"/>
</jsp:include>

<div>

	<h1>${blog.title}</h1>

	<div>
		<span>▷ 작성일 <fmt:formatDate value="${blog.createDate}" pattern="yyyy. M. d HH:mm" /></span>
		&nbsp;&nbsp;&nbsp;
		<span>▷ 수정일 <fmt:formatDate value="${blog.modifyDate}" pattern="yyyy. M. d HH:mm" /></span>
	</div>
	
	<div>
		<span>조회수 <fmt:formatNumber value="${blog.hit}" pattern="#,##0" /></span>
	</div>
	
	<hr>
	
	<div>
		${blog.content}
	</div>
	
	<div>
		<!-- 주소로 바로 이동하는 방식을 막기 위해 post 방식으로 넘기는 것 -->
		<form id="frm_btn" method="post">
			<!-- 블로그넘버를 넣어줘야 서브밋할 때 넘어감. hidden으로 숨겨놓고 수정/삭제할 때도 써먹자 -->
			<input type="hidden" name="blogNo" value="${blog.blogNo}">
			<!-- 수정/삭제 버튼은 작성자에게만 보이도록 -->
			<input type="button" value="수정" id="btn_edit_blog">
			<input type="button" value="삭제" id="btn_remove_blog">
			<input type="button" value="목록" onclick="location.href='${contextPath}/blog/list'">
		</form>

		<script>
		
			$('#btn_edit_blog').click(function() {
				$('#frm_btn').attr('action', '${contextPath}/blog/edit');
				$('#frm_btn').submit();
			});
		
			$('#btn_remove_blog').click(function() {
				if(confirm('블로그를 삭제하면 블로그에 달린 댓글을 더 이상 확인할 수 없습니다. 삭제하시겠습니까?')) {
					$('#frm_btn').attr('action', '${contextPath}/blog/remove');
					$('#frm_btn').submit();
				}
			});
		</script>
	</div>
	
	<hr>
	
	<!-- 댓글영역 -->
	<span id="btn_comment_list">
		댓글
		<span id="comment_count"></span>개
	</span>
	
	<hr>
	
	<!-- name="content", name="blogNo" 을 form 안에 넣은 이유 ? serialize()로 보내기 위해서 -->
	<div>
		<form id="frm_add_comment">
			<div class="add_comment">
				<div class="add_comment_input">
					<input type="text" name="content" id="content" placeholder="댓글을 작성하려면 로그인을 해주세요.">
				</div>
				<div class="add_comment_btn">
					<input type="button" value="작성완료" id="btn_add_comment">
				</div>
			</div>
			<input type="hidden" name="blogNo" value="${blog.blogNo}" >
		</form>
	</div>
	
	<script>
	
		fn_commentCount();
		fn_addComment();
	
		function fn_commentCount() {
			$.ajax({
				type: 'get',
				url: '${contextPath}/comment/getCount',
				data: 'blogNo=${blog.blogNo}',	// 글번호 달아줌
				dataType: 'json',
				success: function(resData){	// resData = {"commentCount" : 개수}
					$('#comment_count').text(resData.commentCount);
				}
			});
		}
		
		function fn_addComment() {
			$('#frm_add_comment').click(function() {
				if($('#comment').val() == '') {
					alert('댓글 내용을 입력하세요');
					return;	// ajax 실행 막음
				}
				$.ajax({
					type: 'post',
					url: '${contextPath}/comment/add',
					data:$('#frm_add_comment').serialize(),
					dataType: 'json',
					success: function(resData) {	// resData = {""}
						if(resData.isAdd) {
							alert('댓글이 등록되었습니다.');
							$('#content').val('');	//  입력되어 있는 댓글 초기화
							fn_commentList();	// 댓글 목록 가져와서 뿌리는 함수
						}
					}
				});
			});
		}
		
	</script>
	
	
	
	
	
	
	
	
	
</div>

</body>
</html>