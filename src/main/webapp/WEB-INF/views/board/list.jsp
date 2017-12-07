<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:formatDate value="${now}" var="nowDate" pattern="yyyy-MM-dd HH:mm:ss" />

<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<title>게시판</title>
</head>
<style>
	.center {text-align: center;}
	
	table, th, td {
		border: 1px solid black;
	}
	
	table {
		width:60%;
		height:200px;
		margin:auto;
		text-align: center;
	}
</style>
<body>

<div>
	<h1 class="center">게시판</h1>
</div>

<div>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td><a href="javascript:get(${list.seq})">${list.title }</a></td>
					<td>${list.name }</td>
					<td>${list.cnt }</td>
					<td>${list.regDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="center" style="margin-top: 50px;">
		<button onclick="regist()">글쓰기</button>
	</div>
</div>

<script>
	
	// 글쓰기
	function regist() {
		location.href = '/test_ohjic/board_regist';
	}
	
	// 글확인
	function get(seq) {
		location.href = '/test_ohjic/board_get?seq=' + seq;
	}
</script>

</body>
</html>
