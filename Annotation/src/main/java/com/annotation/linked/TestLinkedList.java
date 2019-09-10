package com.annotation.linked;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestLinkedList {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> it = list.iterator();

//        while (it.hasNext()) {
//            System.out.println("args = [" + it.next() + "]");
//        }

//        Collections.reverse(list);
        reverse(list);

        /*for (int i = 0; i < list.size(); i++) {
            System.out.println("args = [" + list.get(i) + "]");
        }*/
        ListIterator<Integer> lit = list.listIterator(list.size());
        while (lit.hasNext()) {
            lit.remove();
        }

        lit.add(7);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("args = [" + list.get(i) + "]");
//        }

        //byte max value =
        //0000 0010 2
        //1000 0010 -2ø

        //>>>无符号右移
        //>>有符号右移

        //int 类型一共是32位
        //long 类型是64位
        //float类型也是32位
        //double类型是62位

        int low = -2;
        System.out.println("args = [" + (low >>> 1) + "]");


        System.out.println("max = [" + Integer.MAX_VALUE + "]");

    }


    private static void reverse(List<Integer> list) {
        ListIterator<Integer> pre = list.listIterator();
        ListIterator<Integer> end = list.listIterator(list.size());

        int mid = list.size()>>1;

        for (int i = 0; i < mid; i++) {
            Integer temp = pre.next();
//            System.out.println("temp = [" + temp + "]");
            Integer e = end.previous();
//            System.out.println("e = [" + e + "]");
            pre.set(e);
            end.set(temp);
        }
    }


}
