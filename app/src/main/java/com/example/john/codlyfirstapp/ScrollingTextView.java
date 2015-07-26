package com.example.john.codlyfirstapp;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by john on 4/6/2015.
 */
public class ScrollingTextView extends TextView {

    public ScrollingTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ScrollingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollingTextView(Context context) {
        super(context);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if(focused)
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override
    public void onWindowFocusChanged(boolean focused) {
        if(focused)
            super.onWindowFocusChanged(focused);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
        params.width = w;
        params.height = h;
        params.weight = 0;
        setLayoutParams(params);
    }

}
