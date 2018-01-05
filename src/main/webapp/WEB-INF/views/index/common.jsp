<%@page import="com.ohjic.test_ohjic.model.User"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<fmt:formatDate value="${now}" var="nowDate" pattern="yyyy-MM-dd HH:mm:ss" />

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="resourcesPath" value="${contextPath}/resources"/>
  
<style>
	.center {text-align: center;}
	.right {text-align: right;}
	.left {text-align: left;}
	.cp {cursor: pointer; color: blue;}
	.active {font-size: 22px;}
</style>

<script>

	var contextPath = '${contextPath}',
		resourcePath = '${resourcePath}';

	var userId = '${user.id}';
	if(userId == null || userId == ''){
		location.href = '/test_ohjic';
	}
</script>