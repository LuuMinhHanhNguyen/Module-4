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
<form method="post" action="/condiment/save">
    <input type="checkbox" id="condiment1" name="condiment" value="lettuce">
    <label for="condiment1"> Lettuce</label><br>
    <input type="checkbox" id="condiment2" name="condiment" value="tomato">
    <label for="condiment2"> Tomato</label><br>
    <input type="checkbox" id="condiment3" name="condiment" value="mustard">
    <label for="condiment3"> Mustard</label><br>
    <input type="checkbox" id="condiment4" name="condiment" value="sprouts">
    <label for="condiment4"> Sprouts</label><br>
    <button style="margin-top: 1rem" type="submit">SAVE</button>
</form>

<h3 style="margin-top: 2rem">You chose: <span style="color: darkseagreen">${result}</span></h3>

</body>
</html>