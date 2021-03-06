<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户名下订单列表</title>
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
			$("#placeOrderDate").val('');
            $("#deliveryGoodsDate").val('');
            $("#finishedStatus").val('true');
            return false;
        }

	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#"><span style="color: red;">${customer.name }&nbsp;</span>订单</a></li>
	</ul>
	<form:form id="searchForm" action="${ctx}/sys/order/forCustomer/${cid}" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<div>
			<label>下单时间：</label>
			<input id="placeOrderDate" name="placeOrderDate" type="text" readonly="readonly" maxlength="20" class="input-large Wdate"
				   value="<fmt:formatDate value="${order.placeOrderDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			<label>发货时间：</label>
			<input id="deliveryGoodsDate" name="deliveryGoodsDate" type="text" readonly="readonly" maxlength="20" class="input-large Wdate"
				   value="<fmt:formatDate value="${order.deliveryGoodsDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			<label>是否完成：</label>
			<select id="finishedStatus" name="finishedStatus">
				<option value="true">是&nbsp;&nbsp;&nbsp;</option>
				<option value="false">否&nbsp;&nbsp;&nbsp;</option>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			&nbsp;&nbsp;&nbsp;<input class="btn btn-primary" type="button" value="重置" onclick="resetForm();"/>
		</div>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>序号</th><th>下单时间</th><th>发货时间</th><th>总价</th><th>已付款（元）</th><th>未付款（元）</th><th>是否完成</th><th>操作</th></thead>
		<tbody>
			<c:forEach items="${page.list}" var="o" varStatus="st">
				<tr>
					<td>${st.index + 1}</td>
					<td>${o.placeOrderDate}</td>
					<td>${o.deliveryGoodsDate}</td>
					<td>${o.totalPrice}</td>
					<td style="color: #1ea84d;">${o.alreadySettle}</td>
					<c:if test="${o.finishedStatus == false}">
						<td style="color: #f00;">${o.nonDeposit}</td>
					</c:if>
					<c:if test="${o.finishedStatus == true}">
						<td>${o.nonDeposit}</td>
					</c:if>
					<td>
						<c:if test="${o.finishedStatus == true}">是</c:if>
						<c:if test="${o.finishedStatus == false}">否</c:if>
					</td>
					<td>
						<a href="${ctx}/sys/order/orderDetails/${o.id}">订单明细</a>&nbsp;&nbsp;
						<a>编辑</a>&nbsp;&nbsp;
						<a>删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>