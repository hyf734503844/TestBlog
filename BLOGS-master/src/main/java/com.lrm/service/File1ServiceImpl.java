package com.lrm.service;

import com.lrm.dao.File1Repository;
import com.lrm.po.File1;
import com.lrm.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class File1ServiceImpl implements File1Service {
    @Autowired
    File1Repository file1Repository;

    @Override
    public void uplode(String fileName, HttpSession httpSession) {
        File1 file1=new File1();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date date = new Date();
        User user=(User)httpSession.getAttribute("user");
        file1.setUserId(user.getId());
        file1.setFileName(fileName);
        file1.setCreateTime(date);
        file1.setNickname(user.getNickname());
        file1.setAvatar(user.getAvatar());
        file1Repository.save(file1);
    }

    @Override
    public List<File1> findAll( ) {
        return file1Repository.findAll();
    }

    @Override
    public Page<File1> findAll(Pageable pageable) {
        return file1Repository.findAll(pageable);
    }
}
