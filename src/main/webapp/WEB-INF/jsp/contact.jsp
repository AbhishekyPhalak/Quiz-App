<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Us</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
            crossorigin="anonymous"></script>
</head>
<body style="background-color: #e9ecef">
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>

<div class="container rounded p-3" style="max-width: 600px; background-color: white; margin-top: 40px">
    <h2 class="text-center">Contact Us</h2>
    <div class="container rounded p-3" style="margin-top: 20px">
        <form action="/contact" method="post" class="mx-auto">
            <div class="mb-3">
                <label for="Subject" class="form-label">Subject</label>
                <input type="text" class="form-control" id="formSubject" name="subject" placeholder="Enter the subject">
            </div>
            <div class="mb-3">
                <label for="Email" class="form-label">Email</label>
                <input type="email" class="form-control" id="formEmail" name="email"
                       placeholder="Enter your registered email">
            </div>
            <div class="mb-3">
                <label for="formMessage" class="form-label">Message</label>
                <textarea class="form-control" id="formMessage" name="message" rows="5"
                          placeholder="Enter your message"></textarea>
            </div>
            <div class="d-flex justify-content-center" style="margin-top: 50px">
                <button type="submit" class="btn btn-primary w-50">Send</button>
            </div>
        </form>
    </div>

</div>
</body>
</html>