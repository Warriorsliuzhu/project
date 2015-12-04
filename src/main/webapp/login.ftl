

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <#include "common-css.ftl">
</head>
<body data-server-time="${.now?long?c}">
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span4 offset3" style="margin-top: 150px;">
            <form class="form-horizontal">
                <div class="control-group">
                    <label class="control-label">用户名</label>
                    <div class="controls">
                        <input type="text" id="user_name">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">密码</label>
                    <div class="controls">
                        <input type="password" id="password">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"></label>
                    <div class="controls">
                        <button type="submit" class="btn">登录</button>
                        <button type="button" id="forget" class="btn">忘记密码?</button>
                        <a href="register" class="btn">注册</a>
                    </div>
                </div>
        </div>
    </div>
</div>

</form>
</body>
<#include "common-js.ftl">
<script type="text/javascript">
    $(function(){

    });
</script>
</html>