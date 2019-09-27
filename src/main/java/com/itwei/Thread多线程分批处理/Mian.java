package com.itwei.Thread多线程分批处理;

import java.util.List;

import static com.itwei.Thread多线程分批处理.UserThread.init;

public class Mian {
    public static void main(String[] args) {
        //初始化用户数据
        List<UserEnity> list = init();

        //2 计算需要创建多少个线程，并且每个线程需要执行“分批发送短信用户”
        //每个线程分批跑多少
        int userThreadPage = 50;

        //计算所有的线程数
        List<List<UserEnity>> lists = ListUtils.spiltList(list, userThreadPage);
        int size = lists.size();
        for(int i=0;i<size;i++){

            List<UserEnity> userEnities = lists.get(i);
            UserThread userThread = new UserThread(userEnities);

            //3 执行任务发送短信
            userThread.start();
        }
    }
}
