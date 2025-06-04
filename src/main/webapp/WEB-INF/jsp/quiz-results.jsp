<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>

<html>
<head>
    <title>Quiz Results</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container my-5">
    <h2 class="mb-4 text-primary">All Quiz Results</h2>

    <form action="${pageContext.request.contextPath}/admin/quiz-results" method="get" class="mb-4">
        <div class="row g-3 align-items-center">
            <div class="col-auto">
                <label for="category" class="col-form-label">Category:</label>
            </div>
            <div class="col-auto">
                <select name="category" id="category" class="form-select">
                    <option value="">All</option>
                    <option value="Math" ${param.category == 'Math' ? 'selected' : ''}>Math</option>
                    <option value="Physics" ${param.category == 'Physics' ? 'selected' : ''}>Physics</option>
                    <option value="Chemistry" ${param.category == 'Chemistry' ? 'selected' : ''}>Chemistry</option>
                </select>
            </div>
            <div class="col-auto">
                <label for="userId" class="col-form-label">User ID:</label>
            </div>
            <div class="col-auto">
                <input type="text" id="userId" name="userId" value="${param.userId}" class="form-control" placeholder="User ID" />
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary">Filter</button>
            </div>
        </div>
    </form>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>Start Time</th>
            <th>Category</th>
            <th>User</th>
            <th>Questions</th>
            <th>Score</th>
            <th>Result</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="result" items="${quizResults}">
            <tr>
                <td>
                    <fmt:formatDate value="${result.timeStart}" pattern="yyyy-MM-dd HH:mm:ss" />
                </td>
                <td>${result.categoryName}</td>
                <td>${result.userFullName}</td>
                <td>${result.totalQuestions}</td>
                <td>${result.score}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/quiz-results" method="post" style="margin:0;">
                        <input type="hidden" name="quizId" value="${result.quizId}" />
                        <input type="hidden" name="userId" value="${result.userId}" />
                        <button type="submit" class="btn btn-sm btn-outline-primary">Go to Result</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
