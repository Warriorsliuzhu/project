

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="assets/bootstrap/2.3.1/css/bootstrap.min.css"/>
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
<script type="text/javascript" src="assets/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="assets/bootstrap/2.3.1/js/bootstrap.min.js"></script>
<@page.script/>
<#-- script END -->
</body>
</html>