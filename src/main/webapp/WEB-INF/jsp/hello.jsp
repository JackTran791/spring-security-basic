<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <title>Hello World</title>
</head>
<body>
    <h2 class="hello-title">Hello World!!!!! - congsonit@gmail.com</h2>

    <hr>

    <!-- Add a link to point to /leaders... this is for the managers -->
    <security:authorize access="hasRole('MANAGER')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
            (Only for Manager peeps)
        </p>
    </security:authorize>

    <!-- Add a link to point to /systems... this is for the admin -->
    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/systems">ADMIN Meeting</a>
            (Only for Manager peeps)
        </p>
    </security:authorize>

    <!-- Display user name and role -->
    <p>
        User: <security:authentication property="principal.username" />
        <br><br>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>

    <hr>

    <form:form action="${pageContext.request.contextPath}/logout"
               method="post">
        <input type="submit" value="Logout" />
    </form:form>
</body>
</html>
