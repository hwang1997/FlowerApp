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
            <div class="text-center text-main margin-big-bottom"><h2>修改商品记录</h2></div>
            <hr/>
            <form method="post" action="<%= request.getContextPath()%>/Admin/UpdateServlet" enctype="multipart/form-data">
                <div class="form-group">
                    <div class="label">
                        <label for="good_id">商品编号</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="good_id" name="good_id" size="50" placeholder="请输入商品编号" value="${good.good_id}" readonly="readonly" data-validate="required:必填"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="good_name">商品名称</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="good_name" name="good_name" size="50" placeholder="请输入商品名称" value="${good.good_name}" data-validate="required:必填"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="price">价格</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="price" name="price" size="50" placeholder="请输入商品价格" value="${good.price}" data-validate="required:必填"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="count">库存</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="count" name="count" size="50" placeholder="请输入商品库存数量" value="${good.count}" data-validate="required:必填"/>
                    </div>
                </div>
              <div class="form-group">
                    <div class="label">
                        <label for="des">花语</label>
                    </div>
                    <div class="field">
                        <textarea type="text" class="input" id="des" name="des" rows="5" cols="10" maxlength="50" placeholder="请输入该商品花语" data-validate="required:必填">${good.des}</textarea>
                    </div>
                </div>
                    <div class="form-group">
                    <img style="width:100px;height: 100px;margin-bottom: 20px" class="img-border border-green radius-circle" src="../upload/${good.pic}"/>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="pic">上传图片</label>
                    </div>
                    <div class="field">
                        <a class="button input-file" href="javascript:void(0);">+ 上传图片<input id="pic" name="pic" size="100" type="file" /></a>
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