package com.itwei.java反射;

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

    }
}
