package com.itwei.annotion.staticproxy;

/**
 * 静态代理需要自己生成代理类
 */

//小明明实现房子
public class XiaoMing implements host {
    @Override
    public void mia() {
        System.out.println("i am ming  i want shopping");
    }
}
//代理实现房子
     class  Proxy implements host{

        private XiaoMing xiaoMing;

        public Proxy(XiaoMing xiaoMing){
            this.xiaoMing = xiaoMing;
        }

        public void mia(){
            System.out.println("i am zhong jie see you shopping");
            xiaoMing.mia();
            System.out.println("i am zhong jie see you shopping gitover");
        }

        //静态实现
         public static void main(String[] args) {
             Proxy proxy = new Proxy(new XiaoMing());
             proxy.mia();
         }

}
