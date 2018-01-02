<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<jsp:include page="/WEB-INF/views/index/common.jsp" flush="false" />
	<title>사나 팬클럽</title>
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
		<button onclick="javascript:user_logout()">로그아웃</button>
		<button onclick="javascript:mypage()">마이페이지</button><br/><br/>
	</div>
	
	<div class="center">
		<h1>죽으나 <span style="color: pink;">사나</span> 영원히 <span style="color: pink;">사나</span></h1>
	</div>
	
	<div class="left" style="width: 45%; margin:auto; margin-bottom: 30px;">
		<button style="margin-right: 15px;" onclick="javascript:board_faq_list()">프로필</button>
		<button style="margin-right: 15px;" onclick="javascript:board_notice_list()">공지사항</button>
		<button onclick="javascript:board_normal_list()">자유게시판</button>
	</div>
	
	<div class="center">
		<img alt="sana" src="resources/images/sana.jpg" width="50%">
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
		
		// 마이페이지
		function mypage() {
			location.href = contextPath + '/user_mypage';
		}
	
	</script>
	
</body>
</html>
