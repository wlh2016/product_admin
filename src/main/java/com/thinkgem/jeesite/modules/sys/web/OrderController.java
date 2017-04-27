package com.thinkgem.jeesite.modules.sys.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Brush;
import com.thinkgem.jeesite.modules.sys.entity.Customer;
import com.thinkgem.jeesite.modules.sys.entity.Order;
import com.thinkgem.jeesite.modules.sys.service.BrushService;
import com.thinkgem.jeesite.modules.sys.service.CustomerService;
import com.thinkgem.jeesite.modules.sys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BrushService brushService;

    /**
     * 查询客户订单
     * @param cid
     * @param order
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/forCustomer/{cid}")
    public String findOrdersByCustomerId(@PathVariable("cid")Integer cid, Order order, HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("order", order);
        Customer customer = this.customerService.findById(cid);
        model.addAttribute("customer", customer);
        order.setCustomer(customer);
        Page<Order> page = orderService.findPage(new Page<Order>(request, response), order);
        model.addAttribute("page", page);
        return "modules/order/orderList";
    }

    /**
     * 查询订单明细
     * @param oid
     * @param brush
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/orderDetails/{oid}")
    public String orderDetails(@PathVariable("oid") Integer oid, @RequestParam(value = "unitPrice", required = false) Float unitPrice, Brush brush, HttpServletRequest request, HttpServletResponse response, Model model) {
        if(unitPrice != null) {
            brush.setUnitPrice(unitPrice);
        }
        model.addAttribute("oid", oid);
        Order order = this.orderService.findById(oid);
        model.addAttribute("order", order);
        brush.setOrder(order);
        Page<Brush> page = this.brushService.findPage(new Page<Brush>(request, response), brush);
        model.addAttribute("page", page);
        model.addAttribute("brush", brush);
        return "modules/order/orderDetails";
    }


}
