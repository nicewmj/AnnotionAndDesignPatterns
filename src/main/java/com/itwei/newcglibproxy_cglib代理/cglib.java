package com.itwei.newcglibproxy_cglib代理;

import com.itwei.jdkproxy_jdk代理.Host;
import com.itwei.staticproxy_静态代理.XiaoMing;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class cglib implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {


        System.out.println("i am zhong jie see you shopping");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("i am zhong jie see you shopping gitover");
        return o1;
    }
}
class Test01 {

    //又类转换异常啦 不知道为啥
    public static void main(String[] args) {
        cglib cglib = new cglib();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(XiaoMing.class);
        enhancer.setCallback(cglib);
        Host h = (Host) enhancer.create();
        h.mia();
    }
}
