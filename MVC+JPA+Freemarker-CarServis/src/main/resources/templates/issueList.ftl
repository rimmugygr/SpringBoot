<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
-=No=Format=-
<table>
    <#list issues as issue>
        <tr>
            <td> ${issue.id} </td>
            <td> ${issue.title} </td>
            <td> ${issue.content} </td>
        </tr>
    </#list>
</table>

-=Format=With=Date=-
<table>
    <#list issues?reverse as issue>
        <tr>
            <td>${issue.id}</td>
            <td>${issue.title}</td>
            <td>${issue.content[0..*20]}<#if issue.content?length &gt; 20> ...</#if></td>
            <td>${issue.date?string["dd.MM.yy"]}</td>
        </tr>
    </#list>
</table>
</body>
</html>