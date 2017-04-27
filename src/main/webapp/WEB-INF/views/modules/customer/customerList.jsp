<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户列表</title>
	<meta name="decorator" content="default"/>
	<style type="text/css">
		a {cursor: pointer;}
	</style>

	<script type="text/javascript">

		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
	    	return false;
	    }

	    function resetForm() {
			$("#name").val('');
            $("#phone").val('');
            $("#address").val('');
            return false;
        }

		function editCustomer(cid) {
            top.$.jBox.open("iframe:${ctx}/sys/customer/edit/"+cid, "修改客户信息",700,350,{
                buttons:{"确定":"ok", "取消":true}, submit:function(v, h, f){
					if(v == "ok") {
					    top.$.jBox.tip("修改成功！","info");
					} else {
                        top.$.jBox.warning("取消修改？","提示", submit);
					}
                }, loaded:function(h){
                    $(".jbox-content", top.document).css("overflow-y","hidden");
                }
            });
        }

	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">客户列表</a></li>
	</ul>
	<form:form id="searchForm" action="${ctx}/sys/customer" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<div class="controls">
			<label>姓名：</label><input id="name" name="name" type="text" maxlength="20" class="input-medium" value="${customer.name}"/>
			<label>手机：</label><input id="phone" name="phone" type="text" maxlength="20" class="input-medium" value="${customer.phone}"/>
			<label>地址：</label><input id="address" name="address" type="text" maxlength="40" class="input-large" value="${customer.address}"/>
		</div>
		<div class="controls" style="margin-top: 10px;">
			&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" data-loading-text="Seraching..."/>
			&nbsp;&nbsp;&nbsp;<input class="btn btn-primary" type="button" value="重置" onclick="resetForm();"/>
		</div>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>序号</th><th>姓名</th><th>手机</th><th>地址</th><th>已付款（元）</th><th>未付款（元）</th><th>操作</th></thead>
		<tbody>
			<c:forEach items="${page.list}" var="c" varStatus="st">
				<tr>
					<td>${st.index + 1}</td>
					<td><strong>${c.name}</strong></td>
					<td>${c.phone}</td>
					<td>${c.address}</td>
					<td style="color: #1ea84d;">${c.alreadySettle}</td>
					<td style="color: red;">${c.nonDeposit}</td>
					<td>
						<a href="${ctx}/sys/order/forCustomer/${c.id}">订单列表</a>&nbsp;&nbsp;
						<a onclick="editCustomer(${c.id})">编辑</a>&nbsp;&nbsp;
						<a>删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>