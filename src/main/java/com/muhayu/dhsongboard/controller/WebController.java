package com.muhayu.dhsongboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController{

    //copykiller page
    @RequestMapping(value="/")
    public String main(){
        return "main";
    }

    //board main page
    @RequestMapping(value="/home")
    public String home(){
        return "home";
    }

}