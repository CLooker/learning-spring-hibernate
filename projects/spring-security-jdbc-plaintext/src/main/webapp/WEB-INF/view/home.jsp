<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Company Home Page</title>
</head>
<body>
    <h2>Company Home Page</h2>
    <hr>
    <p>Welcome to the Company Home Page</p>
    <hr>
    <p>
        User: <security:authentication property="principal.username" />
        <br><br>
        Role(s): <security:authentication property="principal.authorities" />
    </p>
    <hr>
    <security:authorize access="hasRole('MANAGER')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
        </p>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
        </p>
    </security:authorize>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="Submit" value="Logout" />
    </form:form>    
</body>
</html>