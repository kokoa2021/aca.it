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
				
				<tbody>
					<c:forEach var="boardlist" items="${boardlist}">
					<tr>
						<td> ${boardlist.board_no} </td>
						<td> ${boardlist.title} </td>
						<td> ${boardlist.content} </td>
						<th> ${boardlist.reg_date} </th>
						<th> ${boardlist.hit} </th>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
	</div>
</body>
</html>