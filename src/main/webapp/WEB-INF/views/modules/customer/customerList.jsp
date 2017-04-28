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
            var url = "iframe:${ctx}/sys/customer/edit/" + cid;
            top.$.jBox.open(url, "修改客户信息",700,350,{
                buttons:{"确定":"ok", "取消":true}, submit:function(v, h, f){
					if("ok" == v) {
                        top.$.jBox.tip("正在修改，请稍后...", 'Updating');
					    var contents = h.find("iframe").contents();
						var	id = contents.find("input[name='id']").val(),
                            delStatus = contents.find("input[name='delStatus']").val(),
                            name = contents.find("input[name='name']").val(),
                            phone = contents.find("input[name='phone']").val(),
                            address = contents.find("input[name='address']").val(),
                            alreadySettle = contents.find("input[name='alreadySettle']").val(),
                            nonDeposit = contents.find("input[name='nonDeposit']").val();
                        $.ajax({
                            url: '${ctx}/sys/customer/editCustomer',
                            type: 'post',
                            contentType : 'application/json',
                            data: JSON.stringify({"id": id,"name": name,"phone": phone,"address": address,"alreadySettle": alreadySettle,"nonDeposit": nonDeposit,"delStatus": delStatus}),
							success: function (data) {
								if(data == "true") {
                                    top.$.jBox.tip('修改成功', 'success');
                                    setTimeout(function () {
                                        window.location.reload();
                                    }, 2000);
                                } else {
                                    top.$.jBox.tip("修改失败！","error");
                                }
                            },
							error: function () {
                                top.$.jBox.tip("操作失败！","error");
                            }
						});
					} else {
						top.$.jBox.info("取消修改？","提示", submit);
					}
				}, loaded:function(h){
					$(".jbox-content", top.document).css("overflow-y","hidden");
				}
			});
		}

		function delCustomer(cid) {
		    var submit = function (v, h, f) {
                if("ok" == v) {
                    top.$.jBox.tip("正在删除，请稍后...", 'deleting');
                    var url = "${ctx}/sys/customer/delete/" + cid;
                    $.post(url, {}, function (data) {
                        if("true" == data) {
                            top.$.jBox.tip('删除成功', 'success');
                            setTimeout(function () {
                                window.location.reload();
                            }, 2000);
                        } else {
                            top.$.jBox.tip('删除失败', 'error');
                        }
                    })
                }
            };
			top.$.jBox.confirm("点击确定删除该客户信息", "操作", submit, {buttons: {'确定': "ok", "取消": true}});
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
		<thead>
			<tr><th>序号</th><th>姓名</th><th>手机</th><th>地址</th><th>已付款（元）</th><th>未付款（元）</th><th>操作</th></tr>
		</thead>
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
						<a onclick="delCustomer(${c.id})">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>