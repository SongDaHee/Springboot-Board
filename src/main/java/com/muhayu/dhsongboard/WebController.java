package com.muhayu.dhsongboard;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController{
    @RequestMapping("/")
    public String main(){
        return "main";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}