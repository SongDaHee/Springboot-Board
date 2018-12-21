package com.muhayu.dhsongboard.service.impl;

import com.muhayu.dhsongboard.exception.UserInfoException;
import com.muhayu.dhsongboard.mapper.UserInfoMapper;
import com.muhayu.dhsongboard.model.UserInfoModel;
import com.muhayu.dhsongboard.service.UserInfoService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userinfoMapper;

    public int insertUserInfo(UserInfoModel userinfo) {
        return userinfoMapper.insertUserInfo(userinfo);
    }

    @Override
    public UserInfoModel procLogin(String email, String password, HttpSession session) throws UserInfoException {
        try {
            UserInfoModel loggedUser = selectByEmail(email);
            if (loggedUser == null) {
                throw new UserInfoException("일치하는 이메일이 없습니다");
            }
            if (!BCrypt.checkpw(password, loggedUser.getPassword())) {
                throw new UserInfoException("패스워드를 다시 확인해주세요");
            }
            session.setAttribute("login", loggedUser);

            return loggedUser;
        } catch (UserInfoException e) {
            throw e;
        }
    }

    public UserInfoModel selectByEmail(String email){
        return userinfoMapper.selectByEmail(email);
    }
}