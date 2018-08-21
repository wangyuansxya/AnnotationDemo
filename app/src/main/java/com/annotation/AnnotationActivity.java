package com.annotation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;

import com.R;
import com.annotation.compile.define.Friut;
import com.annotation.compile.define.FriutName;
import com.annotation.compile.define.FriutProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnnotationActivity extends Activity {


    @FriutName("苹果")
    public String name;

    @Friut(fruitColor = Friut.Color.BLUE)
    public String color1;

    @FriutProvider(id = 2, name = "陕西洛川苹果", address = "陕西洛川")
    public String provider;

    @BindView(R.id.iv_bitmap)
    ImageView mIvBitmap;
    @BindView(R.id.button1)
    Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annoation);
        ButterKnife.bind(this);

        mBtn.setText(name);
    }
}
