package com.touch.two;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class mView extends AppCompatTextView {
    public mView(Context context) {
        super(context);
    }

    public mView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public mView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.e(TouchTwoActivity.TAG, "mView.dispatchTouchEvent");
        Log.e(TouchTwoActivity.TAG, "mView.dispatchTouchEvent  acton = " + event.getAction());

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Log.e(TouchTwoActivity.TAG, "mView.onTouchEvent");
        Log.e(TouchTwoActivity.TAG, "mView.onTouchEvent  acton = " + event.getAction());

        return super.onTouchEvent(event);
    }
}
