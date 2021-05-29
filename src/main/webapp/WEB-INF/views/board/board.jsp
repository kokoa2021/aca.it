<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Board</title>
</head>
<body>
	<div>
		<div>

			<c:forEach var="boardlist" items="${boardlist}">
				${boardlist.title}
				${boardlist.content}
			</c:forEach>
		</div>	
	</div>
</body>
</html>