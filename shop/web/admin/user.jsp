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

        <script src="<%= request.getContextPath()%>/js/admin.js"></script>
        <script type="text/javascript">
            function confDel() {
                var tip = "确认是否删除当前用户信息记录？";
                if (confirm(tip)) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>

        <style>
            .table td{vertical-align: middle;text-align: center}
        </style>
    </head>
    <body>
        <div class="header bg-black">
            <%@include file="/WEB-INF/jspf/admin_top.jspf" %> 
        </div>
        <div class="menu">
            <%@include file="/WEB-INF/jspf/admin_menu.jspf" %> 
        </div>
        <div class="admin">
            <div class="table-responsive">
                <div class="text-center text-main margin-big-bottom"><h2>显示所有用户记录</h2></div>
                <form method="post" action="<%= request.getContextPath()%>/Admin/UserManage">
                    <div class="form-group">
                        <div class="field">
                            <div class="input-group">
                                <span class="addbtn">
                                    <button type="button" class="button icon-search"></button>
                                </span>
                                <input type="text" class="input" name="userid" size="30" placeholder="请输入要搜索用户账号" />
                                <span class="addbtn"><input type="submit" class="button" value="搜索"/></span>
                            </div>
                        </div>
                    </div>
                </form>
                <table class="table table-bordered">
                    <tr>
                        <td>账号</td><td>密码</td><td>用户名</td>
                        <td>功能操作</td>
                    </tr>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.user_id}</td><td>${user.password}</td><td>${user.name}</td>
                            <td>
                                <a class="button button-small border-red" href="<%=request.getContextPath()%>/Admin/UserDelete?user_id=${user.user_id}" onclick="return confDel();">删除</a> | 
                                <a class="button button-small border-main" href="<%=request.getContextPath()%>/Admin/UserUpdate?user_id=${user.user_id}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="text-center margin-big-top height-big">
                <a class="button button-small border-main" href="<%=request.getContextPath()%>/admin/user_add.jsp">添加用户记录</a>
            </div>
        </div>
    </div>
</body>
</html>
