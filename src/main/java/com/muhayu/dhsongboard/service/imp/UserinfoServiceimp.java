package com.muhayu.dhsongboard.service.imp;

import com.muhayu.dhsongboard.mapper.UserinfoMapper;
import com.muhayu.dhsongboard.model.Userinfomodel;
import com.muhayu.dhsongboard.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class UserinfoServiceimp implements UserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    public int userinfoInsert(Userinfomodel userinfomodel) {
        return userinfoMapper.userinfoInsert(userinfomodel);
    }
}
