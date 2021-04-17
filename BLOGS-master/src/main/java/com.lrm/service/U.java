package com.lrm.service;

import com.lrm.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface U {
    List<User> getAllUsers();
    List<User> getAllUsers1();
    void insertUer();
}
