package com.touch.one;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TouchOneActivity extends AppCompatActivity {


    private MyViewPager mViewPager;

    @BindView(R.id.lv_touch)
    ListView mLvTouch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        ButterKnife.bind(this);

        final String[] arr = {"A", "B", "C"};
        View v = LayoutInflater.from(this).inflate(R.layout.activity_touch_viewpager, mLvTouch, false);
        mViewPager = v.findViewById(R.id.vp_pager);
//
        final MyFragment[] fs = {new MyFragment(), new MyFragment(), new MyFragment()};

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                MyFragment f = fs[position];
                Bundle b = new Bundle();
                b.putString("A", arr[position]);
                f.setArguments(b);
                return f;
            }

            @Override
            public int getCount() {
                return arr.length;
            }
        });

        mLvTouch.addHeaderView(v);
        mLvTouch.setAdapter(new ArrayAdapter<String>(this, R.layout.item_main,
                R.id.button_item, new String[] {"01", "02", "03", "04","01", "02", "03", "04", "01", "02", "03", "04","01", "02", "03", "04"}));
    }
}
