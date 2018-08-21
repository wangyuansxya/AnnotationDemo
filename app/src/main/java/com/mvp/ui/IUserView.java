package com.mvp.ui;


/**
 * 再来看看View接口：
 根据需求可知，View可以对ID、FirstName、LastName这三个EditText进行读操作，
 对FirstName和LastName进行写操作，由此定义IUserView接口：
 */
public interface IUserView {
    int getId();
    String getFristName();
    String getLastName();

    void setFirstName (String firstName);
    void setLastName (String lastName);

}
