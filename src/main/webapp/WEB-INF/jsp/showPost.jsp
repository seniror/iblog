<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<title>${post.title}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="js/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
${post.content}
</div>

</body>
</html>