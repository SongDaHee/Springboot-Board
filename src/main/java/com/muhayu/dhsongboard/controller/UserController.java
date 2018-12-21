package com.muhayu.dhsongboard.controller;

import com.muhayu.dhsongboard.model.UserInfoModel;
import com.muhayu.dhsongboard.service.UserInfoService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String signupProc(HttpServletRequest request) throws Exception {

        UserInfoModel userInfo = new UserInfoModel();

        String email = request.getParameter("input_email");
        String password = request.getParameter("input_password");
        String encodePassword = BCrypt.hashpw(password,BCrypt.gensalt());
        String name = request.getParameter("input_name");

        userInfo.setEmail(email);
        userInfo.setPassword(encodePassword);
        userInfo.setName(name);
        userinfoService.insertUserInfo(userInfo);

        return "redirect:/login";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login-proc")
    public String loginProc(HttpServletRequest request, HttpSession session, Model model) {
        String email = request.getParameter("input_email");
        String password = request.getParameter("input_password");

        try{
            UserInfoModel userInfo = userinfoService.procLogin(email,password,session);

            if(userInfo==null)
            {
                throw new Exception();
            }
        } catch (Exception e) {
            model.addAttribute("msg",e.getMessage());
            return "/login";
        }
        return "redirect:/list";
    }

    // 로그아웃 하는 부분
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}