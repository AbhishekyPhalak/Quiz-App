<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body style="background-color: #e9ecef">

<%@ include file="/WEB-INF/jsp/navbar.jsp" %>

<div class="container p-5 mt-5 rounded" style="max-width: 800px; background-color: white;">
    <h2 class="mb-4 text-center">Complete the Quiz</h2>

    <form method="post" action="/quiz">

        <input type="hidden" name="categoryId" value="${quizData[0].question.categoryId}" />
        <input type="hidden" name="timeStart" value="${quizStartTime}" />

        <c:forEach var="q" items="${quizData}" varStatus="loop">
            <div class="mb-4">
                <h5>Q${loop.index + 1}: ${q.question.description}</h5>
                <c:forEach var="choice" items="${q.choices}">
                    <div class="form-check">
                        <input class="form-check-input" type="radio"
                               name="${q.question.questionId}"
                               value="${choice.choiceId}"
                               id="choice_${choice.choiceId}" required />
                        <label class="form-check-label" for="choice_${choice.choiceId}">
                                ${choice.description}
                        </label>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>

        <button type="submit" class="btn btn-success w-100">Submit Quiz</button>
    </form>
</div>

</body>
</html>
