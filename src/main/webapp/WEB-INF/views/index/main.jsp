<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<jsp:include page="/WEB-INF/views/index/common.jsp" flush="false" />
	<title>Main</title>
</head>
<style>
	table {
		margin:auto;
		text-align: center;
	}
</style>
<body>
	<div class="right" style="width: 80%">
		<span>${user.id} 님</span>
		<button onclick="javascript:user_logout()">로그아웃</button><br/><br/><br/>
	</div>
	
	<div>
		<table>
			<tr>
				<td>
					<button onclick="javascript:board_normal_list()">자유게시판</button>
				</td>
			</tr>
			<tr>
				<td>
					<button onclick="javascript:board_notice_list()">공지사항</button>
				</td>
			</tr>
			<tr>
				<td>
					<button onclick="javascript:board_faq_list()">자주하는 질문</button>
				</td>
			</tr>
		</table>
	</div>
	
	<script>

		// 자유 게시판
		function board_normal_list() {
			location.href = contextPath + "/board_normal_list";
		}
		
		// 공지사항 게시판
		function board_notice_list() {
			location.href = contextPath + "/board_notice_list";
		}
		
		// FAQ 게시판
		function board_faq_list() {
			location.href = contextPath + "/board_faq_list";
		}
		
		// 로그아웃
		function user_logout() {
			location.href = contextPath + "/user_logout";			
		}
	
	</script>
	
</body>
</html>
