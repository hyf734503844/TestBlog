package com;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//必须加这个注解，运行时才能被获取到是否使用注解
@Retention(RetentionPolicy.RUNTIME)
public @interface hyf {
}
