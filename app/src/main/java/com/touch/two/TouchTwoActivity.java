package com.touch.two;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.R;
import com.touch.one.MyFragment;
import com.touch.one.MyViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TouchTwoActivity extends AppCompatActivity {


    private MyViewPager mViewPager;

    @BindView(R.id.lv_touch)
    ListView mLvTouch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        ButterKnife.bind(this);

    }
}
