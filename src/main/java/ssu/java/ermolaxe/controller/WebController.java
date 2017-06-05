package ssu.java.ermolaxe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssu.java.ermolaxe.model.Customer;
import ssu.java.ermolaxe.model.Item;
import ssu.java.ermolaxe.service.CustomerService;
import ssu.java.ermolaxe.service.ItemService;
import org.slf4j.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Level;

@Controller
public class WebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    private String username;
    private String password;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/


    @RequestMapping(value = {"/login", "/loginfailed"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        username = request.getParameter("j_username");
        password = request.getParameter("j_password");

        Customer customer = customerService.getCustomerByLogin(username);

        if (customer!=null && customer.getPassword().equals(password)) {
            customer.setEnable(true);
            customerService.save(customer);

            StringBuilder msg = new StringBuilder();
            msg.append("User with login [").append(username).append("] sign in.");
            LOGGER.info(msg.toString(), Level.INFO);

            return "redirect:allitems";
        } else {
            StringBuilder msg = new StringBuilder();
            msg.append("User with login [").append(username).append("] try to sign in, but something went wrong.");
            LOGGER.warn(msg.toString(), Level.WARNING);

            return "redirect:login";
        }
    }


    @RequestMapping(value = {"/myitems"}, method = RequestMethod.GET)
    public String myItems(Model model){
        if (username!= null && customerService.getCustomerByLogin(username).getEnable()){
            model.addAttribute("myitems", itemService.getBySeller(customerService.getCustomerByLogin(username)));
            model.addAttribute("username", username);
            return "myitems";
        } else {
            return "redirect:login";
        }
    }


    @RequestMapping(value = {"/allitems"}, method = RequestMethod.GET)
    public String allItems(Model model){
        if (username!= null && customerService.getCustomerByLogin(username).getEnable()){
            model.addAttribute("allitems", itemService.getAllItemsByNullBuyer());
            model.addAttribute("username", username);
            return "allitems";
        } else {
            return "redirect:login";
        }
    }

    @RequestMapping(value = "/allitems", method = RequestMethod.POST)
    public String allItems(HttpServletRequest request) {
        if (username!=null && customerService.getCustomerByLogin(username).getEnable()) {
            String[] checkboxValues = request.getParameterValues("checkbox_id");
            if (checkboxValues != null && checkboxValues.length>0) {
                List<Item> allItems = itemService.getAllItems();
                for (String elem : checkboxValues) {
                    for (Item item : allItems) {
                        if (elem.equals( String.valueOf(item.getId())) ) {
                            item.setSold(true);
                            item.setBuyer(customerService.getCustomerByLogin(username));
                            itemService.save(item);

                            StringBuilder msg = new StringBuilder();
                            msg.append("User with login [").append(username).append("] bought item [").append(item.toString()).append("]");
                            LOGGER.info(msg.toString(), Level.INFO);
                        }
                    }
                }
            }
            return "redirect:allitems";
        } else return "redirect:login";
    }

    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public String cart(Model model){
        if (username!= null && customerService.getCustomerByLogin(username).getEnable()){
            model.addAttribute("cartitems", itemService.getByBuyer(customerService.getCustomerByLogin(username)));
            model.addAttribute("username", username);
            return "cart";
        } else {
            return "redirect:login";
        }
    }


    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(Model model){
        if (username!= null && customerService.getCustomerByLogin(username).getEnable()){
            Customer cust = customerService.getCustomerByLogin(username);
            cust.setEnable(false);
            customerService.save(cust);
            username = null;
            password = null;
            return "redirect:login";
        } else {
            return "redirect:login";
        }
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest request) {
        String name = request.getParameter("j_username");
        String newpassword = request.getParameter("j_password");
        String confirm = request.getParameter("j_confirm_password");
        if(newpassword.equals(confirm)){
            Customer cust = new Customer(name, newpassword);
            cust.setEnable(false);
            customerService.save(cust);
            return "redirect:login";
        }
        else {
            return "redirect:registration";
        }
    }


    @RequestMapping(value = "/additem", method = RequestMethod.GET)
    public String additem() {
        return "additem";
    }

    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    public String additem(HttpServletRequest request) {
        if(username!=null && customerService.getCustomerByLogin(username).getEnable()) {
            String title = request.getParameter("j_title");
            String desc = request.getParameter("j_description");
            Integer price = Integer.parseInt(request.getParameter("j_price"));

            if (price >= 0) {
                Item item = new Item(title, price, desc, customerService.getCustomerByLogin(username), null, false);
                itemService.save(item);

                StringBuilder msg = new StringBuilder();
                msg.append("User with login [").append(username).append("] add new items[").append(item.toString()).append("]");
                LOGGER.info(msg.toString(), Level.INFO);

                return "redirect:myitems";
            } else {
                return "redirect:additem";
            }
        } else return "redirect:login";
    }

}
