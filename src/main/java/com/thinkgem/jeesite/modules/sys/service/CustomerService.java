package com.thinkgem.jeesite.modules.sys.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.dao.CustomerDao;
import com.thinkgem.jeesite.modules.sys.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tony_Wu
 * @date 2017-4-25
 */
@Service("customerService")
@Transactional(readOnly = true)
public class CustomerService extends CrudService<CustomerDao, Customer> {

    @Autowired
    private CustomerDao customerDao;

    public Customer findById(int cid) {
        return this.customerDao.findById(cid);
    }

    public void update(Customer customer) {
        this.customerDao.update(customer);
    }

}
