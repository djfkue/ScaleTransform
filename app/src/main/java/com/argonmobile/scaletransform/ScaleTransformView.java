package com.argonmobile.scaletransform;

import android.content.Context;
import android.content.res.TypedArray;
import android.gesture.GestureOverlayView;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;


public class ScaleTransformView extends FrameLayout {
    private static final String TAG = "ScaleTransformView";

    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    private boolean mIsTrigging = false;

    private ScaleGestureDetector mScaleGestureDetector;

    public ScaleTransformView(Context context) {
        super(context);
        init(null, 0);
    }

    public ScaleTransformView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);

        // Sets up interactions
        Log.e(TAG, "init scale gesture detector");
        mScaleGestureDetector = new ScaleGestureDetector(context, mScaleGestureListener);
        mScaleGestureDetector.setQuickScaleEnabled(true);
    }

    public ScaleTransformView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.ScaleTransformView, defStyle, 0);

        mExampleString = a.getString(
                R.styleable.ScaleTransformView_exampleString);
        mExampleColor = a.getColor(
                R.styleable.ScaleTransformView_exampleColor,
                mExampleColor);
        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
        // values that should fall on pixel boundaries.
        mExampleDimension = a.getDimension(
                R.styleable.ScaleTransformView_exampleDimension,
                mExampleDimension);

        if (a.hasValue(R.styleable.ScaleTransformView_exampleDrawable)) {
            mExampleDrawable = a.getDrawable(
                    R.styleable.ScaleTransformView_exampleDrawable);
            mExampleDrawable.setCallback(this);
        }

        a.recycle();

        // Set up a default TextPaint object
        mTextPaint = new TextPaint();
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextAlign(Paint.Align.LEFT);

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {
        mTextPaint.setTextSize(mExampleDimension);
        mTextPaint.setColor(mExampleColor);
        mTextWidth = mTextPaint.measureText(mExampleString);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        mTextHeight = fontMetrics.bottom;
    }

    private boolean checkGestureTrigger(MotionEvent ev) {
        if (MotionEventCompat.getPointerCount(ev) >= 2 && MotionEventCompat.getPointerCount(ev) <= 6) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean dispatchTouchEvent (MotionEvent ev) {

        if (checkGestureTrigger(ev)) {
            mIsTrigging = true;
        } else {
            mIsTrigging = false;
        }

        boolean retValue = mScaleGestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev) || retValue;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        // Draw the text.
        canvas.drawText(mExampleString,
                paddingLeft + (contentWidth - mTextWidth) / 2,
                paddingTop + (contentHeight + mTextHeight) / 2,
                mTextPaint);

        // Draw the example drawable on top of the text.
        if (mExampleDrawable != null) {
            mExampleDrawable.setBounds(paddingLeft, paddingTop,
                    paddingLeft + contentWidth, paddingTop + contentHeight);
            mExampleDrawable.draw(canvas);
        }
    }

    /**
     * Gets the example string attribute value.
     *
     * @return The example string attribute value.
     */
    public String getExampleString() {
        return mExampleString;
    }

    /**
     * Sets the view's example string attribute value. In the example view, this string
     * is the text to draw.
     *
     * @param exampleString The example string attribute value to use.
     */
    public void setExampleString(String exampleString) {
        mExampleString = exampleString;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example color attribute value.
     *
     * @return The example color attribute value.
     */
    public int getExampleColor() {
        return mExampleColor;
    }

    /**
     * Sets the view's example color attribute value. In the example view, this color
     * is the font color.
     *
     * @param exampleColor The example color attribute value to use.
     */
    public void setExampleColor(int exampleColor) {
        mExampleColor = exampleColor;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example dimension attribute value.
     *
     * @return The example dimension attribute value.
     */
    public float getExampleDimension() {
        return mExampleDimension;
    }

    /**
     * Sets the view's example dimension attribute value. In the example view, this dimension
     * is the font size.
     *
     * @param exampleDimension The example dimension attribute value to use.
     */
    public void setExampleDimension(float exampleDimension) {
        mExampleDimension = exampleDimension;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example drawable attribute value.
     *
     * @return The example drawable attribute value.
     */
    public Drawable getExampleDrawable() {
        return mExampleDrawable;
    }

    /**
     * Sets the view's example drawable attribute value. In the example view, this drawable is
     * drawn above the text.
     *
     * @param exampleDrawable The example drawable attribute value to use.
     */
    public void setExampleDrawable(Drawable exampleDrawable) {
        mExampleDrawable = exampleDrawable;
    }

    /**
     * The scale listener, used for handling multi-finger scale gestures.
     */
    private final ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener
            = new ScaleGestureDetector.SimpleOnScaleGestureListener() {

        private float mScale;

        public boolean onScale(ScaleGestureDetector detector) {
            if (mIsTrigging) {
                mScale *= detector.getScaleFactor();
                Log.e(TAG, "onScale: " + mScale);
                return true;
            } else {
                return false;
            }
        }

        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Log.e(TAG, "onScaleBegin");
            mScale = detector.getScaleFactor();
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector detector) {
            // Intentionally empty
            mScale = Float.NaN;
            Log.e(TAG, "onScaleEnd");
        }
    };
}
