package com.itwei.annotion;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.SocketTimeoutException;

/**
 * select user_name,user_age from user_table
 */
public class Mian {

    public static void main(String[] args) throws Exception{
        //项目使用注解肯定会用到反射
        //反射的场景 JDBC spring IOC 常用的框架 一些注解的实现
        Class<?> forName = Class.forName("com.itwei.annotion.UserEntity");

        //getAnnotations() 该方法获取 该类上使用的那些注解
        Annotation[] annotation = forName.getAnnotations();
        for (Annotation annotation1 : annotation){
            System.out.println("该类上使用的那些注解 "+annotation1);
        }

        //获取注解上所有字段名字
        Field[] declaredFields = forName.getDeclaredFields();
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("select ");
        for (int i=0;i<declaredFields.length;i++){
            SetPorpert setPorpert = declaredFields[i].getAnnotation(SetPorpert.class);
            //获取字段名字
            String name = setPorpert.name();
            stringBuffer.append(name);

            if(i == declaredFields.length-1){
                stringBuffer.append(" from ");
            }else {
                stringBuffer.append(" ,");
            }
        }

        //getAnnotation()获取谋个注解对象
        SetTable setTable = forName.getAnnotation(SetTable.class);
        //获取到了表的名称
        String value = setTable.value();
        stringBuffer.append(value);
        System.out.println("谋个注解对象的值 "+value);

        //生成sql语句
        System.out.println("生成sql语句 "+ stringBuffer.toString());
    }
}
