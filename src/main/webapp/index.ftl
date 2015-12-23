<#assign title = "我的freemarker">

<#macro head>
<script type="text/javascript" src="assets/jquery/1.8.3/jquery.min.js"></script>
</#macro>

<#macro content>

<div class="container">
    <div class="row-fluid">
        <div class="span12">
            <h2>元智公司人数统计</h2>
        </div>
    </div>
    <div class="row-fluid" style="margin-top: 30px">
        <div class="span1">
            <span>进</span>
        </div>
        <div class="span10">
            <div class="progress progress-info">
                <div class="bar" style="width: ${count2}%"></div>
            </div>
        </div>
        <div class="span1">
            <span>${count2}人</span>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span1">
            <span>出</span>
        </div>
        <div class="span10">
            <div class="progress progress-success">
                <div class="bar" style="width: ${count1}%"></div>
            </div>
        </div>
        <div class="span1">
            <span>${count1}人</span>
        </div>
    </div>

    <div class="row-fluid">
        <div class="span1">
            <span>停留人数</span>
        </div>
        <div class="span10">
            <div class="progress progress-warning">
                <div class="bar" style="width: ${count2-count1}%"></div>
            </div>
        </div>

        <div class="span1">
            <span>${count2-count1}人</span>
        </div>
    </div>

</div>
${count1}
<br>
${count2}
<#---->
</#macro>

<#macro script>
<script type="text/javascript">
</script>
</#macro>
