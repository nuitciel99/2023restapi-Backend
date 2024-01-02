<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEW</title>
</head>
<body>
	<form action="/articles/update" method="post">
	<input type="hidden" name="id" value="${id}">
        <div>
            <label for="title">Title</label>
            <input type="text" name="title" id="title" value="${article.title}">
        </div>
        <div>
            <label for="content">Content</label>
            <input type="text" name="content" id="content" value="${article.content}">
        </div>
        <input type="submit" value="inputContent">
        <a href="/articles/${id}">Show Article</a>
    </form>
</body>
</html>