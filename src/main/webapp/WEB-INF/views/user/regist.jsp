<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>회원가입</title>
</head>
<body>
	<button onclick="javascript:login()">로그인하러 가기</button>
	
	<div>
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="id"/></td>	
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" id="pw" /></td>
			</tr>
			<tr>
				<td>패스워드 재확인</td>
				<td><input type="password" id="pwConfirm" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="userName" /></td>
			</tr>
		</table>
	</div>
	
	<button onclick="javascript:user_regist()">가입하기</button>
	
	<script>

		// 로그인 화면
		function login() {
			location.href = "/test_ohjic";
		}
		
		// 회원가입
		function user_regist() {
			
			var $id = $('#id');
			var $pw = $('#pw');
			var $pwConfirm = $('#pwConfirm');
			var $userName = $('#userName');
			var validateMessage = null;
			var validateFocus = null;

			// input 데이터 체크 및 팝업text 입력, 포커스 입력
			 if ($id.val() == "") {
				validateMessage = '아이디를 입력해 주세요.';
				validateFocus = id;
			} else if ($pw.val() == "") {
				validateMessage = '비밀번호를 입력해 주세요.';
				validateFocus = pw;
			} else if ($pw.val() != $pwConfirm.val()) {
				validateMessage = '비밀번호가 일치하지 않습니다.';
				validateFocus = pwConfirm;
			} else if ($userName.val() == "") {
				validateMessage = '이름을 입력해 주세요.';
				validateFocus = userName;
			}
			
			// input 데이터 체크 및 팝업창 띄워주고 포커스
			if(validateMessage != null) {
				validateFocus.focus();
				alert(validateMessage);
				return false;
			}
			
			$.ajax({
				dataType : 'json',
				url: "/test_ohjic/rest/user_regist",
				method : 'GET',
				data : {
				   "id" : $id.val(),
				   "pw" : $pw.val(),
				   "pwConfirm" : $pwConfirm.val(),
				   "name" : $userName.val()
				}			
			}).done( function(result) {
				if (result.success) {
					alert("가입완료")
					location.href = "/test_ohjic";
				}else {
					alert(result.message);
					$('#id').focus();
				}
			}).fail(function(result) {
				alert("가입실패")
			});
			
		}
	
	</script>
	
</body>
</html>
