package com.muhayu.dhsongboard.service;

import com.muhayu.dhsongboard.model.BoardModel;

import java.util.List;


public interface BoardService {

    int insertBoard(BoardModel board);

    List<BoardModel> selectList(String user);

    BoardModel selectByNum(Integer num);

    int updateBoard(BoardModel board);

    int deleteBoard(Integer num);

}
