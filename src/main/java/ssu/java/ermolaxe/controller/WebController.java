package ssu.java.ermolaxe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssu.java.ermolaxe.model.Customer;
import ssu.java.ermolaxe.service.CustomerService;

@Controller
public class WebController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String customers(Model model) {
//        customerService.save(new Customer("Armen", "qwerty"));
        model.addAttribute("customers", customerService.getAllCustomers());
        return "/info";
    }

}
