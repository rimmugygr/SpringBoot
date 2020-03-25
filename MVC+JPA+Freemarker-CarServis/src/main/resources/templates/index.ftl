<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <p>Logged user: ${user!'none'} </p>
    <form method="post" action="/logout">
        <button type="submit" >Logout</button>
        <input type="hidden"  name="${_csrf.parameterName}"  value="${_csrf.token}"/>
    </form>
</body>
</html>