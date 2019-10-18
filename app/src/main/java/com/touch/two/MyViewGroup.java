package com.touch.two;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyViewGroup extends LinearLayout {
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.e(TouchTwoActivity.TAG, "MyViewGroup.dispatchTouchEvent");
        Log.e(TouchTwoActivity.TAG, "MyViewGroup.dispatchTouchEvent  acton = " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.e(TouchTwoActivity.TAG, "MyViewGroup.onInterceptTouchEvent");
        Log.e(TouchTwoActivity.TAG, "MyViewGroup.onInterceptTouchEvent  acton = " + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Log.e(TouchTwoActivity.TAG, "MyViewGroup.onTouchEvent");
        Log.e(TouchTwoActivity.TAG, "MyViewGroup.onTouchEvent  acton = " + event.getAction());

        return super.onTouchEvent(event);
    }
}
