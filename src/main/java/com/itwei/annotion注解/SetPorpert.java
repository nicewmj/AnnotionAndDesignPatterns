package com.itwei.annotion注解;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SetPorpert {
    String name();
    int leng();
}
