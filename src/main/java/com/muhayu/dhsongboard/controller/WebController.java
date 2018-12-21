package com.muhayu.dhsongboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController{

    //@Autowired
    //private UserinfoService userinfoService;

    @RequestMapping(value="/")
    public String main(){
        return "main";
    }

    @RequestMapping(value="/home")
    public String home(){
        return "home";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/signup")
    public String signup(HttpServletRequest request){
        return "signup";
    }
}