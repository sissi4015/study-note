package com.listtest;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
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

        //PART1:初始化(构造方法)：
        //------------------------------------------------------------------------------
        //1).无参构造方法：创建默认长度的List,默认长度是10
        List<String> l1 = new ArrayList<String>();
        //public ArrayList() {
        //     this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        //}

        //------------------------------------------------------------------------------
        //2).创建指定长度的List
        List<String> l2 = new ArrayList<String>(5);
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
        List<String> l3 = new ArrayList<String>(l2);
        //public ArrayList(Collection<? extends E> c) {
        //    将指定的集合转换为数组
        //    elementData = c.toArray();
        //    如果不是空数组，将数组长度赋值给size,如果集合转换为的数组是Object数组，将转换后的数组拷贝给elementData
        //    TODO:？？？？为什么要拷贝一份，而不用直接转化后的数组？？？
        //    SOLUTION:上述问题，见ArraysTest中测试Arrays.copyOf是浅拷贝，对于基本数据类型是值拷贝，引用数据类型是引用拷贝
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


        //PART2:插入数据
        //1)直接在尾部插入
        l1.add("1");
        //public boolean add(E e) {
        //    检测是否需要扩容
        //    ensureCapacityInternal(size + 1);  // Increments modCount!!
        //    elementData[size++] = e;
        //    return true;
        //}

        //private void ensureCapacityInternal(int minCapacity) {
        //    ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
        //}

        //NOTICE:计算最小容量：原始List为空List时，返回最小容量(size+1)和默认容量的最大值;否则返回最小容量
        //private static int calculateCapacity(Object[] elementData, int minCapacity) {
        //    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        //        return Math.max(DEFAULT_CAPACITY, minCapacity);
        //    }
        //    return minCapacity;
        //}

        //NOTICE:如果最小容量-当前elementData长度>0,扩容
        //private void ensureExplicitCapacity(int minCapacity) {
        //    modCount++;
        //    // overflow-conscious code
        //    if (minCapacity - elementData.length > 0)
        //        grow(minCapacity);
        //}

        //NOTICE:扩容方式：新的数组容量=原始数组容量的1.5倍;
        // 如果扩容后的1.5倍的数组容量大于List中定义的最大容量(MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8)
        // 当size+1<0时，抛出越界异常;
        // 否则(minCapacity > MAX_ARRAY_SIZE) ?
        //            Integer.MAX_VALUE :
        //            MAX_ARRAY_SIZE;
        //private void grow(int minCapacity) {
        //    // overflow-conscious code
        //    int oldCapacity = elementData.length;
        //    右移1位即除以2：例：10的二进制是1010；右移1位是0101；即5
        //    int newCapacity = oldCapacity + (oldCapacity >> 1);
        //    if (newCapacity - minCapacity < 0)
        //        newCapacity = minCapacity;
        //    if (newCapacity - MAX_ARRAY_SIZE > 0)
        //        newCapacity = hugeCapacity(minCapacity);
        //    // minCapacity is usually close to size, so this is a win:
        //    elementData = Arrays.copyOf(elementData, newCapacity);
        //}

        //------------------------------------------------------------------------------
        //2)在指定位置插入:
        // a.检测index是否越界；
        // b.判断是否需要扩容；
        // c.将index+1以及之后的元素向后移动一位，使用System.arraycopy方法
        // d.赋值index位置元素
        l1.add(1, "2");

        //PART3:删除
        //------------------------------------------------------------------------------
        //1)删除指定index位置的元素:
        // a.检测index是否越界
        // b.将index+1以及之后的元素向后移动一位，使用System.arraycopy方法
        // c.将最后一个位置的元素清空，并将size减1
        l1.remove(0);

        //------------------------------------------------------------------------------
        //2)删除指定元素：
        // a.如果元素为空，遍历elementData，将空元素删除，将空元素之后的元素向前移动，并更改size的值
        // b.如果元素不为空，遍历elementData，将equals为true的元素删除，将之后的元素向前移动，并更改size的值
        l1.remove("111");

        //PART4:遍历中删除（fail-fast机制）
        //根本原因：当modCount != expectedModCount时，抛出异常
        //final void checkForComodification() {
        //    if (modCount != expectedModCount)
        //        throw new ConcurrentModificationException();
        //}

        //解决方案：使用迭代器的remove
        Iterator<String> i = l1.iterator();
        while (i.hasNext()) {
            String s = i.next();
            if ("1".equals(s)) {
                i.remove();
            }
        }

    }



}
