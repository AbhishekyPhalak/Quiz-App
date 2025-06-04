<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Question</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #e9ecef">

<div class="container my-5" style="max-width: 50%; background-color: white; box-shadow: 0 0 15px rgba(0,0,0,0.2); padding: 30px; border-radius: 8px;">
    <h2 class="text-primary fw-bold mb-4">Edit Question</h2>

    <form action="${pageContext.request.contextPath}/admin/question/update" method="post">

        <input type="hidden" name="questionId" value="${questionId}" />

        <div class="mb-3">
            <label for="description" class="form-label fw-semibold">Question Description</label>
            <input type="text" class="form-control" id="description" name="description" value="${description}" required />
        </div>

        <div class="mb-3">
            <label class="form-label fw-semibold">Choice 1</label>
            <input type="hidden" name="choiceId1" value="${choiceId1}" />
            <input type="text" class="form-control" name="choice1" value="${choice1}" required />
        </div>

        <div class="mb-3">
            <label class="form-label fw-semibold">Choice 2</label>
            <input type="hidden" name="choiceId2" value="${choiceId2}" />
            <input type="text" class="form-control" name="choice2" value="${choice2}" required />
        </div>

        <div class="mb-3">
            <label class="form-label fw-semibold">Choice 3</label>
            <input type="hidden" name="choiceId3" value="${choiceId3}" />
            <input type="text" class="form-control" name="choice3" value="${choice3}" required />
        </div>

        <div class="mb-3">
            <label for="correctChoice" class="form-label fw-semibold">Correct Answer</label>
            <select class="form-select" id="correctChoice" name="correctChoice" required>
                <option value="${choiceId1}" ${correctChoice == choiceId1 ? 'selected' : ''}>Choice 1</option>
                <option value="${choiceId2}" ${correctChoice == choiceId2 ? 'selected' : ''}>Choice 2</option>
                <option value="${choiceId3}" ${correctChoice == choiceId3 ? 'selected' : ''}>Choice 3</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary w-100">Update Question</button>
    </form>
</div>

</body>
</html>
