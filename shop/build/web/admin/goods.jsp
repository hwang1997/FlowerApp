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
                var tip = "确认是否删除当前商品记录？";
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
                <div class="text-center text-main margin-big-bottom"><h2>显示所有商品记录</h2></div>
                <form method="post" action="<%= request.getContextPath()%>/Admin/GoodsManage">
                    <div class="form-group">
                        <div class="field">
                            <div class="input-group">
                                <span class="addbtn">
                                    <button type="button" class="button icon-search"></button>
                                </span>
                                <input type="text" style="width:50%;" class="input float-left" name="good_id" size="30" placeholder="请输入要搜索商品编号" />
                                <input type="text" style="width:50%;" class="input float-left" name="good_name" size="30" placeholder="请输入要搜索商品名称" />
                                <span class="addbtn"><input type="submit" class="button" value="搜索"/></span>
                            </div>
                        </div>
                    </div>
                </form>
                <table class="table table-bordered">
                    <tr>
                        <td>商品编号</td><td>商品名称</td><td>价格</td><td>库存</td><td>花语</td><td>图片</td>
                        <td>功能操作</td>
                    </tr>
                    <c:forEach var="good" items="${goods}">
                        <tr>
                            <td>${good.good_id}</td><td>${good.good_name}</td><td>${good.price}</td><td>${good.count}</td><td style="text-align:left;padding-left: 20px;">${good.des}</td><td><img style="width:80px;height: 80px;" class="img-border border-green radius-circle" src="../upload/${good.pic}"/></td>
                            <td>
                                <a class="button button-small border-red" href="<%=request.getContextPath()%>/Admin/GoodsDelete?good_id=${good.good_id}" onclick="return confDel();">删除</a> | 
                                <a class="button button-small border-main" href="<%=request.getContextPath()%>/Admin/GoodsUpdate?good_id=${good.good_id}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="text-center margin-big-top height-big">
                ${pagination.pageBar} &nbsp;&nbsp; ${pagination.numPageBar} &nbsp;&nbsp; 
                <a class="button button-small border-main" href="<%=request.getContextPath()%>/admin/goods_add.jsp">添加产品记录</a>
            </div>
        </div>
    </div>
</body>
</html>
