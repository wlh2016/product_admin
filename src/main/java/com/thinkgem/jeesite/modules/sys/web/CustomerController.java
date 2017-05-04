package com.thinkgem.jeesite.modules.sys.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Customer;
import com.thinkgem.jeesite.modules.sys.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tony_Wu
 * @date 2017-4-25
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/customer")
public class CustomerController extends BaseController {

    private final static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    /**
     * 查看客户列表
     * @param customer
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"/list", ""})
    public String list(Customer customer, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Customer> page = customerService.findPage(new Page<Customer>(request, response), customer);
        model.addAttribute("page", page);
        if((customer.getName()!=null) || (customer.getPhone()!=null) || (customer.getAddress()!=null)) {
            model.addAttribute("customer", customer);
        }
        return "modules/customer/customerList";
    }

    /**
     * 修改客户信息界面
     * @param cid
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit/{cid}", method = RequestMethod.POST)
    public String edit(@PathVariable(value = "cid") Integer cid, Model model) {
        Customer c = this.customerService.findById(cid);
        model.addAttribute("c", c);
        return "modules/customer/editCustomer";
    }

    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    @RequestMapping(value = "/editCustomer", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String editCustomer(@RequestBody Customer customer) {
        try {
            this.customerService.update(customer);
            return "true";
        } catch (Exception e) {
            System.out.println(e);
            return "false";
        }
    }

    @RequestMapping(value = "/delete/{cid}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable(value = "cid") int cid) {
        try {
            Customer customer = this.customerService.findById(cid);
            customer.setDelStatus(true);
            this.customerService.update(customer);
            return "true";
        } catch (Exception e) {
            System.out.println(e);
            return "false";
        }
    }

    @RequestMapping(value = "/taskTest/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String taskTest(@PathVariable(value = "id") String id) {
        try {
            this.customerService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

}
