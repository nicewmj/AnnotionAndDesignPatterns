package com.itwei.annotion.jdkproxy;

import com.itwei.annotion.staticproxy.host;

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
