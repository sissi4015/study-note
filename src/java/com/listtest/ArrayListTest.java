package com.listtest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ArrayListTest
 * @Description: TODO
 * @Author: Sissi
 * @Date: 2021/8/9 1:16
 * @Version: 1.0
 */
public class ArrayListTest {

    public static void main(String[] args) {
        //数据结构：线性结构、动态数组
        //1.初始化(构造方法)：

        //------------------------------------------------------------------------------
        //1).无参构造方法：创建默认长度的List,默认长度是10
        List l1 = new ArrayList();
        //public ArrayList() {
        //     this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        //}

        //------------------------------------------------------------------------------
        //2).创建指定长度的List
        List l2 = new ArrayList(5);
        //public ArrayList(int initialCapacity) {
        //    如果指定的初始容量大于0，创建指定大小的Object数组，赋值给elementData
        //    if (initialCapacity > 0) {
        //        this.elementData = new Object[initialCapacity];
        //    如果指定的初始容量等于0，将EMPTY_ELEMENTDATA赋值给elementData
        //    } else if (initialCapacity == 0) {
        //        this.elementData = EMPTY_ELEMENTDATA;
        //    如果指定的初始容量小于0，抛出非法参数异常
        //    } else {
        //        throw new IllegalArgumentException("Illegal Capacity: "+
        //                initialCapacity);
        //    }
        //}

        //------------------------------------------------------------------------------
        //3).s根据集合创建List
        List l3 = new ArrayList(l2);
        //public ArrayList(Collection<? extends E> c) {
        //    将指定的集合转换为数组
        //    elementData = c.toArray();
        //    如果不是空数组，将数组长度赋值给size,如果集合转换为的数组是Object数组，将转换后的数组拷贝给elementData
        //    TODO:？？？？为什么要拷贝一份，而不用直接转化后的数组？？？
        //    上述问题，见ArraysTest中测试Arrays.copyOf是浅拷贝，对于基本数据类型是值拷贝，引用数据类型是引用拷贝
        //    if ((size = elementData.length) != 0) {
        //        // c.toArray might (incorrectly) not return Object[] (see 6260652)
        //        if (elementData.getClass() != Object[].class)
        //            elementData = Arrays.copyOf(elementData, size, Object[].class);
        //    } else {
        //    如果是空数组，将EMPTY_ELEMENTDATA赋值给elementData
        //        // replace with empty array.
        //        this.elementData = EMPTY_ELEMENTDATA;
        //    }
        //}

        //------------------------------------------------------------------------------
        //2.插入数据
        //直接在尾部插入
        //a.
        l1.add("1");
        //在指定位置插入
        l1.add(1, "2");

        //3.删除
        l1.remove(0);
        l1.remove("1");
    }



}
