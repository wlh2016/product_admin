package com.thinkgem.jeesite.modules.sys.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Customer;
import com.thinkgem.jeesite.modules.sys.entity.Order;
import com.thinkgem.jeesite.modules.sys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tony_Wu
 * @date 2017-4-25
 */

@Controller
@RequestMapping(value = "${adminPath}/sys/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/forCustomer/{cid}")
    public String findOrdersByCustomerId(@PathVariable("cid")Integer cid, Order order, HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("cid", cid);
        model.addAttribute("order", order);
        Customer customer = new Customer();
        customer.setId(String.valueOf(cid));
        order.setCustomer(customer);
        model.addAttribute("customer", customer);
        Page<Order> page = orderService.findPage(new Page<Order>(request, response), order);
        model.addAttribute("page", page);


        return "modules/order/orderList";
    }


}
