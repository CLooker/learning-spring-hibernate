<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        First name: <form:input path="firstName" />
        <br>
        <br>
        Last name: <form:input path="lastName" />
        <br>
        <br>
        <form:select path="country">
            <form:options items="${student.countries}" />
        </form:select>
        <br>
        <br>
        Favorite Language:
        <br>
        <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguages}"  />
        <br>
        <br>
        Operating Systems:
        Linux <form:checkbox path="operatingSystems" value="Linux" />
        Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
        Microsoft Windows <form:checkbox path="operatingSystems" value="Microsoft Windows" />
        <br>
        <br>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>