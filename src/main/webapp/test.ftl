

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <#--<#include "common-css.ftl">-->
</head>
<body data-server-time="${.now?long?c}">


<#--<#include "common-js.ftl">-->
<script type="text/javascript" src="assets/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        window.location.href="login";
    });
</script>
</body>
</html>