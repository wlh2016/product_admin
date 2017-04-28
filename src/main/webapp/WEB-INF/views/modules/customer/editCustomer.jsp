<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>修改客户信息</title>
    <meta name="decorator" content="default"/>
    <style type="text/css">
        .redColor,.help-inline {color: red;}
        .controls {margin-left: 190px;}
    </style>
</head>
<body>
    <form:form action="" method="post">
        <input id="id" name="id" type="hidden" value="${c.id}"/>
        <input id="delStatus" name="delStatus" type="hidden" value="${c.delStatus}"/>
        <div class="controls" style="margin-top: 30px;">
            <span class="redColor">*</span>&nbsp;&nbsp;姓名：</label>&nbsp;&nbsp;&nbsp;
            <input id="name" name="name" type="text" htmlEscape="false" minlength="2" maxlength="20" class="required" value="${c.name}"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="help-inline" id="nameError"></span>
        </div>
        <div class="controls">
            <span class="redColor">*</span>&nbsp;&nbsp;手机：</label>&nbsp;&nbsp;&nbsp;
            <input id="phone" name="phone" type="text" htmlEscape="false" minlength="11" maxlength="11" class="m-wrap span3" value="${c.phone}"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="help-inline" id="phoneError"></span>
        </div>
        <div class="controls">
            <span class="redColor">*</span>&nbsp;&nbsp;地址：</label>&nbsp;&nbsp;&nbsp;
            <input id="address" name="address" type="text" htmlEscape="false" minlength="11" maxlength="11" class="m-wrap span3" value="${c.address}"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="help-inline" id="addressError"></span>
        </div>
        <div class="controls">
            <span class="redColor">*</span>&nbsp;&nbsp;已结款：</label>
            <input id="alreadySettle" name="alreadySettle" type="number" htmlEscape="false" class="m-wrap span3" value="${c.alreadySettle}" readonly="readonly"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="help-inline" id="alreadySettleError"></span>
        </div>
        <div class="controls">
            <span class="redColor">*</span>&nbsp;&nbsp;未结款：</label>
            <input id="nonDeposit" name="nonDeposit" type="number" htmlEscape="false" class="m-wrap span3" value="${c.nonDeposit}" readonly="readonly"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="help-inline" id="nonDepositError"></span>
        </div>
    </form:form>
</body>
</html>
