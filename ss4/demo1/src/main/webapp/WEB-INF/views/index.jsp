<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="/mailbox/showForm">Click here to edit mailbox settings</a><br><br>

<form>
    <label for="language">Language</label>
    <input id="language" readonly value="${currentMailbox.language}"><br><br>
    <label for="size">Size</label>
    <input id="size" readonly value="${currentMailbox.size}"><br><br>
    <label for="spamsFilter">Spams Filter</label>
    <input id="spamsFilter" readonly value="${currentMailbox.spamsFilter}"><br><br>
    <label for="signature">Signature</label>
    <input id="signature" readonly value="${currentMailbox.signature}"><br><br>
</form>

</body>
</html>