package com.thinkgem.jeesite.modules.sys.web;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tony_Wu
 * @date 2017-4-25
 */

@Controller
@RequestMapping(value = "order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

}
