package com.itwei.jdkproxy_jdk代理;

import com.itwei.staticproxy_静态代理.host;

/**
 * 买房子代理接口
 */
public interface Host {
     void  mia();
}


 class XiaoMing implements host {
     @Override
     public void mia() {
          System.out.println("i am ming  i want shopping");
     }
}
