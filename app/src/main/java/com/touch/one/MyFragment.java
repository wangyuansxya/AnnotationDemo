package com.touch.one;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.R;

public class MyFragment extends Fragment {

    private TextView mTvText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_touch_viewpager_item, container, false);
        mTvText = v.findViewById(R.id.tv_text);
        mTvText.setText(getArguments().getString("A"));
        return v;
    }


    /*public void setData(String s) {
        mTvText.setText(s);
    }*/

}
