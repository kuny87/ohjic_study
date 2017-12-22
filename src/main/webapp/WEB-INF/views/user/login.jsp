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
	<div>
		<span>${user.name} 님</span>
		<button onclick="javascript:user_logout()">로그아웃</button><br/><br/><br/>
		<button onclick="javascript:board_list()">자유게시판</button>
	</div>
	
	<script>

		// 자유게시판
		function board_list() {
			location.href = "/test_ohjic/board_normal_list";
		}
		
		// 로그아웃
		function user_logout() {
			location.href = "/test_ohjic/user_logout";			
		}
	
	</script>
	
</body>
</html>
