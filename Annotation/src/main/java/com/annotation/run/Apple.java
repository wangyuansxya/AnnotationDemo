package com.annotation.run;


import com.annotation.run.define.Friut;
import com.annotation.run.define.FriutName;
import com.annotation.run.define.FriutProvider;

public class Apple {

    @FriutName("苹果")
    public String name;

    @Friut(fruitColor = Friut.Color.GREEN)
    public String color;

    @FriutProvider(id = 2, name = "陕西洛川苹果", address = "陕西洛川")
    public String provider;

    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }

}
