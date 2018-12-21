package com.muhayu.dhsongboard.controller;

import com.muhayu.dhsongboard.model.BoardModel;
import com.muhayu.dhsongboard.model.UserInfoModel;
import com.muhayu.dhsongboard.service.BoardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller

public class ListController{

    @Autowired
    BoardService boardService;

    @RequestMapping(value="/list")
    public String list(Model model, HttpServletRequest request, HttpSession session){
        UserInfoModel userinfo = (UserInfoModel) session.getAttribute("login");

        String email = userinfo.getEmail();

        List<BoardModel> list = boardService.selectList(email);

        model.addAttribute("list", list);

        return "list";
    }

    @RequestMapping(value="/list/write")
    public String write(){
        return "write";
    }

    @RequestMapping(value="/list/write-proc")
    public String writeProc(HttpServletRequest request, HttpSession session) {
        BoardModel board = new BoardModel();

        UserInfoModel userinfo= (UserInfoModel) session.getAttribute("login");

        String email = userinfo.getEmail();
        String title = request.getParameter("input_title");
        String content = request.getParameter("input_content");
        String date = request.getParameter("input_date");


        board.setTitle(title);
        board.setContent(content);
        board.setDate(date);
        board.setUser(email);

        boardService.insertBoard(board);

        return "redirect:/list";
    }

    @RequestMapping(value="/list/view/*")
    public String view(HttpServletRequest request, Model model){

        StringBuffer url = request.getRequestURL();

        ///list/view/* 에서 *부분 값을 구한다
        //Integer num = url.charAt(url.length() - 1) - '0';
        Integer num = Integer.valueOf(StringUtils.substringAfter(url.toString(), "/list/view/"));

        BoardModel board = boardService.selectByNum(num);

        String date = board.getDate();
        String title = board.getTitle();
        String content = board.getContent();

        model.addAttribute("date",date);
        model.addAttribute("title",title);
        model.addAttribute("content",content);
        model.addAttribute("num",num);

        return "view";
    }

    @RequestMapping(value="/list/edit/*")
    public String edit(HttpServletRequest request, Model model2){
        StringBuffer url = request.getRequestURL();
        Integer num = Integer.valueOf(StringUtils.substringAfter(url.toString(), "/list/edit/"));

        BoardModel board2 = boardService.selectByNum(num);

        String title = board2.getTitle();
        String content = board2.getContent();

        model2.addAttribute("title",title);
        model2.addAttribute("content",content);
        model2.addAttribute("num",num);

        return "edit";
    }

    @RequestMapping(value="/list/edit-proc/*")
    public String editProc(HttpServletRequest request,HttpSession session){
        StringBuffer url=request.getRequestURL();
        Integer num = Integer.valueOf(StringUtils.substringAfter(url.toString(), "/list/edit-proc/"));

        BoardModel board3 = new BoardModel();
        String date = request.getParameter("input_date");
        String title = request.getParameter("input_title");
        String content = request.getParameter("input_content");

        board3.setDate(date);
        board3.setTitle(title);
        board3.setContent(content);
        board3.setNum(num);

        boardService.updateBoard(board3);

        return "redirect:/list";
    }

    @RequestMapping(value="/list/delete/*") //조회페이지에서 삭제받을 때
    public String delete(HttpServletRequest request){
        StringBuffer url=request.getRequestURL();
        Integer num = Integer.valueOf(StringUtils.substringAfter(url.toString(), "/list/delete/"));

        boardService.deleteBoard(num);

        return "redirect:/list";
    }

    @RequestMapping(value="/list/delete") //일반페이지에서 삭제받을 때
    public String delete2(HttpServletRequest request) {
        String[] str = request.getParameterValues("checknum");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(str));

        for (int i = 0; i < list.size(); i++) {
            Integer num = Integer.parseInt(list.get(i));
            boardService.deleteBoard(num);
        }
        return "redirect:/list";
    }
}

