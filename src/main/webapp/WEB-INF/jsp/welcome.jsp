<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
<title>Seniror's blog</title>
<c:set value="${pageContext.servletContext.contextPath }" var="contextPath"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- for mobile first design -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${contextPath }/js/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<!-- bootstrap has dependency on jquery -->
<script src="${contextPath }/js/jquery-1.11.3.min.js"></script>
<!-- bootstrap extension, for alert, confirm -->
<script src="${contextPath }/js/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
<div>
<h1>Welcome to Seniror's Blog</h1>

<p>Hi there, this is Yang Sheng from Shanghai, China. I built this site from scratch myself, I want to share something starting from here.
</p>

</div>
<h2>Latest Posts</h2>
<c:forEach var="post" items="${posts}">
	<div>
		<a href="/post/${post.permLink }" class="thumbnail">
		<h2>${post.title}</h2>
		<small><fmt:formatDate pattern="yyyy-MM-dd" value="${post.createdTime}" /></small>	  
		</a>
	</div>
</c:forEach>
<div id="archives" class="text-center">
<a href="/archives" role="button" class="btn btn-default">More articles</a>
</div>
<br/>
<div id="footer" class="text-center">
&copy; Seniror (Yang Sheng)
</div>
<br/>
</div>
</body>
</html>
