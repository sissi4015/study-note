package java.com.listtest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ArrayListTest
 * @Description: TODO
 * @Author: Sissi
 * @Date: 2021/8/5 1:16
 * @Version: 1.0
 */
public class ArrayListTest {

    public static void main(String[] args) {
        /*
         数据结构：线性结构、动态数组
         1. 初始化(构造方法)：
         */
        // 无参构造方法：创建默认长度的List,默认长度是10
        List l1 = new ArrayList();
        // 创建指定长度的List
        List l2 = new ArrayList(5);
        // 根据集合创建List
        List l3 = new ArrayList(l2);

        /*
         2.插入数据
         */
        // 直接在尾部插入
        // a.
        l1.add("1");
        // 在指定位置插入
        l1.add(1, "2");

        /*
         3.删除
         */
        l1.remove(0);
        l1.remove("1");
    }



}
