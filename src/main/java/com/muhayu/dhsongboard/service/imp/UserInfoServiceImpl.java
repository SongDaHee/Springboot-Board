package com.muhayu.dhsongboard.service.imp;

import com.muhayu.dhsongboard.mapper.UserInfoMapper;
import com.muhayu.dhsongboard.model.UserInfoModel;
import com.muhayu.dhsongboard.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userinfoMapper;

    public int insertUserInfo(UserInfoModel userinfo) {
        return userinfoMapper.insertUserInfo(userinfo);
    }

    public UserInfoModel loginCheck(UserInfoModel userinfo){
        return userinfoMapper.loginCheck(userinfo);
    }

}