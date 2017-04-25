package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Order;

/**
 * @author Tony_Wu
 * @date 2017-4-25
 */
@MyBatisDao
public interface OrderDao extends CrudDao<Order> {



}
