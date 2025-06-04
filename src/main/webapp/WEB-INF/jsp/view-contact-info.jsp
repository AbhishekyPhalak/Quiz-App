<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #e9ecef">
<div class="container mt-5 p-4 bg-white shadow rounded">
    <h2>Contact Information</h2>
    <p><strong>Subject:</strong> ${subject}</p>
    <p><strong>Email:</strong> ${email}</p>
    <p><strong>Message:</strong> ${message}</p>
    <p><strong>Time Sent:</strong> ${time}</p>
    <a href="/admin/contact-us-management" class="btn btn-secondary mt-3">Back</a>
</div>
</body>
</html>
