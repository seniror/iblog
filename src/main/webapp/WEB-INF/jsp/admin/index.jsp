<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Admin Console</title>
<c:set value="${pageContext.servletContext.contextPath }" var="contextPath"></c:set>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${contextPath }/js/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script src="${contextPath }/js/jquery-1.11.3.min.js"></script>
<script src="${contextPath }/js/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
<script src="${contextPath }/js/bootbox.min.js"></script>
<script>


function deletePost(postId) {
	bootbox.confirm("Can you confirm delete post id = " + postId, function (confirmed) {
		if(confirmed) {
			window.location="/admin/deletePost?id="+postId;	
		}
	});
}
</script>
</head>

<body>
<div class="container">
	<div id="header">
	<a href="/">
	<h2>Seniror's Blog</h2>
	</a>
	</div>
	
	Welcome back, ${loginUsername } <a href="/logout">Log out</a>
	<h3><a href="/admin/newPost">New Post</a></h3>
	<h2 class="text-center">All Posts (Page ${paginationPosts.number + 1 } out of ${paginationPosts.totalPages })</h2>
	
	<c:forEach var="post" items="${paginationPosts.content}">
		<c:url value="/admin/loadPost" var="postUrl">
		   <c:param name="id" value="${post.id}"/>
		</c:url>
		<button type="button" class="btn btn-danger" onclick="deletePost(this.value)" value="${post.id }">Delete Post</button>
		<div>
		<a href="${postUrl}" class="thumbnail">
		<h2>${post.title}</h2>
		<span>${post.createdTime }</span>
		</a>
		</div>
	</c:forEach>
	<div class="text-right">
	<ul class="pagination">
		<c:forEach var="i" begin="0" end="${paginationPosts.totalPages - 1 }" step="1">
			<c:choose>
				<c:when test="${i == paginationPosts.number}">
					<li class="active"><a href="/admin/index?pageIndex=${i }">${i + 1 }</a></li>			
				</c:when>
				<c:otherwise>
					<li><a href="/admin/index?pageIndex=${i }">${i + 1 }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	</div>
</div>

</body>
</html>