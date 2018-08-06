package com.annotation.run;

import com.annotation.compile.define.Friut;

public class FruitRun {

    public static void main(String[] args) {
        //System.out.println("Apple = [" + new Apple() + "]");
        //运行时注解
        FruitInfoUtil.getFruitInfo(Apple.class);
        System.out.println("args = [" + Friut.class.getName() + "]");

    }
}
