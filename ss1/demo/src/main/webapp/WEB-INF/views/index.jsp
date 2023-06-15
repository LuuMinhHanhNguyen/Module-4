<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<form action="/exchange" method="post">
    <input type="number" name="rate" placeholder="Enter exchange rate:" step="0.01">
    <input type="number" name="amount" placeholder="Enter total amount here:">
    <button type="submit">Calculate</button>
</form>

<h3 style="margin-top: 3rem">VND = ${result}</h3>
</body>
</html>