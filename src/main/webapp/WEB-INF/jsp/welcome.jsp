<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title>Seniror's blog</title>
</head>
<body>
<p><a href="/admin/index">Login</a></p>
Hi, this is Yang Sheng from Shanghai, China. I built this site from scratch myself, I want to share something starting from here.

<h1>Welcome to Seniror's Blog</h1>
<p>Latest Posts
<c:forEach var="post" items="${posts}">
	<c:url value="/post/findPostById" var="postUrl">
	   <c:param name="id" value="${post.id}"/>
	</c:url>
	<p><a href="<c:out value="${postUrl}"/>"><c:out value="${post.title}"/></a>
</c:forEach>

</body>
</html>
