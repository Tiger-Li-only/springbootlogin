<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>

<div class="container" style="min-height: 500px">
    <div class="starter-template">
        <h1>注册</h1>
        <div id="feedback"></div>
<form class="form-horizontal" id="search-form"  action="/user/add">
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label">用户名：</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="username" name="username" onkeyup="checkUsernameIsUsed()"/>
            <label col-sm-2 id="returnMsg"/>
        </div>
    </div>
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label">年龄：</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="age" name="age"/>
        </div>
    </div>
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label">密码：</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="password" name="password"/>
        </div>
    </div>
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label">确认密码：</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="cPassword"/>
        </div>
    </div>
    <input type="submit" value="注册" class="btn btn-primary">
    <input type="button" value="返回" class="btn btn-primary" onclick="backToLogin()">
</form>
    </div>
</div>

<script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    function backToLogin() {
        window.location.href = "/login";
    }
    
    function checkUsernameIsUsed() {
        var username = $("#username").val();
        if ($.trim(username) != ""){
            $.ajax({
                url:"/user/findUserByUsername",
                data:{"username":username},
                dataType:"text",
                success:function (data) {
                    var returnMsg = $.parseJSON(data);
                    if (returnMsg.msg == "ok"){
                        $("#returnMsg").html("该用户名可用");
                    }else if(returnMsg.msg == "found"){
                        $("#returnMsg").html("该用户名不可用");
                    }
                }
            })
        }else{
            $("#returnMsg").html("请输入用户名");
        }

        
    }

</script>
</body>
</html>