package ssu.edu.java.market.ermolaxe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Александр on 27.11.2016.
 */
@Controller
public class ViewController {

    @RequestMapping(value = "/start")
    public String start(){
        return "start";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
