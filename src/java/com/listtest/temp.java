package com.listtest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: temp
 * @Description: TODO
 * @Author: Sissi
 * @Date: 2021/8/11 11:36
 * @Version: 1.0
 */
public class temp {

    public static void main(String[] args) {
        //原集合
        List<String> l1 = new ArrayList<>();
        l1.add("1");
        l1.add("2");
        l1.add("3");

        //新集合
        List<String> l2 = new ArrayList<>(l1);

        //修改原集合的值，查看复制后的集合，值是否发生变化
        for (int i = 0; i < l1.size(); i++) {
            if ("2".equals(l1.get(i))) {
                l1.set(i, "22");
            }
        }

        /*//修改新集合的值，查看原集合，值是否发生变化
        for (int i = 0; i < l2.size(); i++) {
            if ("2".equals(l2.get(i))) {
                l2.set(i, "22");
            }
        }*/

        System.out.println("l1:--------------");
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }

        System.out.println("l2:--------------");
        for (int i = 0; i < l2.size(); i++) {
            System.out.println(l2.get(i));
        }

    }

}
