<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>게시물 조회</title>
	<meta charset="UTF-8">
</head>
<body>
	<div>
		<div>
			<h1>게시물 상세</h1>
			
			<form method="post">

				<label>제목</label>
				<input type="text" name="title" value="${view.title}" /><br />
				
				<label>조회수</label>
				<input type="text" name="hit" value="${view.hit}" /><br />
				
				<label>등록일</label>
				<input type="text" name="regDate" value="${view.regDate}" /><br />
				
				<label>내용</label>
				<textarea cols="50" rows="5" name="content">${view.content}</textarea><br />
				

			
			</form>
		</div>	
	</div>
</body>
</html>