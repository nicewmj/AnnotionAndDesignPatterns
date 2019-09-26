package com.itwei.java反射;

import java.lang.reflect.Field;

/**
 * 反射机制获取类有三种方法反射机制获取类有三种方法
 *
 * 1.通过对象的getClass()函数获得
 * Test test = new Test();
 * Class testClass = test.getClass();
 *
 *
 * 2.通过类的静态域class获得
 * Class testClass2 = Test.class;
 *
 * 3.通过Class类的forName(“”)获得
 * Class testClass3 = Class.forName("包路径+类名");
 *
 */

public class TestForName {

    public static void main(String[] args) {

        //使用反射为类私有属性赋值
        User user = new User();
        user.setAge(12);
        user.setName("小明");
        System.out.println("原来 name = "+ user.getName());

        try {
            // 获取当前类class地址
            Class<?> forName = Class.forName("com.itwei.java反射.User");

            //使用反射实例對象 无参构造函数
            Object newInstance = forName.newInstance();

            //获取当前的字段 getDeclaredFields()获取所有的字段 返回数组 getDeclaredField获取单个的字段
            Field name = forName.getDeclaredField("name");

            //设置 允许操作私有的成员变量  如果不设置为true 运行报错  属性为私有的不能改变
            name.setAccessible(true);

            //设置 改变字段的值
            name.set(newInstance,"小红");

            //打印改变后的值
            User user1 = (User)newInstance;
            String name1 = user1.getName();
            System.out.println("改变后 name = "+name1);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
