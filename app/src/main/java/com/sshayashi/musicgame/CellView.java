package com.sshayashi.musicgame;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.AppCompatButton;


/**
 * TODO: document your custom view class.
 */
public class CellView extends AppCompatButton {
    private String mText = ""; // TODO: use a default from R.string...
    private float mTextWidth;
    private float mTextHeight;

    public CellView(Context context) {
        this(context,null);
    }

    public CellView(Context context, AttributeSet attrs) {
        this(context, attrs, R.layout.cell_view);
    }

    public CellView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {

        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.CellView , defStyle, 0);
//        mText = a.getString(R.styleable.CellView_text);
//        int b = a.getInt(R.styleable.CellView_num,0);
        a.recycle();

        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Cell View","button clicked");
            }
        };
        this.setOnClickListener(listener);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }



    public String getExampleString() {
        return mText;
    }

    public void setExampleString(String exampleString) {
        mText = exampleString;
    }
}
