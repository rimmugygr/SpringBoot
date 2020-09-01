<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form action="/file/upload" method="post" enctype="multipart/form-data">
    <input type="text" name="name"/>
    <input type="file" name="file"/>
    <input type="submit" value="Submit">
</form>
<#--<#if issueForm?? && noErrors??>-->
<#--Your upload file<br>-->
<#--Title: ${name}<br>-->
<#--Content: ${issueForm.content}<br>-->
<#--</#if>-->

</body>
</html>
