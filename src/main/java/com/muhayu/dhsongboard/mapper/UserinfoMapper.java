package com.muhayu.dhsongboard.mapper;

import com.muhayu.dhsongboard.model.Userinfomodel;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.*;

@Mapper
//@Component
public interface UserinfoMapper{
    int userinfoInsert(Userinfomodel userinfomodel);
}
