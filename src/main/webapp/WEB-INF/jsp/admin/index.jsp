<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title>Admin Console</title>
<c:set value="${pageContext.servletContext.contextPath }" var="contextPath"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${contextPath }/js/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script src="${contextPath }/js/jquery-1.11.3.min.js"></script>
<script src="${contextPath }/js/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
Welcome back, Master.<a href="/logout">Log out</a>
<p><a href="/admin/newPost">New Post</a>
<p>All Posts
<c:forEach var="post" items="${posts}">
	<c:url value="/admin/loadPost" var="postUrl">
	   <c:param name="id" value="${post.id}"/>
	</c:url>
	<p><a href="<c:out value="${postUrl}"/>"><c:out value="${post.title}"/></a>
	<p><c:out value="${post.content }"/>
</c:forEach>
</div>
</body>
</html>