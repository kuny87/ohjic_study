<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:forEach var="list" items="${list}">
	<li>${list.title}</li>
	<li>${list.content }</li>
	<li>${list.cnt }</li>
	<li>${list.name}</li>
</c:forEach>
</body>
</html>
