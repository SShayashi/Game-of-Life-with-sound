package com.sshayashi.musicgame;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.AppCompatButton;
import android.view.ViewGroup;

import com.google.android.gms.plus.PlusOneButton;


/**
 * TODO: document your custom view class.
 */
public class CellView extends AppCompatButton {
    private String mText = "";
    int INDEX_X = 0;
    int INDEX_Y = 0;
    private float mTextWidth;
    private float mTextHeight;

//    // TODO: Rename and change types and number of parameters
//    public static CellView newInstance(Context context, int param1, int param2) {
//        CellView cell = new CellView(context);
//        cell.INDEX_X = param1;
//        cell.INDEX_Y = param2;
////        Bundle args = new Bundle();
////        args.putString(X, param1);
////        args.putString(Y, param2);
//        return cell;
//    }

    public CellView(Context context) {
        this(context,null);
    }

    public CellView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.buttonStyle);
    }

    public CellView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.CellView , defStyle, 0);
        a.recycle();


        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Cell View","button clicked");
                int i =v.getId();
                Object a = v.getTag();
                Log.i("Clicked", ""+v.getId());
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
