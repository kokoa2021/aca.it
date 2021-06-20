<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Write</title>
	<meta charset="UTF-8">
</head>
<body>
	<div>
		<div>
			<h1>게시물 작성</h1>
			
			<form method="post">

				<label>제목</label>
				<input type="text" name="title" /><br />
				
				<label>비번</label>
				<input type="password" name="pwd" /><br />
				
				<label>내용</label>
				<textarea cols="50" rows="5" name="content"></textarea><br />
				
				<button type="submit">완료</button>
			
			</form>
		</div>	
	</div>
</body>
</html>