<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta name="renderer" content="webkit">
        <title>后台管理中心</title>
        <link rel="icon" href="../image/icon_logo_1.ico" type="images/x-ico" class="radius-circle"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/pintuer.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/admin.css">
        <script src="<%= request.getContextPath()%>/js/jquery.js"></script>
        <script src="<%= request.getContextPath()%>/js/pintuer.js"></script>
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
                <div class="text-center text-main margin-big-bottom"><h2>显示所有订单记录</h2></div>
                <form method="post" action="<%= request.getContextPath()%>/Admin/OrderManage">
                    <div class="form-group">
                        <div class="field">
                            <div class="input-group">
                                <span class="addbtn">
                                    <button type="button" class="button icon-search"></button>
                                </span>
                                <input type="text" class="input float-left" name="order_id" size="30" placeholder="请输入要搜索订单编号" />
                                <span class="addbtn"><input type="submit" class="button" value="搜索"/></span>
                            </div>
                        </div>
                    </div>
                </form>
                <table class="table table-bordered">
                    <tr>
                        <td>订单编号</td><td>买家姓名</td><td>商品名称</td><td>单价</td><td>数量</td><td>总价</td><td>收货人</td><td>手机</td><td>收货地址</td><td>支付方式</td><td>订单状态</td>
                        <td>功能操作</td>
                    </tr>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.order_id}</td>
                            <td>${order.user.name}</td>
                            <td>${order.good.good_name}</td>
                            <td><fmt:formatNumber type="number" value="${order.good.price}" pattern="#.00"/></td>
                            <td>${order.amount}</td>
                            <td><fmt:formatNumber type="number" value="${order.good.price * order.amount}" pattern="#.00"/></td>
                            <td>${order.order_name}</td><td>${order.phone}</td><td>${order.address}</td><td>${order.pay}</td><td>${order.state}</td>
                            <td>
                                <a class="button button-small border-main" href="<%=request.getContextPath()%>/Admin/OrderUpdate?order_id=${order.order_id}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="text-center margin-big-top height-big">
                ${pagination.pageBar} &nbsp;&nbsp; ${pagination.numPageBar} &nbsp;&nbsp; 
            </div>
        </div>
    </div>
</body>
</html>
