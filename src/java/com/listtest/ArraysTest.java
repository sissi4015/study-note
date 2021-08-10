package com.listtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ArraysTest
 * @Description: TODO
 * @Author: Sissi
 * @Date: 2021/8/10 11:07
 * @Version: 1.0
 */
public class ArraysTest {

    public static void main(String[] arg) {

        //利用 public ArrayList(Collection<? extends E> c) 测试 Arrays.copyof 方法，是值拷贝还是引用拷贝？
        //结论：Arrays.copyof是浅拷贝，即：对于基本数据类型是值拷贝，引用数据类型是引用拷贝

        //Arrays.copyof方法介绍：
        //复制指定的数组，截断或填充空值(如果需要)，使复制具有指定的长度。
        //对于在原始数组和复制数组中都有效的所有索引，两个数组将包含相同的值。
        //对于在副本中有效而不是在原始副本中有效的任何索引，副本将包含null。
        //当且仅当指定的长度大于原始数组的长度时，这样的索引才会存在。
        //结果数组是类newType的。


        List stringList = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        List copyList = new ArrayList<String>(stringList);

        copyList.set(0, "e");

        System.out.println("stringList:     " + stringList);
        System.out.println("copyList:       " + copyList);

        List<CustBook> objectList = Arrays.asList(new CustBook("a"), new CustBook("b"), new CustBook("c"));
        List<CustBook> copyobjectList = new ArrayList<CustBook>(objectList);

        copyobjectList.get(0).setName("e");

        System.out.print("objectList:     ");
        for (int i = 0; i < objectList.size(); i++) {
            System.out.print(objectList.get(i).getName() + " ");;
        }
        System.out.println("");
        System.out.print("copyobjectList: ");
        for (int i = 0; i < copyobjectList.size(); i++) {
            System.out.print(copyobjectList.get(i).getName() + " ");;
        }
    }


}

class CustBook {

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;

    CustBook() {
    }

    public CustBook(String name) {
        this.name = name;
    }
}
