package com.muhayu.dhsongboard.service;

import com.muhayu.dhsongboard.model.UserInfoModel;

public interface UserInfoService {

    int insertUserInfo(UserInfoModel userinfo);

    UserInfoModel loginCheck(UserInfoModel userinfo);
}