<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Console</title>
</head>
<body>
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
</body>
</html>