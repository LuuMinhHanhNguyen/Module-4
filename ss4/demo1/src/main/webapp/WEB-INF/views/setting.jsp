<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/mailbox/submitForm" method="post" modelAttribute="mailbox">
    <form:label path="language">Languages</form:label>
    <form:select path="language">
        <form:options items="${languages}" />
    </form:select><br><br>
    <form:label path="size">Page Size:</form:label>
    <form:select path="size"><br><br>
        <form:options items="${sizes}"/>
    </form:select><br><br>
    <form:label path="spamsFilter">Spams Filter</form:label>
    <form:checkbox path="spamsFilter"/>Enable filter spam<br><br>
    <form:label path="signature">Signature</form:label>
    <form:textarea path="signature"/><br><br>
    <button type="submit">Update</button>
    <button type="button">Cancel</button>
</form:form>
</body>
</html>
