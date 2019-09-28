package com.itwei.jdkproxy_jdk代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK代理需要实现 InvocationHandler
 */
public class NewJdkProxy implements InvocationHandler {

    private Object tarjet;

    public NewJdkProxy(Object tarjet) {
        this.tarjet = tarjet;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("i am zhong jie see you shopping");
        Object oj = method.invoke(tarjet, args);
        System.out.println("i am zhong jie see you shopping gitover");
        return oj;
    }
}

class Test {
//报错了 类转换异常
    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        NewJdkProxy newJdkProxy = new NewJdkProxy(xiaoMing);
        Host o = (Host) Proxy.newProxyInstance(xiaoMing.getClass().getClassLoader(), xiaoMing.getClass().getInterfaces(), newJdkProxy);
        o.mia();
    }
}
