<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<tiles:insertAttribute name="css"/>
<tiles:insertAttribute name="script"/>
</head>
<body>
	<div class="root">
		<div id="header-container">
			<tiles:insertAttribute name="header"/>
		</div>
		<div id="body-container">
			<tiles:insertAttribute name="body"/>
		</div>
		<div id="footer-container">
			<tiles:insertAttribute name="footer"/>	
		</div>
	</div>
</body>
</html>