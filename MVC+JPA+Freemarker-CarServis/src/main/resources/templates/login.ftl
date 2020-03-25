<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <div>
        <#if RequestParameters.error??>
            <div role="alert" >Wrong login name or password</div>
        </#if>
        <form method="post" action="/myLogin">
            <label for="idUser">User name:</label>
            <input type="text" id="idUser" name="name" required autofocus/>
            <label for="idPassword">Password:</label>
            <input type="password" id="idPassword" name="pass" required/>
            <button type="submit" >Login</button>
            <input type="hidden"  name="${_csrf.parameterName}"  value="${_csrf.token}"/>
        </form>
    </div>
</body>
</html>