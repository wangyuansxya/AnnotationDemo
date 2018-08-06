package com.wangyuan.myopensourcelibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.annotation.compile.define.Friut;
import com.annotation.compile.define.FriutName;
import com.annotation.compile.define.FriutProvider;

public class AnnotationActivity extends Activity {


    @FriutName("苹果")
    public String name;

    @Friut(fruitColor = Friut.Color.BLUE)
    public String color1;

    @FriutProvider(id = 2, name = "陕西洛川苹果", address = "陕西洛川")
    public String provider;

    Button mBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.button1);
        mBtn.setText(name);
    }
}
