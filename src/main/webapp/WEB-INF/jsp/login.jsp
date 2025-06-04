<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>

<body style="background-color: #e9ecef">

<c:if test="${not empty error}">
    <div class="alert alert-danger">${error}</div>
</c:if>

<%@ include file="/WEB-INF/jsp/navbar.jsp" %>


<div class="container rounded p-5" style="max-width: 400px; background-color: white; margin-top: 120px">
    <h2 style="margin-bottom: 80px" class="text-center">Login</h2>
    <form action="/login" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter registered email" required />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required />
        </div>
        <button style="margin-top: 20px;" type="submit" class="btn btn-primary w-100">Login</button>
    </form>
</div>
</body>
</html>
