<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Post</title>
</head>
<body>
<form action="/admin/createPost" method="post">
Title:<input type="text" name="title">
Content:<input type="text" name="content">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="submit">
</form>
</body>
</html>