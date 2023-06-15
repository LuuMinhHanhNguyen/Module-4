<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/dictionary" method="post">
    <input type="text" name="word" placeholder="Enter a word to translate into Vietnamese:" step="0.01">
    <button type="submit">Look up</button>
</form>

<h3 style="margin-top: 3rem">Vietnamese: ${result}</h3>
</body>
</html>