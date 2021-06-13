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
				<label>번호</label>
				<input type="text" name="boardNo" value="${view.boardNo}" /><br />
				
				<label>제목</label>
				<input type="text" name="title" value="${view.title}" /><br />
				
				<label>조회수</label>
				<input type="text" name="hit" value="${view.hit}" /><br />
				
				<label>등록일</label>
				<input type="text" name="regDate" value="${view.regDate}" /><br />
				
				<label>내용</label>
				<textarea cols="50" rows="5" name="content">${view.content}</textarea><br />
			</form>
				<div>
				<a href="/acait/modify?boardNo=${view.boardNo}">게시물 수정</a>,
				<a href="/acait/delete?boardNo=${view.boardNo}">게시물 삭제</a>
				</div>
				<!--  댓글 시작 -->
				<hr />

				<ul>
				<!-- 
				    <li>
				        <div>
				            <p>첫번째 댓글 작성자</p>
				            <p>첫번째 댓글</p>
				        </div>
				    </li>
				    <li>
				        <div>
				            <p>두번째 댓글 작성자</p>
				            <p>두번째 댓글</p>
				        </div>
				    </li>
				    <li>
				        <div>
				            <p>세번째 댓글 작성자</p>
				            <p>세번째 댓글</p>
				        </div>
				    </li>
				     -->
				    <c:forEach items="${comment}" var="comment">
					<li>
					    <div>
					        <p>${comment.regDate}</p>
					        <p>${comment.content }</p>
					    </div>
					</li>    
					</c:forEach>
				</ul>
								
				<div>
				    <p>
				        <label>댓글 작성자</label> <input type="text">
				    </p>
				    <p>
				        <textarea rows="5" cols="50"></textarea>
				    </p>
				    <p>
				        <button type="button">댓글 작성</button>
				    </p>
				    
				</div>

				<!--  댓글 끝 -->
			
		</div>	
	</div>
</body>
</html>