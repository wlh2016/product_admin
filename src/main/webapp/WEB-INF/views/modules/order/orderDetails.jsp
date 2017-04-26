<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>订单明细列表</title>
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
			$("#size").val('');
            $("#unitPrice").val('');
            return false;
        }

	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#"><span style="color: red;">${order.placeOrderDate }&nbsp;</span>订单明细</a></li>
	</ul>
	<form:form id="searchForm" action="${ctx}/sys/order/orderDetails/${oid}" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<div>
			<label>尺寸：</label><input id="size" name="size" type="text" maxlength="2" class="input-medium" value="${brush.size}"/>
			<label>单价：</label><input id="unitPrice" name="unitPrice" type="text" maxlength="4" class="input-medium" value="${brush.unitPrice}"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			&nbsp;&nbsp;&nbsp;<input class="btn btn-primary" type="button" value="重置" onclick="resetForm();"/>
		</div>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>序号</th><th>大小（寸）</th><th>单价（元）</th><th>单个包装数量（把）</th><th>包装数（个）</th><th>运费（元）</th><th>总计（元）</th><th>操作</th></thead>
		<tbody>
			<c:forEach items="${page.list}" var="b" varStatus="st">
				<tr>
					<td>${st.index + 1}</td>
					<td>${b.size}</td>
					<td>${b.unitPrice}</td>
					<td>${b.countOfPerPackage}</td>
					<td>${b.packageCount}</td>
					<td>${b.freight}</td>
					<td style="color: #1ea84d;">${b.totalPrice}</td>
					<td>
						<%--<a href="${ctx}/sys/order/orderDetails/${o.id}">订单明细</a>&nbsp;&nbsp;--%>
						<a>编辑</a>&nbsp;&nbsp;
						<a>删除</a>
					</td>
				</tr>
			</c:forEach>
				<tr>
					<td style="border-width: 0;"></td>
					<td style="border-width: 0;"></td>
					<td style="border-width: 0;"></td>
					<td style="border-width: 0;"></td>
					<td style="border-width: 0;"></td>
					<td style="border-width: 0;text-align: right;">合计：</td>
					<td style="border-width: 0;color: red;font-size: 16px;">${order.totalPrice}</td>
					<td style="border-width: 0;"></td>
				</tr>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>