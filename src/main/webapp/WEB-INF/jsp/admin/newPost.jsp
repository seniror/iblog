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
      #ace-editor { 
		height: 430px;
		width: 80%;
          }
  </style>
<script src="${contextPath }/js/src-noconflict/ace.js"></script>
<script src="${contextPath }/js/src-noconflict/mode-markdown.js"></script>
<script src="${contextPath }/js/src-noconflict/theme-github.js"></script>
<script>
window.onload = function() {
    editor = ace.edit("ace-editor");
    editor.setTheme("ace/theme/github");
    editor.getSession().setMode("ace/mode/markdown");
};
function submit_form(){
    $("#hidden-editor").val(editor.getValue());
    return true;
};
</script>    
</head>

<body>
<div class="container">
<form action="/admin/createPost" method="post" id="form1" onsubmit="submit_form()">
Title:<input type="text" name="title">
<div id="ace-editor">${post.content }
</div>
<input type="hidden" name="content" id="hidden-editor"/>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="submit">
</form>
</div>
</body>
</html>