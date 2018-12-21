package com.muhayu.dhsongboard.service.impl;

import com.muhayu.dhsongboard.mapper.BoardMapper;
import com.muhayu.dhsongboard.model.BoardModel;
import com.muhayu.dhsongboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardMapper boardMapper;

    @Override
    public int insertBoard(BoardModel board){

        return boardMapper.insertBoard(board);
    }

    @Override
    public List<BoardModel> selectList(String user){

        return boardMapper.selectList(user);
    }

    @Override
    public BoardModel selectByNum(Integer num){
        return boardMapper.selectByNum(num);
    }

    @Override
    public int updateBoard(BoardModel board){

        return boardMapper.updateBoard(board);
    }

    @Override
    public int deleteBoard(Integer num){
        return boardMapper.deleteBoard(num);
    }

}

