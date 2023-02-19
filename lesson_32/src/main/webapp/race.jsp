
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <title>Race</title>
</head>
<br>
<H3><sp:message code="label.FirstForm"></sp:message> </H3>
<form action="/race" method="post">
    <label style="float: inside" for="name"><sp:message code="label.RiderName"></sp:message></label><br>
    <input type="text"name="name" id="name"> ${err_name} <br>
    <label style="float: inside" for="nameHorse"><sp:message code="label.HorseName"></sp:message></label><br>
    <input type="text" name="nameHorse" id="nameHorse"> ${err_nameHorse}<br>

    <input type="submit">
</form>

<c:out value="${pairs}"/><br>

<H3> <sp:message code="label.SecondForm"></sp:message></H3>
<form action="/race/doBet" method="post">
    <label style="float: inside" for="bet"> <sp:message code="label.Bet"></sp:message></label><br>
    <input type =number min="1" name="bet" id="bet"><br>
    <label style="float: inside" for="numberOfPair"><sp:message code="label.NumberOfPair"></sp:message></label><br>
    <input type="number" min="1" name="numberOfPair" id="numberOfPair"> ${error} <br>
    <input type="submit">

</form>

${result}

</body>
</html>
