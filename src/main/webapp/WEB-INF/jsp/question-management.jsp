<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Question Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #e9ecef">
<div class="container mt-5 p-4 bg-white shadow rounded">
    <h2 class="mb-4">Question Management</h2>
    <table class="table table-striped align-middle">
        <thead class="table-dark">
        <tr>
            <th>Question Description</th>
            <th class="w-25">Choices</th>
            <th>Question Category</th>
            <th>Status</th>
            <th>Action</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="question" items="${questions}">
            <tr>
                <td>${question.description}</td>
                <td>
                    <ul class="mb-0 ps-3">
                        <c:forEach var="choice" items="${question.choices}">
                            <li>${choice.description}
                            </li>
                        </c:forEach>
                    </ul>
                </td>
                <td>${question.categoryName}</td>
                <td>
                    <c:choose>
                        <c:when test="${question.active}">
                            <span class="text-success fw-semibold">Active</span>
                        </c:when>
                        <c:otherwise>
                            <span class="text-danger fw-semibold">Suspended</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <form action="/admin/question/activate" method="post" class="mb-2">
                        <input type="hidden" name="questionId" value="${question.questionId}" />
                        <button type="submit" class="btn btn-outline-success btn-sm w-100">Activate</button>
                    </form>
                    <form action="/admin/question/suspend" method="post">
                        <input type="hidden" name="questionId" value="${question.questionId}" />
                        <button type="submit" class="btn btn-outline-danger btn-sm w-100">Suspend</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin/question/edit" method="get">
                        <input type="hidden" name="questionId" value="${question.questionId}" />
                        <input type="hidden" name="description" value="${question.description}" />
                        <input type="hidden" name="choice1" value="${question.choices[0].description}" />
                        <input type="hidden" name="choice2" value="${question.choices[1].description}" />
                        <input type="hidden" name="choice3" value="${question.choices[2].description}" />
                        <input type="hidden" name="choiceId1" value="${question.choices[0].choiceId}" />
                        <input type="hidden" name="choiceId2" value="${question.choices[1].choiceId}" />
                        <input type="hidden" name="choiceId3" value="${question.choices[2].choiceId}" />
                        <button type="submit" class="btn btn-outline-primary btn-sm w-100">Edit</button>
                    </form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

