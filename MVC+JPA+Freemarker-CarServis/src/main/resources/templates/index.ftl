<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<p>Logged user: ${user!'none'} </p>

<#list authorities as auth>
    <tr>
        <td> ${auth} </td>
    </tr>
</#list>

<form method="post" action="/logout">
    <button type="submit">Logout</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
