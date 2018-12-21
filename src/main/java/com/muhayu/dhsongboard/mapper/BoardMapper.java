package com.muhayu.dhsongboard.mapper;

import com.muhayu.dhsongboard.model.BoardModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BoardMapper {
    int insertBoard(BoardModel boardmodel);

    List<BoardModel> selectList(String user);

    BoardModel selectByNum(Integer num);

    int updateBoard(BoardModel boardModel);

    int deleteBoard(Integer num);
}
