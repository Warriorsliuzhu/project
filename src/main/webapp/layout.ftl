

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
<#-- import page START -->
<#-- 引入内容页面 -->
<#import _pagePath as page>
<#-- import page END -->

    <title>${page.title}</title>
<#-- head START -->
<@page.head/>
<#-- head END -->
</head>
<body data-server-time="${.now?long?c}">


<#-- content START -->
                        <@page.content/>
                        <#-- content END -->

<#-- script START -->
<@page.script/>
<#-- script END -->
</body>
</html>