package com.annotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCompare {

    public static void main(String[] args) {

        Comparable comparable = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

//        Comparable
//        Comparator
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(3);
        l.add(2);
        l.add(8);
        l.add(3);
        l.add(9);

        Collections.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 - o2 > 0) {
                    return -1;
                } else if(o1 - o2 < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for ( Integer i: l) {
            System.out.println("args = [" + i + "]");
        }
    }

}
