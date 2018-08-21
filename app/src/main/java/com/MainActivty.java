package com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mvp.ui.UserActivity;
import com.annotation.AnnotationActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivty extends Activity implements AdapterView.OnItemClickListener{

    @BindView(R.id.lv_demo_list)
    ListView mDemoList;

    String[] ARR = {"MVP测试", "自定义注解测试"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDemoList.setAdapter(new ArrayAdapter<>(getApplicationContext(),  R.layout.item_main, R.id.button_item, ARR));
        mDemoList.setOnItemClickListener(this);
    }

    private void startActivity(Class<?> cls) {
        Intent i = new Intent(this, cls);
        startActivity(i);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                startActivity(UserActivity.class);
                break;
            case 1:
                startActivity(AnnotationActivity.class);
                break;
            default:
                break;
        }
    }
}
