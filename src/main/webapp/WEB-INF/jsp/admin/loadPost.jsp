<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<html lang="en">
<head>
<title>Update post</title>
<c:set value="${pageContext.servletContext.contextPath }" var="contextPath"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${contextPath }/js/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script src="${contextPath }/js/jquery-1.11.3.min.js"></script>
<script src="${contextPath }/js/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
<form action="/admin/updatePost" method="post">
Title:<input type="text" name="title" value="${post.title }">
Content:<input type="text" name="content" value="${post.content }">
<input type="hidden" name="postId" value="${post.id}"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="submit">
</form>
</div>
</body>
</html>