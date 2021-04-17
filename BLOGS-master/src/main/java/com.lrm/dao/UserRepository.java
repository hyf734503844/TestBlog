package com.lrm.dao;

import com.lrm.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserRepository extends JpaRepository<User,Long> , JpaSpecificationExecutor<User> {
    User findUserByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    User findUserByEmail(String email);
    User findByPhone(String phone);

//    findBy   Username  And   Password

}
