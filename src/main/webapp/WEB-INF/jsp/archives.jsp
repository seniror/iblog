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
<div class="container" >
<div id="header">
<a href="/">
<h2>Seniror's Blog</h2>
</a>
</div>
<h2>All Posts</h2>
<c:forEach var="oneYearPosts" items="${postsGroupByKey}">
<h1>${oneYearPosts.key}</h1>
<hr/>
		<c:forEach var="post" items="${oneYearPosts.value}">
				<div>
				<a href="/post/${post.permLink }">
				<h4>${post.title}</h4>
				<small><fmt:formatDate pattern="yyyy-MM-dd" value="${post.createdTime}" /></small>	                         

				</a>
			</div>
		</c:forEach>
</c:forEach>



<br/>
<div id="footer" class="text-center">
&copy; Seniror (Yang Sheng)
</div>
<br/>
</div>
</body>
</html>
