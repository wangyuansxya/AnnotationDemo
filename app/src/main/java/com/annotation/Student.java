package com.annotation;


import com.annotation.run.define.User;

/**
 * Created by 51talk on 2018/4/18.
 */
@User({"aaa", "vvvv"})
/*@FriutName("name")*/
public class Student {

    public String name;

    public int age;

    public String[] courseNameList;

    public static Student parse() {
        Student student = new Student();
        student.name = "小明";
        student.age = 10;
        student.courseNameList = new String[]{"语文", "数学", "英语"};
        return student;
    }

    @User({"A", "B","C"})
    public String carColor;

}
