
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<c:if test="${result.winner}">
    <sp:message code="label.win"></sp:message> <c:out value="${result.money}"></c:out><br>

</c:if>
<c:if test="${result.winner==false}">
    <sp:message code="label.loss"></sp:message> <c:out value="${result.money}"></c:out><br>
</c:if>
<a href="/race"><sp:message code="label.continue"></sp:message></a>
</body>
</html>
