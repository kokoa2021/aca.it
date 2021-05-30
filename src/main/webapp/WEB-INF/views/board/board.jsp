<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Board</title>
		<meta charset="UTF-8">
	</head>
	<body>
		<div>
			<table>
				<thead>
					<tr>
						<th> 번호 </th>
						<th> 제목 </th>
						<th> 내용 </th>
						<th> 작성일 </th>
						<th> 조회수 </th>						
					</tr>
				</thead>
				
					<c:forEach var="boardlist" items="${boardlist}">
					<tr>
						<td> ${boardlist.boardNo} </td>
						<td> ${boardlist.title} </td>
						<td> ${boardlist.content} </td>
						<th> ${boardlist.regDate} </th>
						<th> ${boardlist.hit} </th>
					</tr>
					</c:forEach>
			</table>
			
			
			
			<div class="pageInfo_wrap">
				<div class="pageInfo_area">
					<ul id="pageInfo" class="pageInfo">
						<!-- 이전페이지 버튼 -->
		                <c:if test="${pageMaker.prev}">
		                    <li class="pageInfo_btn previous"><a href="/acait/board?pageNum=${pageMaker.startPage-1}">Previous</a></li>
		                </c:if>
		                
		                <!-- 페이지 번호 버튼 -->
						<c:forEach var="num" begin="${pageMaker.startPage}" end ="${pageMaker.endPage}">
							<li class="pageInfo_btn"><a href="/acait/board?pageNum=${num}">${num}</a></li>
						</c:forEach>
		                
		                <!-- 다음페이지 버튼 -->
		                <c:if test="${pageMaker.next}">
		                    <li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
		                </c:if> 
					</ul>
				</div>
			</div>
			<form id="moveForm" method="get">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount}"> 
			</form>
			</div>
			
			<script>
			let moveForm = $("#moveForm");
			$(".pageInfo a").on("click", function(e){
				 
		        e.preventDefault();
		        moveForm.find("input[name='pageNum']").val($(this).attr("href"));
		        moveForm.attr("action", "/board/board");
		        moveForm.submit();
		        
		    });
			</script>
	</body>
</html>