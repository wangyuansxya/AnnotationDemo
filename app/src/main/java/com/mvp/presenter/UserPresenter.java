package com.mvp.presenter;

import com.mvp.model.IUserModel;
import com.mvp.model.UserBean;
import com.mvp.ui.IUserView;

/**
 * Presenter就能通过接口与View及Model进行交互了：
 */
public class UserPresenter {

    private IUserView mUserView;
    private IUserModel mUserModel;

    public UserPresenter(IUserView view) {
        mUserView = view;
        mUserModel = new UserBean();
    }

    public void saveUser(int id, String firstName, String lastName) {
        mUserModel.setID (id);
        mUserModel.setFirstName(firstName);
        mUserModel.setLastName(lastName);
    }

    public void loadUser( int id) {
        UserBean user = mUserModel.load(id);
        mUserView.setFirstName(user.mFirstName);//通过调用IUserView的方法来更新显示
        mUserView.setLastName(user.mLastName);
    }


}
