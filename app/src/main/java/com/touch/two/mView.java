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
        Log.e(TouchTwoActivity.TAG, "mView.dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TouchTwoActivity.TAG, "mView.onTouchEvent");
        return super.onTouchEvent(event);
    }
}
