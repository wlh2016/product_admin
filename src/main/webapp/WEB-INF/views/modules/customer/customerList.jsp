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

	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/customer">客户列表</a></li>
	</ul>
	<form:form id="searchForm" action="${ctx}/sys/customer" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<div>
			<label>姓名：</label><input id="name" name="name" type="text" maxlength="20" class="input-mini" value="${customer.name}"/>
			<label>手机：</label><input id="phone" name="phone" type="text" maxlength="20" class="input-mini" value="${customer.phone}"/>
			<label>地址：</label><input id="address" name="address" type="text" maxlength="40" class="input-mini" value="${customer.address}"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			&nbsp;&nbsp;&nbsp;<input class="btn btn-primary" type="button" value="重置" onclick="resetForm();"/>
		</div>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>序号</th><th>姓名</th><th>手机</th><th>地址</th><th>已结款（RMB）</th><th>待结款（RMB）</th><th>操作</th></thead>
		<tbody>
			<c:forEach items="${page.list}" var="c" varStatus="st">
				<tr>
					<td>${st.index + 1}</td>
					<td><strong>${c.name}</strong></td>
					<td>${c.phone}</td>
					<td>${c.address}</td>
					<td>${c.alreadySettle}</td>
					<td>${c.nonDeposit}</td>
					<td>
						<a href="${ctx}/sys/order">订单明细</a>&nbsp;&nbsp;
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