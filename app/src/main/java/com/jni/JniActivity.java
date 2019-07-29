package com.jni;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JniActivity extends Activity {

    @BindView(R.id.tv_one)
    TextView mTvOne;

    private MathUtils mNI;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni);
        ButterKnife.bind(this);
        mNI = new MathUtils();
        mTvOne.setText(mNI.stringFromJNI("我的测试代码=") + mNI.add(5, 11));

    }
}
