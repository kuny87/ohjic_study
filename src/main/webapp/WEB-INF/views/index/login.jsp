<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:formatDate var="nowDate" value="${now}" pattern="yyyy-MM-dd" />

<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>사나 팬클럽 Login</title>
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
					<td>ID</td>
					<td><input type="text" id="id" name="id" /></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" id="pw" name="pw" onkeydown="onEnter();"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div style="text-align: center; margin-top: 20px;">
		<button onclick="javascript:login()">로그인</button>
		<button onclick="javascript:user_regist()">회원가입</button>
	</div>
	
	
	<script>
	
		function list() {
			location.href = "/test_ohjic/board_normal_list";
		}
	
		function login() {
			
			var $id = $('#id');
			var $pw = $('#pw');
			var validateMessage = null;
			var validateFocus = null;
			
			// input 데이터 체크 및 팝업text 입력, 포커스 입력
			if ($id.val() == "") {
				validateMessage = '아이디를 입력해 주세요.';
				validateFocus = id;
			} else if ($pw.val() == "") {
				validateMessage = '패스워드를 입력해 주세요.';
				validateFocus = pw;
			}
			
			// input 데이터 체크 및 팝업창 띄워주고 포커스
			if(validateMessage != null) {
				validateFocus.focus();
				alert(validateMessage);
				return false;
			}
			
			$.ajax({
				dataType : 'json',
				url: "/test_ohjic/rest/user_login",
				method : 'GET',
				data : {
				   "id" : $id.val(),
				   "pw" : $pw.val(),
				   "name" : "pass"
				}
			}).done( function(result) {
				if (result.success) {
					location.href = "/test_ohjic/main?id=" + $id.val();
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
		
		
		function onEnter(){
			var keyCode = window.event.keyCode;
			if(keyCode == 13) {
				login();
			}
		}
		
	</script>

</body>
</html>
