<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEW Member Update</title>
</head>
<body>
	<form action="/members/update" method="post">
	<input type="hidden" name="id" value="${id}">
        <div>
            <label for="email">Email</label>
            <input type="text" name="email" id="email" value="${member.email}">
        </div>
        <div>
            <label for="password">Password</label>
            <input type="text" name="password" id="password" value="${member.password}">
        </div>
        <input type="submit" value="inputContent">
        <a href="/members/${id}">Show Member</a>
    </form>
</body>
</html>