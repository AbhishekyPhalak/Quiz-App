<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #e9ecef">
<div class="container mt-5 p-4 bg-white shadow rounded">
    <h2 class="mb-5">User Management</h2>
    <table class="table table-striped">
        <thead class="table-dark">
        <tr>
            <th>User ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Status</th>
            <th>Admin?</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.firstname} ${user.lastname}</td>
                <td>${user.email}</td>
                <td>
                    <c:choose>
                        <c:when test="${user.active}">Active</c:when>
                        <c:otherwise>Suspended</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${user.admin}">Yes</c:when>
                        <c:otherwise>No</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${!user.admin}">
                        <div class="d-flex gap-2">
                            <form action="/admin/user/activate" method="post">
                                <input type="hidden" name="userId" value="${user.userId}" />
                                <button class="btn btn-outline-success btn-sm" type="submit">Activate</button>
                            </form>
                            <form action="/admin/user/suspend" method="post">
                                <input type="hidden" name="userId" value="${user.userId}" />
                                <button class="btn btn-outline-danger btn-sm" type="submit">Suspend</button>
                            </form>
                        </div>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
