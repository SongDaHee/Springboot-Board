package com.muhayu.dhsongboard.mapper;

import com.muhayu.dhsongboard.model.UserInfoModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserInfoMapper {
    int insertUserInfo(UserInfoModel userinfo);

    UserInfoModel selectByEmail(String email);

}

