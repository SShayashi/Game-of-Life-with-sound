package com.sshayashi.musicgame;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatButton;
import android.widget.Checkable;

/**
 * TODO: document your custom view class.
 */
public class CellView extends AppCompatButton implements Checkable {
    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};
    boolean checked;
    int INDEX_X = 0;
    int INDEX_Y = 0;

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
}
