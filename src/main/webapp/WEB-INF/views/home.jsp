<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Login</h1>
	
	<button onclick="list()">게시판</button>
	
	
	<script>

		function list() {
			location.href = "/test_ohjic/board_list";
		}
	
	</script>
	
</body>
</html>
