<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta name="renderer" content="webkit">
        <title>后台管理中心</title>
        <link rel="icon" href="../image/icon_logo_1.ico" type="images/x-ico" />
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/pintuer.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/admin.css">
        <script src="<%= request.getContextPath()%>/js/jquery.js"></script>
        <script src="<%= request.getContextPath()%>/js/pintuer.js"></script>
        <script src="<%= request.getContextPath()%>/js/admin.js"></script>
    </head>
    <body>
        <div class="header bg-black">
            <%@include file="/WEB-INF/jspf/admin_top.jspf" %> 
        </div>
        <div class="menu">
            <%@include file="/WEB-INF/jspf/admin_menu.jspf" %> 
        </div>
        <div class="admin">
            <div class="text-center text-main margin-big-bottom"><h2>修改用户记录</h2></div>
            <hr/>
            <form method="post" action="<%= request.getContextPath()%>/Admin/UserUpdateDo">
                <div class="form-group">
                    <div class="label">
                        <label for="name">用户名</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="name" name="name" size="50" placeholder="用户名" value="${user.name}" data-validate="required:必填"/>
                    </div>
                </div>    
                <div class="form-group">
                    <div class="label">
                        <label for="user_id">账号</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="user_id" name="user_id" size="50" placeholder="账号" value="${user.user_id}" readonly="readonly"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="password">密码</label>
                    </div>
                    <div class="field">
                        <input type="password" class="input" id="password" name="password" size="50" placeholder="密码"  data-validate="required:必填"/>
                    </div>
                </div>
                <div class="form-button">
                    <button class="button" type="submit">提交</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>