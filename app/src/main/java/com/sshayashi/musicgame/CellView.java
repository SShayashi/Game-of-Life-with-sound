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
import android.view.MotionEvent;
import android.view.View;
import android.support.v7.widget.AppCompatButton;
import android.view.ViewGroup;
import android.widget.Checkable;

import com.google.android.gms.plus.PlusOneButton;


/**
 * TODO: document your custom view class.
 */
public class CellView extends AppCompatButton implements Checkable {
    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};
    boolean checked;
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

        OnTouchListener oListener = (new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // show interest in events resulting from ACTION_DOWN
                if (event.getAction() == MotionEvent.ACTION_DOWN) return true;
                // don't handle event unless its ACTION_UP so "doSomething()" only runs once.
                if (event.getAction() != MotionEvent.ACTION_UP) return false;
                ((CellView)v).toggle();
                return true;
            }
        });

//
//        OnClickListener listener = new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int i =v.getId();
//                ((CellView)v).reverseStatus();
//                Log.i("Clicked", ""+v.getId());
//            }
//        };
        this.setOnTouchListener(oListener);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    public void setChecked(boolean checked) {
        if (this.checked != checked) {
            this.checked = checked;
            refreshDrawableState();
        }
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {
        setChecked(!checked);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    public void reverseStatus(){
//        if(isAlive == 0) {
//            isAlive = 1;
//            this.setSelected(true);
//            this.invalidate();
//        }else if(isAlive ==1) {
//            isAlive = 0;
//            this.setSelected(false);
//            this.invalidate();
//        } else
//            Log.d("error","error");
    }
}
