<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card-square {
            width: 200px;
            height: 200px;
            color: white;
            font-weight: bold;
            font-size: 1.2rem;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            text-decoration: none;
        }
        .card-square:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body style="background-color: #e9ecef">

<div class="container mt-5 p-4 bg-white shadow rounded">
    <div class="row justify-content-center g-4">
        <div class="col-md-3 d-flex justify-content-center">
            <a href="/admin/user-management" class="card card-square bg-primary">
                User Management
            </a>
        </div>
        <div class="col-md-3 d-flex justify-content-center">
            <a href="/admin/quiz-results" class="card card-square bg-primary">
                Quiz Result Management
            </a>
        </div>
        <div class="col-md-3 d-flex justify-content-center">
            <a href="/admin/contact-us-management" class="card card-square bg-primary">
                Contact Us Management
            </a>
        </div>
        <div class="col-md-3 d-flex justify-content-center">
            <a href="/admin/question-management" class="card card-square bg-primary">
                Question Management
            </a>
        </div>
    </div>
</div>

<div class="container mt-5 p-4 bg-light shadow rounded">
    <h2 class="text-center mb-5 text-primary fw-bold">Platform Statistics</h2>

    <div class="row text-center g-4">
        <div class="col-md-4">
            <div class="card border-0 shadow-sm h-100 bg-success text-white">
                <div class="card-body">
                    <h5 class="card-title">Total Users</h5>
                    <p class="display-6 fw-bold">${stats.count_of_users}</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card border-0 shadow-sm h-100 bg-danger text-white">
                <div class="card-body">
                    <h5 class="card-title">Total Quizzes</h5>
                    <p class="display-6 fw-bold">${stats.count_of_quiz}</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card border-0 shadow-sm h-100 bg-warning text-dark">
                <div class="card-body">
                    <h5 class="card-title">Top Quiz Category</h5>
                    <p class="display-6 fw-bold">${stats.most_popular_category}</p>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
