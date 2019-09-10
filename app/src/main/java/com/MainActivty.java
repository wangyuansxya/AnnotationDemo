package com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.jni.JniActivity;
import com.mvp.ui.UserActivity;
import com.annotation.AnnotationActivity;
import com.touch.one.TouchOneActivity;
import com.touch.one.ViewPagerActivity;
import com.touch.two.TouchTwoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivty extends Activity implements AdapterView.OnItemClickListener{

    @BindView(R.id.lv_demo_list)
    ListView mDemoList;

    private static final String[] ARR = {"MVP测试", "自定义注解测试", "JNI", "TOUCH", "ViewPager", "TOUCH2"};
    private static final Class<?>[] ACTIVITIES = {UserActivity.class, AnnotationActivity.class, JniActivity.class, TouchOneActivity.class, ViewPagerActivity.class, TouchTwoActivity.class};

    private static final SparseArray<Class<?>> MAP = new SparseArray<>();
    static {
        final int len = ACTIVITIES.length;
        for (int i = 0; i < len; i++) {
            MAP.put(i, ACTIVITIES[i]);
        }
    }

    NetworkConnectHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDemoList.setAdapter(new ArrayAdapter<>(getApplicationContext(),  R.layout.item_main, R.id.button_item, ARR));
        mDemoList.setOnItemClickListener(this);
        helper = new NetworkConnectHelper();
        helper.registerHeadsetPlugReceiver(this, null);
    }

    private void startActivity(Class<?> cls) {
        Intent i = new Intent(this, cls);
        startActivity(i);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(ACTIVITIES[i]);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.unRegisterHeadsetPlugReceiver(this, null);
    }
}
