package com.mvp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.R;
import com.mvp.presenter.UserPresenter;

public class UserActivity extends Activity implements IUserView, View.OnClickListener {
    @Override
    public int getId() {
        return mEtId.getId();
    }

    @Override
    public String getFristName() {
        return mEtFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return mEtLastName.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        mTvFirstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        mTvLastName.setText(lastName);
    }

    EditText mEtId;
    EditText mEtFirstName;
    EditText mEtLastName;

    TextView mTvFirstName;
    TextView mTvLastName;

    Button mBtnSave;

    Button mBtnGet;

    UserPresenter presenter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout root = new LinearLayout(getApplicationContext());
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(0xffffffff);
        root.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        mEtId = new EditText(getApplicationContext());
        mEtId.setId(R.id.tag_sixth);
        root.addView(mEtId);

        mEtFirstName = new EditText(getApplicationContext());
        mEtFirstName.setText("enter you fitst name");
        mEtFirstName.setTextColor(0xff000000);
        mEtFirstName.setId(R.id.tag_first);
        root.addView(mEtFirstName);

        mEtLastName = new EditText(getApplicationContext());
        mEtLastName.setId(R.id.tag_secend);
        mEtLastName.setText("enter you last name");
        mEtLastName.setTextColor(0xff000000);
        root.addView(mEtLastName);

        mTvFirstName = new TextView(getApplicationContext());
        mTvFirstName.setId(R.id.tag_third);
        mTvFirstName.setText("firstName");
        mTvFirstName.setTextColor(0xff000000);
        root.addView(mTvFirstName);

        mTvLastName = new TextView(getApplicationContext());
        mTvLastName.setId(R.id.tag_fourth);
        mTvLastName.setTextColor(0xff000000);
        mTvLastName.setText("firstName");
        root.addView(mTvLastName);

        mBtnSave = new Button(getApplicationContext());
        mBtnSave.setId(R.id.tag_fifth);
        mBtnSave.setText("保存");
        mBtnSave.setOnClickListener(this);
        root.addView(mBtnSave);


        mBtnGet = new Button(getApplicationContext());
        mBtnGet.setId(R.id.tag_seventh);
        mBtnGet.setText("获取");
        mBtnGet.setOnClickListener(this);
        root.addView(mBtnGet);

        setContentView(root);

        presenter = new UserPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tag_fifth:
                presenter.saveUser(getId(), getFristName(), getLastName());
                break;
            case R.id.tag_seventh:
                presenter.loadUser(getId());
                break;
            default:

                break;
        }
    }
}
