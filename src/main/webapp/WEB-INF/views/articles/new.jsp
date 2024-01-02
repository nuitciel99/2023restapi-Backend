<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Article</title>
</head>
<body>
	<form action="/articles/create" method="post">
        <div>
            <label for="title">Title</label>
            <input type="text" name="title" id="title">
        </div>
        <div>
            <label for="content">Content</label>
            <input type="text" name="content" id="content">
        </div>
        <input type="submit" value="inputContent">
        <a href="/articles">Show Article</a>
    </form>
</body>
</html>