<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Us Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body style="background-color: #e9ecef">

<%@ include file="/WEB-INF/jsp/navbar.jsp" %>

<div class="container mt-4">
    <h2 class="mb-4">Contact Submissions</h2>
    <table class="table table-striped">
        <thead class="table-dark">
        <tr>
            <th>Subject</th>
            <th>Email Address</th>
            <th>Message Content</th>
            <th>Time Sent</th>
            <th>View</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contact" items="${contactData}">
            <tr>
                <td>${contact.subject}</td>
                <td>${contact.email}</td>
                <td>${contact.message}</td>
                <td>${contact.time}</td>
                <td>
                    <form action="/admin/view-contact-info" method="post">
                        <input type="hidden" name="subject" value="${contact.subject}" />
                        <input type="hidden" name="email" value="${contact.email}" />
                        <input type="hidden" name="message" value="${contact.message}" />
                        <input type="hidden" name="time" value="${contact.time}" />
                        <button type="submit" class="btn btn-sm btn-outline-primary">View Message</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



</body>
</html>
