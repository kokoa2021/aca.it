<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	KOKOA! 익명게시판
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>
	<a href="/board/board_list">게시물 목록</a>
	<a href="/board/write">게시물 작성</a>
</p>
</body>
</html>
