<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title>${post.title}</title>
<c:set value="${pageContext.servletContext.contextPath }" var="contextPath"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${contextPath }/js/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script src="${contextPath }/js/jquery-1.11.3.min.js"></script>
<script src="${contextPath }/js/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
<div id="header">
<a href="/">
<h2>Seniror's Blog</h2>
</a>
</div>
<h2>${post.title }</h2>

${post.parsedHtmlContent}
</div>
<div id="footer" class="text-center">
&copy; 2016 Seniror (Yang Sheng)
</div>
</body>
</html>