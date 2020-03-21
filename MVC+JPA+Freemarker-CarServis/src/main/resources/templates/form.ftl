<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Form Data Binding and Validation</title>

    </head>
    <body>
        <h2>Form Data Binding and Validation</h2>

        <@spring.bind "user"/>
        <#if user?? && noErrors??>
            Your submitted data<br>
            First name: ${user.firstName}<br>
            Last name: ${user.lastName}<br>
            Email: ${user.email}<br>
        <#else>
            <form action="/user" method="post">
                First name:<br>
                <@spring.formInput "user.firstName"/>
                <@spring.showErrors "<br>"/>
                <br><br>
                Last name:<br>
                <@spring.formInput "user.lastName"/>
                <@spring.showErrors "<br>"/>
                <br><br>
                Email:<br>
                <@spring.formInput "user.email"/>
                <@spring.showErrors "<br>"/>
                <br><br>
                <input type="submit" value="Submit">
            </form>
        </#if>


    </body>
</html>