<#import "/spring.ftl" as spring/>
<#--<@spring.bind "issueForm"/>-->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<@spring.bind "issueForm"/>

<form action="/issue/add" method="post">
    Title:<br>
    <@spring.formInput "issueForm.title"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Content:<br>
    <@spring.formInput "issueForm.content"/>
    <@spring.showErrors "<br>"/>
    <br><br>

    <input type="submit" value="Submit">
</form>
<#if issueForm?? && noErrors??>
    Your submitted data<br>
    Title: ${issueForm.title}<br>
    Content: ${issueForm.content}<br>
</#if>

</body>
</html>
