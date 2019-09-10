package com.annotation;

public class TestNum {

    public static boolean isCheck(int num) {
        return (num & (num -1)) == 0;
    }

    public static void main(String[] args) {

//        System.out.println("args = [" + isCheck(19) + "]");


        Integer i = new Integer(20);
        Integer j = Integer.valueOf(20);
        Integer k = 20;
        int s = 20;




        System.out.println("args = i.equals(j)[" + (i.equals(j)) + "]");
        System.out.println("args = i == k[" + (i == k) + "]");
        System.out.println("args = j == k[" + (j == k) + "]");
//        System.out.println("args = j == s[" + (j == s) + "]");

    }
}
