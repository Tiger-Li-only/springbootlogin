<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>

<div class="container" style="min-height: 500px">
    <div class="starter-template">
        <h1>登录</h1>
        <div id="feedback"></div>
        <form class="form-horizontal" id="search-form" action="/userLogin">
            <div class="form-group form-group-lg">
                <label class="col-sm-2 control-label">用户名：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="username" name="username" value="${username!}"/>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-2 control-label">密码：</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="password" name="password"/>
                </div>
            </div>
                <input type="submit" value="登录" class="btn btn-primary">
                <input type="button" value="注册" class="btn btn-primary" onclick="toRegister()">
                 <h5 style="color: red">${resultMsg!}</h5>
        </form>
    </div>
</div>

<script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    function toRegister() {
       window.location.href = "/toRegister";
    }
    
</script>
</body>
</html>