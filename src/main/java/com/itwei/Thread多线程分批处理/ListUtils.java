package com.itwei.Thread多线程分批处理;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算分页的工具类  list集合分批集合
 *
 * list 切割的集合
 * pageSize 分页的长度
 * <T> List<List<T>> 返回分页的数据
 *
 */
public class ListUtils {

    public static <T> List<List<T>> spiltList(List<T> list,int pageSize) {

        int listSize = list.size();
        int page = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>> listsArray = new ArrayList<>();
        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<>();
            for (int j = 0; j < listSize; j++) {
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                if (pageIndex == (i + 1)) {

                    subList.add(list.get(j));
                    if ((j + 1) == ((j + 1) * pageSize)) {

                        break;
                    }
                }
                listsArray.add(subList);
            }
        }
        return listsArray;
    }
}
