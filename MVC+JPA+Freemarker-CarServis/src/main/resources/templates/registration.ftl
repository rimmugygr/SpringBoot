<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<#--    <div>-->
<#--        <#if RequestParameters.error??>-->
<#--            <div role="alert" >Wrong login name or password</div>-->
<#--        </#if>-->
<#--        <form method="post" action="/registration">-->
<#--            <label for="idUser">User name:</label>-->
<#--            <input type="text" id="idUser" name="username" required autofocus/>-->
<#--            <label for="idPassword">Password:</label>-->
<#--            <input type="password" id="idPassword" name="password" required/>-->
<#--            <label for="idconfirmPassword">ConfirmPassword:</label>-->
<#--            <input type="password" id="idconfirmPassword" name="confirmPassword" required/>-->
<#--            <label for="idMail">Mail:</label>-->
<#--            <input type="text" id="idMail" name="mail" required/>-->
<#--            <button type="submit" >Register</button>-->
<#--            <input type="hidden"  name="${_csrf.parameterName}"  value="${_csrf.token}"/>-->
<#--        </form>-->
<#--    </div>-->
<@spring.bind "user"/>
<#if user?? && noErrors??>
    Your submitted data<br>
    Name: ${user.username}<br>
    Email: ${user.mail}<br>
<#else>
    <form action="/registration" method="post">
        Name:<br>
        <@spring.formInput "user.username"/>
        <@spring.showErrors "<br>"/>
        <br><br>
        Password:<br>
        <@spring.formInput "user.password"/>
        <@spring.showErrors "<br>"/>
        <br><br>
        Confirm Password:<br>
        <@spring.formInput "user.confirmPassword"/>
        <@spring.showErrors "<br>"/>
        <br><br>
        Email:<br>
        <@spring.formInput "user.mail"/>
        <@spring.showErrors "<br>"/>
        <br><br>
        <input type="submit" value="Submit">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</#if>


</body>
</html>
