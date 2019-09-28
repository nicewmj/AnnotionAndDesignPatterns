package com.itwei.Thread多线程分批处理;

import java.util.ArrayList;
import java.util.List;

public class UserThread implements Runnable{

    private List<UserEnity> list;

    public UserThread(List<UserEnity> list){
        this.list = list;
    }

    @Override
    public void  run(){
        for(UserEnity userEnity : list){
            System.out.println("threadName "+Thread.currentThread().getName() + "  名字 "+userEnity.getUserName() +"   编号 "+userEnity.getUserId());
            //这里可以写 具体需要执行的代码
        }
        //换行 显示更清爽
        System.out.println();
    }

    //初始化数据
    public static List<UserEnity> init(){
        List<UserEnity> list = new ArrayList<>();
        for(int i =0;i<11;i++){
            list.add(new UserEnity("userId"+i,"userName"+i));
        }
        return list;
    }
}
