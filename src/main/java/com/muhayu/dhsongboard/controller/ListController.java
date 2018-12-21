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
        UserInfoModel userInfo = (UserInfoModel) session.getAttribute("login");

        String email = userInfo.getEmail();

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

        UserInfoModel userInfo = (UserInfoModel) session.getAttribute("login");

        String email = userInfo.getEmail();
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
    public String view(Model model, HttpServletRequest request){

        StringBuffer url = request.getRequestURL();

        Integer num = Integer.valueOf(StringUtils.substringAfter(url.toString(), "/list/view/"));

        BoardModel board = boardService.selectByNum(num);

        model.addAttribute("board",board);

        return "view";
    }

    @RequestMapping(value="/list/edit/*")
    public String edit(Model model, HttpServletRequest request){
        StringBuffer url = request.getRequestURL();
        Integer num = Integer.valueOf(StringUtils.substringAfter(url.toString(), "/list/edit/"));

        BoardModel board = boardService.selectByNum(num);

        model.addAttribute("board",board);

        return "edit";
    }

    @RequestMapping(value="/list/edit-proc/*")
    public String editProc(HttpServletRequest request,HttpSession session){
        StringBuffer url = request.getRequestURL();
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
        StringBuffer url = request.getRequestURL();
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

