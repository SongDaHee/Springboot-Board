package com.muhayu.dhsongboard.controller;

import com.muhayu.dhsongboard.model.UserInfoModel;
import com.muhayu.dhsongboard.service.UserInfoService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserInfoService userinfoService;

    @RequestMapping(value = "/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/signup-proc")
    public String signuProc(HttpServletRequest request) throws Exception {

        UserInfoModel userinfo = new UserInfoModel();

        String email = request.getParameter("input_Email");
        String password = request.getParameter("input_Password");
        String encode_password= BCrypt.hashpw(password,BCrypt.gensalt());
        String name = request.getParameter("input_Name");
        userinfo.setEmail(email);
        userinfo.setPassword(encode_password);
        userinfo.setName(name);
        userinfoService.insertUserInfo(userinfo);

        return "redirect:/login";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login-proc")
    public String loginProc(UserInfoModel userinfo2, HttpServletRequest request, HttpSession session) {
        String email = request.getParameter("input_Email");
        String password = request.getParameter("input_Password");

        UserInfoModel userinfo;
        userinfo2.setEmail(email);
        userinfo=userinfoService.loginCheck(userinfo2);

        if(session.getAttribute("login")!=null){
            session.removeAttribute("login");
        }
        if(userinfo!=null
                && BCrypt.checkpw(password,userinfo.getPassword())){
            request.getSession().setAttribute("login",userinfo);
            request.getSession().setMaxInactiveInterval(60*30);

            return "forward:/home";
        }
        else{
            return "redirect:/login";
        }
    }
    // 로그아웃 하는 부분
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}