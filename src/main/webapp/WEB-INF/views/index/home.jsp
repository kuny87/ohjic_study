<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>LOGIN</title>
</head>
<style>
	table {
		margin:auto;
		text-align: center;
	}
</style>
<body>
	<div style="margin-top: 100px;">
		<table>
			<thead>
				<tr>
					<th colspan="2"><h1>Login</h1></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>id</td>
					<td><input type="text" id="id" name="id" /></td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="password" id="pw" name="name"/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td class="center" colspan="2">
						<button onclick="javascript:login()">로그인</button>
						<button onclick="javascript:user_regist()">회원가입</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	
	<script>
		function list() {
			location.href = "/test_ohjic/board_normal_list";
		}
		
		function login() {
			
			var id = $('#id').val();
			var pw = $('#pw').val();
			
			$.ajax({
				dataType : 'json',
				url: "/test_ohjic/rest/user_login",
				method : 'GET',
				data : {
				   "id" : id,
				   "pw" : pw
				}
			}).done( function(result) {
				if (result.success) {
					location.href = "/test_ohjic/user_login?id=" + id;
				}else {
					alert(result.message);
				}
			}).fail(function(result) {
				alert("로그인 실패")
			});
		}
		
		function user_regist() {
			location.href = "/test_ohjic/user_regist";
		}
	
	</script>
	
</body>
</html>
