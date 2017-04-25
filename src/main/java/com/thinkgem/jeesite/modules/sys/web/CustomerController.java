package com.thinkgem.jeesite.modules.sys.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Customer;
import com.thinkgem.jeesite.modules.sys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tony_Wu
 * @date 2017-4-25
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/customer")
public class CustomerController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = {"/list", ""})
    public String list(Customer customer, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Customer> page = customerService.findPage(new Page<Customer>(request, response), customer);
        model.addAttribute("page", page);
        if((customer.getName()!=null) || (customer.getPhone()!=null) || (customer.getAddress()!=null)) {
            model.addAttribute("customer", customer);
        }
        return "modules/customer/customerList";
    }

}
