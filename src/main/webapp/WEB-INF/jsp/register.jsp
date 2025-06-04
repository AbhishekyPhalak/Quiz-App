<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>

<body style="background-color: #e9ecef">

<c:if test="${not empty error}">
    <div class="alert alert-danger">${error}</div>
</c:if>

<%@ include file="/WEB-INF/jsp/navbar.jsp" %>


<div class="container rounded p-5" style="max-width: 400px; background-color: white; margin-top: 30px">
    <h2 style="margin-bottom: 40px" class="text-center">Register</h2>
    <form action="/register" method="post">
        <div class="mb-3">
            <label for="firstName" class="form-label">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter first name"
                   required/>
        </div>
        <div class="mb-3">
            <label for="lastName" class="form-label">Last Name</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter last name"
                   required/>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required/>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password"
                   required/>
        </div>
        <button style="margin-top: 20px;" type="submit" class="btn btn-primary w-100">Register</button>
    </form>
</div>
</body>
</html>
