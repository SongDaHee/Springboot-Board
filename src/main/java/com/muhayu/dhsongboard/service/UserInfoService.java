package com.muhayu.dhsongboard.service;

import com.muhayu.dhsongboard.exception.UserInfoException;
import com.muhayu.dhsongboard.model.UserInfoModel;

import javax.servlet.http.HttpSession;

public interface UserInfoService {

    int insertUserInfo(UserInfoModel userinfo);

    UserInfoModel procLogin(String email, String password, HttpSession session) throws UserInfoException;

    UserInfoModel selectByEmail(String email);

}