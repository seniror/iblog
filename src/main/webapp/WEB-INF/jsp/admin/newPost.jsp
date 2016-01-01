<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<html lang="en">
<head>
<c:set value="${pageContext.servletContext.contextPath }" var="contextPath"></c:set>
<title>New Post</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${contextPath }/js/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script src="${contextPath }/js/jquery-1.11.3.min.js"></script>
<script src="${contextPath }/js/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
<style>
      #markdownSource { 
		height: 430px;
		width: 100%;
          }
  </style>
<!-- ACE web browser editor -->  
<script src="${contextPath }/js/src-noconflict/ace.js"></script>
<script src="${contextPath }/js/src-noconflict/mode-markdown.js"></script>
<script src="${contextPath }/js/src-noconflict/theme-github.js"></script>
<script>
window.onload = function() {
	var editor = ace.edit("markdownSource");
	var textarea = $('textarea[name="markdownSource"]').hide();
	editor.getSession().setValue(textarea.val());
	editor.getSession().on('change', function(){
	  textarea.val(editor.getSession().getValue());
	});
};
</script>    
</head>

<body>

<div class="container">
<div id="header">
<a href="/">
<h2>Seniror's Blog</h2>
</a>
</div>

<form action="/admin/createPost" method="post" id="form1">
<p>Title:</p>
<input type="text" name="title" class="input-md" style="margin-bottom:5px;width:100%"/>
<textarea name="markdownSource"></textarea>
<div id="markdownSource"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="submit" class="btn btn-primary btn-block" style="width:100%;margin-top:5px"> 
</form>
</div>
</body>
</html>