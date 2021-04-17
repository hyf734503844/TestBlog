package com.lrm.dao;

import com.lrm.po.File1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface File1Repository extends JpaRepository<File1,Long>, JpaSpecificationExecutor<File1> {

}
