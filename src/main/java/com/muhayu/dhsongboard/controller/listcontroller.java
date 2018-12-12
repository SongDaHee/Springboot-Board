package com.muhayu.dhsongboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class listcontroller{
//    @Autowired

    @RequestMapping(value="/list")
    public String list(){
        return "list";
    }

}
