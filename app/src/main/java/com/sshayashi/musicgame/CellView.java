package com.sshayashi.musicgame;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * TODO: document your custom view class.
 */
public class CellView extends View {
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

        mText = a.getString(R.styleable.CellView_text);
        int b = a.getInt(R.styleable.CellView_num,0);
        a.recycle();
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
