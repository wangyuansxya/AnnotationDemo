package com.touch.one;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity {


    @BindView(R.id.vp_pager)
    MyViewPager mViewPager;

    final String[] arr = {"A", "B", "C"};

    final MyFragment[] fs = {new MyFragment(), new MyFragment(), new MyFragment()};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_viewpager);
        ButterKnife.bind(this);
//        View v = LayoutInflater.from(this).inflate(R.layout.activity_touch_viewpager, null);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                MyFragment f = fs[position];
//                Bundle b = new Bundle();
//                b.putString("A", arr[position]);
//                f.setArguments(b);
                return f;
            }

            @Override
            public int getCount() {
                return arr.length;
            }
        });
    }
}
