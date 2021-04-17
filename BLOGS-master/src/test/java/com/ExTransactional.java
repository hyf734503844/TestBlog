package com;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//可以用在方法上？属性上？类上？
@Target({ElementType.METHOD,ElementType.FIELD})
//必须加这个注解，运行时才能被获取到是否使用注解
@Retention(RetentionPolicy.RUNTIME)
public @interface ExTransactional {
    String name();
}
