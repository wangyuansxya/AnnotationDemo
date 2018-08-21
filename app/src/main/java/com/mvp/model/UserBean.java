package com.mvp.model;

/**
 * 首先我们需要一个UserBean，用来保存用户信息
 */
public class UserBean implements IUserModel {

    public int id;
    public String mFirstName ;
    public String mLastName ;

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public UserBean load(int id) {
//        UserBean user = new UserBean();
//        user.setID(5);
//        user.setFirstName("AAAA");
//        user.setLastName("BBBBB");
//        return user;
        if(id == this.id) {
            return this;
        }
        return null;
    }
}
