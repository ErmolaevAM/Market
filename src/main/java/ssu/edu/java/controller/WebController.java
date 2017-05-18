package ssu.edu.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ssu.edu.java.dao.DAO;
import ssu.edu.java.model.Item;
import ssu.edu.java.model.Session;
import ssu.edu.java.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private DAO dao;

    @Autowired
    private Session session;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        String login = request.getParameter("j_username");
        String pass = request.getParameter("j_password");
        User user = dao.getUserByName(login);
        if (user != null){
            if (user.getPassword().equals(pass)){
                session.setUser(user);
                return "redirect:home";
            } else {
                //ALERT wrong password!
                return "redirect:/";
            }
        } else {
            return "redirect:registration";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest request){
        String login = request.getParameter("j_username");
        String pass = request.getParameter("j_password");
        User user = new User(login, pass);
        dao.saveUser(user);
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        if (session.getUser() != null) {
            List<Item> itemList = dao.getAllItems();
            itemList.add(new Item("car", 1000, false));
            ModelAndView mav = new ModelAndView("/home");
            mav.addObject("itemList", itemList);
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("redirect:/");
            return mav;
        }
    }

    @RequestMapping(value = "/additem", method = RequestMethod.GET)
    public String addItem(){
        return "/additem";
    }

    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    public String addItem(HttpServletRequest request) {
        String title = request.getParameter("item_title");
        int price = Integer.parseInt(request.getParameter("item_price"));
        Item item = new Item(title, price, false);
        item.setBuyer(null);
        dao.saveItem(item);
        return "redirect:/home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        session.setUser(null);
        return "redirect:/";
    }
}
