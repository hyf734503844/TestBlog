package com.lrm.service;

import com.lrm.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lrm.dao.PersonMapper;

import java.util.List;

@Service
public class UImpl implements U {
    @Autowired
    PersonMapper personMapper;

    @Override
    public List<User> getAllUsers() {
        Long l=new Long(1);
        return personMapper.getAllUsers(l);
    }

    @Override
    public List<User> getAllUsers1() {
        return personMapper.getAllUsers12("gg");
    }

    @Override
    public void insertUer() {
        personMapper.insertUser("13471425392");
    }
}
