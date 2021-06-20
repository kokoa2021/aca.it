<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404 Error Page</title>
</head>
<body>
	<c:if test="${requestScope['javax.servlet.error.status_code'] == 404}">
            <img src="${pageContext.request.contextPath}/resources/images/404error.png" style="height: 98vh" alt="404Error">
        <a href="/">
			<img src="${pageContext.request.contextPath}/resources/images/logo.png" width="70px" height="70px"  align="bottom" alt="404Error">
			<span class = "">메인으로</span>
		</a>
	</c:if>

</body>
</html>