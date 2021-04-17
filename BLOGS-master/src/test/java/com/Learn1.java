package com;


import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Learn1{
    Dog dog=new Dog();

    /**
     *
     *
     *
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Thread thread=new Thread(()->System.out.println());
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.queryForMap("select id from t_user ");
    }
}


