package ssu.java.ermolaxe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssu.java.ermolaxe.service.CustomerService;
import ssu.java.ermolaxe.service.ItemService;

@Controller
public class WebController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String customers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String items(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "items";
    }

}
