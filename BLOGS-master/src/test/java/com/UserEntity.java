package com;

import org.springframework.transaction.annotation.Transactional;

public class UserEntity {
    private Integer userId;
    public String name;


    public UserEntity(){

    }

    public UserEntity(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }
    @hyf
    @Transactional
    @ExTransactional(name="abc")
    public void good(String s){
        System.out.println("good:"+s);
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
