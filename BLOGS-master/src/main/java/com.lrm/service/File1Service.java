package com.lrm.service;

import com.lrm.po.File1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface File1Service {
    public void uplode(String fileName, HttpSession httpSession);
    public List<File1> findAll( );
    public Page<File1> findAll(Pageable pageable);
}
