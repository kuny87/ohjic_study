<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<title>Board</title>
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
	
	<input type="hidden" id="seq" name="seq" value="${board.seq}" />
	
	<table>
		<tbody>
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title" value="${board.title}" /></td>
				<td>조회수 : ${board.cnt}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="2"><input type="text" id="content" name="content" value="${board.content}" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td colspan="2">${board.name}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td colspan="2">${board.regDate}</td>
			</tr>
		</tbody>
	</table>
	
	<div class="center" style="margin-top: 50px;">
		<button onclick="modify()">글수정</button>
		<button onclick="list()">글목록</button>
	</div>
	
</div>

<script>
	
	// 글목록
	function list() {
		location.href = "/test_ohjic/board_list";
	}
	
	// 글수정
	function modify() {

		var seq = $('#seq').val();
		var title = $('#title').val();
		var content = $('#content').val();
		
		$.ajax({
			dataType : 'json',
			url: "/test_ohjic/rest/board_modify",
			method : 'GET',
			data : {
			   "seq" : seq,
			   "title" : title,
			   "content" : content
			}			
		}).done( function(result) {
			if (result.success) {
				alert("수정완료")
				location.href = "/test_ohjic/board_get?seq=" + seq;
			}
		}).fail(function(result) {
			alert("수정실패")
		});
		
	}
	
</script>
</body>
</html>
