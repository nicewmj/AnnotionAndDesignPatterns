package com.itwei.annotion注解;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 表的别名
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SetTable {
    String value();
}
