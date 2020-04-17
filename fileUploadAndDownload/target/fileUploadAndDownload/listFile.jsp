<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>可下载文件</title>
</head>
<body>
	<c:forEach var="me" items="${fileNameMap}" >
		<c:url value="/servlet/downloadServlet" var="downUrl" >
			<c:param name="fileName" value="${me.key}" ></c:param>
		</c:url>
		${me.value}<a href="${downUrl}" >下载</a>
		<br />
	</c:forEach>
</body>
</html>
