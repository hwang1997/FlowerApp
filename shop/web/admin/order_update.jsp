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
    </script>
    </head>
    <body>
        <div class="header bg-black">
            <%@include file="/WEB-INF/jspf/admin_top.jspf" %> 
        </div>
        <div class="menu">
            <%@include file="/WEB-INF/jspf/admin_menu.jspf" %> 
        </div>
        <div class="admin">
            <div class="text-center text-main margin-big-bottom"><h2>修改订单记录</h2></div>
            <hr/>
            <form method="post" action="<%= request.getContextPath()%>/Admin/OrderUpdateDo">
                <div class="form-group">
                    <div class="label">
                        <label for="order_id">商品编号</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="order_id" name="order_id" size="50" placeholder="请输入订单编号" value="${order.order_id}" readonly="readonly"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="order_good_name">商品名称</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="order_good_name" name="order_good_name" size="50" placeholder="请输入商品名称" value="${order.good.good_name}" readonly="readonly"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="order_name">收货人</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="order_name" name="order_name" size="50" placeholder="请输入收货人姓名" value="${order.order_name}" data-validate="required:必填"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="phone">联系电话</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="phone" name="phone" size="50" placeholder="请输入收货人联系电话" value="${order.phone}" data-validate="required:必填"/>
                    </div>
                </div>
              <div class="form-group">
                    <div class="label">
                        <label for="address">收货地址</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="address" name="address" maxlength="20" placeholder="请输入收货地址" value="${order.address}" data-validate="required:必填"></input>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="pay">支付方式</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="pay" name="pay" value="${order.pay}" readonly="readonly"></input>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="state">订单状态</label>
                    </div>
                    <div class="field">
                        <select name="state" class="input">
                            <option value="0">请选择订单状态</option>
                            <option value="处理中">处理中</option>
                            <option value="已发货">已发货</option>
                            <option value="已完成">已完成</option>
                            <option value="取消订单">取消订单</option>
                        </select>
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