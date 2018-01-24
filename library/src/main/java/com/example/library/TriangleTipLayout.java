package com.example.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 带三角形指示器
 *
 * @author 黄兴伟 (xwdz9989@gamil.com)
 * @since 17-11-27
 */
public class TriangleTipLayout extends LinearLayout {

    private static final int DEFAULT_TOP_HEIGHT = 15;
    private View mTarget;
    private Paint mBitmapPaint;
    private Paint mRectPaint;
    private Bitmap mBitmap;
    private TextView mTextView;
    private boolean mIsShowTriangle = true;
    private int mGravity;

    private Rect mRect = new Rect();

    public TriangleTipLayout(Context context) {
        this(context, null);
    }

    public TriangleTipLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TriangleTipLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
        View.inflate(getContext(), R.layout.layout_triangle, this);
        setBackgroundColor(Color.WHITE);
        setGravity(Gravity.CENTER_HORIZONTAL);
        mTextView = findViewById(R.id.text_ratio);

        mBitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectPaint = new Paint();

        mBitmapPaint.setColor(Color.parseColor("#999999"));
        mBitmapPaint.setStyle(Paint.Style.FILL);
        mRectPaint.setColor(Color.parseColor("#EEEEEE"));
        mRectPaint.setStyle(Paint.Style.FILL);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_triangle_arrow);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final TextPaint textPaint = mTextView.getPaint();
        final int textHeight = (int) (textPaint.descent() - textPaint.ascent());
        mRect.set(0, DEFAULT_TOP_HEIGHT, getWidth(), getHeight() + textHeight - DEFAULT_TOP_HEIGHT);
        canvas.drawRect(mRect, mRectPaint);
        final String text = mTextView.getText().toString();
        float left = 0;
        if (mIsShowTriangle) {
            if (mGravity == Gravity.LEFT || mGravity == Gravity.START) {
                LayoutParams layoutParams = (LayoutParams) mTarget.getLayoutParams();
                left = mTarget.getLeft() - layoutParams.rightMargin - layoutParams.leftMargin;
            } else {
                final float width = mTarget.getWidth();
                if (mTarget instanceof TextView) {
                    ViewParent viewParent = mTarget.getParent();
                    float textWidth = textPaint.measureText(text);
                    if (viewParent instanceof LinearLayout) {
                        left = mTarget.getLeft() + width / 2 - (mBitmap.getWidth() / 2);
                    } else if (viewParent instanceof RelativeLayout) {
                        left = mTarget.getLeft() + textWidth / 2;
                    }
                } else {
                    left = mTarget.getLeft() + (width / 2) - (mBitmap.getWidth() / 2);
                }
            }
            canvas.drawBitmap(mBitmap, left, 0, mBitmapPaint);
        }
    }

    public void setTextColor(@ColorInt int color) {
        mTextView.setTextColor(color);
    }

    public void setRectBackgroundColor(@ColorInt int color) {
        mRectPaint.setColor(color);
    }


    public void bindView(View view) {
        this.mTarget = view;
    }

    public void setText(String text) {
        mTextView.setText(text);
        invalidate();
    }

    public void setTriangleGravity(int gravity) {
        mGravity = gravity;
    }

    public void setTriangleBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    public void setIsShowTriangle(boolean showTriangle) {
        mIsShowTriangle = showTriangle;
    }
}
