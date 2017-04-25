package com.thinkgem.jeesite.modules.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Tony_Wu
 * @date 2017-4-25
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {

        return "modules/customer/customerList";
    }

}
