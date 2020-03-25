<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <div>
        <#if RequestParameters.error??>
            <div role="alert" >Wrong login name or password</div>
        </#if>
        <form method="post" action="/register">
            <label for="idUser">User name:</label>
            <input type="text" id="idUser" name="username" required autofocus/>
            <label for="idPassword">Password:</label>
            <input type="password" id="idPassword" name="password" required/>
            <button type="submit" >Register</button>
<#--            <input type="hidden"  name="${_csrf.parameterName}"  value="${_csrf.token}"/>-->
        </form>
    </div>
</body>
</html>