<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登陆</title>
    <link rel="stylesheet" href="<%=basePath%>/resources/css/style.css">
    <script type="text/javascript" src="<%=basePath%>/resources/js/jquery-latest.js" charset="UTF-8"></script>
    <script type="text/javascript" src="<%=basePath%>/resources/js/jquery-3.0.0.min.js"></script>
    <style>
    </style>
</head>
<body>
<div class="top">
    <div class="logo_blue fl"><a href="#"></a></div>
</div>
<div class="login_con">
    <div class="login_box">
        <h1 class="login_title">欢迎登录</h1>
        <form action="<%=basePath%>/robot/login" method="post">
            <div class="input_user" >
                <input id="userName" name="user" value="" style="margin-top: 0px;height: 38px" >
            </div>
            <div class="input_password">
                <input type="password" id="password" name="password" value="" style="margin-top: 0px;height: 38px">
            </div>
            <!--
            <div class="formitem clearfix">
                <div class="fl">
                  <input type="checkbox" name="checkbox" class="checkbox" id="checkbox" onclick="login()"/>
                  <input type="hidden" id="rememberPassword" name="rememberPassword" value="0">
                    <label for="checkbox" class="checkbox" id="checkbox">记住密码</label>
                </div>
            </div>
            -->
            <div class="formitem">
                <input  class="input_login" type="submit" value="登录" />
            </div>

        </form>
    </div>
</div>
<div class="bottom"></div>
<input type="hidden" name="basePath" id="basePath" value="<%=basePath%>">
<script type="text/javascript" src="<%=basePath%>/resources/js/login.js"></script>
</body>
</html>