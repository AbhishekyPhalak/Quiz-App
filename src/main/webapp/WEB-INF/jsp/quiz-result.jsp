<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <title>Quiz Results</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body style="background-color: #f8f9fa">
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>

<div class="container mt-4">

    <c:set var="correctCount" value="0" />
    <c:forEach var="q" items="${quizResultsData.questionResults}">
        <c:if test="${q.userChoiceId == q.correctChoiceId}">
            <c:set var="correctCount" value="${correctCount + 1}" />
        </c:if>
    </c:forEach>

    <div class="bg-white shadow-sm p-4 mb-4 text-center rounded">
        <h3>
            ${quizResultsData.userFirstName} ${quizResultsData.userLastName} has
            <c:choose>
                <c:when test="${correctCount >= 2}">
                    <span class="text-success">Passed</span>
                </c:when>
                <c:otherwise>
                    <span class="text-danger">Failed</span>
                </c:otherwise>
            </c:choose>
            the ${quizResultsData.categoryName} Quiz: <strong>${quizResultsData.quizName}</strong>
        </h3>
    </div>

    <div class="d-flex flex-column gap-3 mb-3" style="width: 265px;">
        <div class="card bg-primary text-white">
            <div class="card-body">Start Time: ${quizResultsData.startTime}</div>
        </div>
        <div class="card bg-danger text-white">
            <div class="card-body">End Time: ${quizResultsData.endTime}</div>
        </div>
    </div>

    <div class="bg-white p-4 rounded shadow">
        <c:forEach var="q" items="${quizResultsData.questionResults}" varStatus="loop">
            <div class="mb-4">
                <h5>Q${loop.index + 1}: ${q.questionDesc}</h5>

                <ul class="list-group mb-3">
                    <c:forEach var="choice" items="${q.choices}">
                        <li class="list-group-item">${choice.description}</li>
                    </c:forEach>
                </ul>

                <div class="p-2 rounded mb-2
                    <c:choose>
                        <c:when test="${q.userChoiceId == q.correctChoiceId}">
                            bg-primary-subtle text-dark
                        </c:when>
                        <c:otherwise>
                            bg-danger-subtle text-dark
                        </c:otherwise>
                    </c:choose>">
                    Chosen Answer: ${q.userChoiceDesc}
                </div>

                <div class="p-2 rounded bg-success-subtle text-dark">
                    Correct Answer: ${q.correctChoiceDesc}
                </div>
                <hr/>
            </div>
        </c:forEach>
    </div>

    <div class="text-center mt-4 mb-4">
        <a href="/home" class="btn btn-primary">Take Another Quiz</a>
    </div>


</div>
</body>
</html>
