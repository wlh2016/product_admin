package com.thinkgem.jeesite.modules.sys.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.dao.OrderDao;
import com.thinkgem.jeesite.modules.sys.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tony_Wu
 * @date 2017-4-25
 */
@Service
@Transactional(readOnly = true)
public class OrderService extends CrudService<OrderDao, Order> {

    @Autowired
    private OrderDao orderDao;

    public Order findById(int oid) {
        return this.orderDao.findById(oid);
    }

}
