package com.itwei.Thread多线程分批处理;

import java.util.ArrayList;
import java.util.List;

public class UserThread extends Thread{
    private List<UserEnity> list;

    public UserThread(List<UserEnity> list){
        this.list = list;
    }

    public void  run(){
        for(UserEnity userEnity : list){
            System.out.println("threadName "+Thread.currentThread().getName() + "  名字 "+userEnity.getUserName() +"   编号 "+userEnity.getUserId());
            //这里可以写 具体需要执行的代码
        }
    }

    //初始化数据
    public static List<UserEnity> init(){
        List<UserEnity> list = new ArrayList<>();
        UserEnity userEnity = new UserEnity();
        for(int i =0;i<50;i++){
            userEnity.setUserId("userId"+i);
            userEnity.setUserName("userName"+i);
            list.add(userEnity);
        }
        return list;
    }



}
