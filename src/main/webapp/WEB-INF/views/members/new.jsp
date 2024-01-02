<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Member</title>
</head>
<body>
	<form action="/members/signup" method="post">
        <div>
            <label for="email">Email</label>
            <input type="text" name="email" id="email">
        </div>
        <div>
            <label for="password">Password</label>
            <input type="text" name="password" id="password">
        </div>
        <input type="submit" value="inputContent">
        <a href="/members">Show Members</a>
    </form>
</body>
</html>