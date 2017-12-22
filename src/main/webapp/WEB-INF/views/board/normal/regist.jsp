<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<jsp:include page="/WEB-INF/views/index/common.jsp" flush="false" />
	<title>글쓰기</title>
</head>
<style>
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
	<h1 class="center">글쓰기</h1>
</div>

<div>
	<table>
		<tbody>
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="content" name="content"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><span>${user.name}</span></td>
			</tr>
		</tbody>
	</table>
	
	<div class="center" style="margin-top: 50px;">
		<button onclick="javascript:regist()">보내기</button>
		<button onclick="javascript:list()">글목록</button>
	</div>
</div>

<script>

	function regist() {
		
		var title = $('#title').val();
		var content = $('#content').val();
		var name = '${user.name}';
		var regSeq = '${user.userSeq}';
		
		$.ajax({
			dataType : 'json',
			url: "/test_ohjic/rest/board_regist",
			method : 'GET',
			data : {
			   "type" : "NORMAL",
			   "title" : title,
			   "content" : content,
			   "name" : name,
			   "regSeq" : regSeq
			}			
		}).done( function(result) {
			if (result.success) {
				alert("등록완료")
				location.href = "/test_ohjic/board_normal_list";
			}
		}).fail(function(result) {
			alert("등록실패")
		});
		
	}
	
	function list() {
		location.href = "/test_ohjic/board_normal_list";
	}
	
</script>

</body>
</html>
