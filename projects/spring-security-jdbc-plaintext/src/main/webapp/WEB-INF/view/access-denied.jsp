<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Access Denied</title>
</head>
<body>
    <h2>Access Denied -- You are not authorized to access this resource</h2>
    <hr>
    <a href="${pageContext.request.contextPath}/">Home Page</a>
</body>
</html>