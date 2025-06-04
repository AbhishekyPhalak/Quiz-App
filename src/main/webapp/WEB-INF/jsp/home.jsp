<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        .square-card {
            width: 200px;
            aspect-ratio: 1 / 1;
        }
        .card-hover {
            transition: all 0.3s ease;
            cursor: pointer;
        }

        .card-hover:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
        }
    </style>
</head>
<body style="background-color: #f8f9fa">
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>

<div style="margin-right: 10px" class="container mt-5">

    <h2 style="align-content: center; justify-content: center; margin-right: 130px; text-align: center" class="mb-4">Take a Quiz !!</h2>

    <div class="row text-white text-center g-4" style="margin-top: 20px">

        <div class="col-md-1">
        </div>

        <div class="col-md-3">
            <a href="/quiz?category=Math" style="text-decoration: none">
                <div class="card card-hover bg-warning square-card d-flex align-items-center justify-content-center">
                    <h4 style="color: white" class="card-title">Math</h4>
                </div>
            </a>
        </div>

        <div class="col-md-3">
            <a href="/quiz?category=Physics" style="text-decoration: none">
                <div class="card card-hover bg-danger square-card d-flex align-items-center justify-content-center">
                    <h4 style="color: white" class="card-title">Physics</h4>
                </div>
            </a>
        </div>

        <div class="col-md-3">
            <a href="/quiz?category=Chemistry" style="text-decoration: none">
                <div class="card card-hover bg-success square-card d-flex align-items-center justify-content-center">
                    <h4 style="color: white" class="card-title">Chemistry</h4>
                </div>
            </a>
        </div>

        <div class="col-md-1">
        </div>

    </div>

    <div style="padding-right: 100px" class="container mt-5">
        <h4 class="mb-3">Quiz History</h4>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
            <tr>
                <th>User First Name</th>
                <th>User Last Name</th>
                <th>Quiz Taken At</th>
                <th>Quiz Results</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${quiz_history}">
                <tr>
                    <td>${item.firstName}</td>
                    <td>${item.lastName}</td>
                    <td>${item.takenAt}</td>
                    <td>
                        <form method="post" action="/quiz-results">
                            <input type="hidden" name="quizId" value="${item.quizId}" />
                            <button type="submit" class="btn btn-primary btn-sm">Go to Results</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
