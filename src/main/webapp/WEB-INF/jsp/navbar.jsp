<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${not empty sessionScope.userId}">
        <c:choose>
            <c:when test="${sessionScope.isAdmin == true}">
                <jsp:include page="/WEB-INF/jsp/adminNavbar.jsp" />
            </c:when>
            <c:otherwise>
                <jsp:include page="/WEB-INF/jsp/loggedInNavbar.jsp" />
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>
        <jsp:include page="/WEB-INF/jsp/loggedOutNavbar.jsp" />
    </c:otherwise>
</c:choose>
