package com.argonmobile.scaletransform;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";

    private static final int STATUS_HODE_ON = 0x01;
    private static final int STATUS_SELECTING = 0x02;
    private static final int STATUS_SELECTED = 0x03;

    private static final int DURATION = 1000;
    private SeekBar mSeekBar;

    private View mAnimationViewOne;
    private View mAnimationViewTwo;
    private View mAnimationViewThree;
    private View mAnimationViewFour;
    private View mAnimationViewFive;

    private View mBackgroundView;

    private ScaleTransformView mScaleTransformView;
    private float mScaleFactor = 1.0f;

    private int mStatus = STATUS_HODE_ON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.sample_scale_transform_view);

        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mSeekBar.setMax(DURATION);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e(TAG, "progress: " + progress / 1000.0f);
                mAnimationViewOne.setTranslationX(-mAnimationViewOne.getWidth() * (1 - progress / 1000.0f));
                mAnimationViewOne.setTranslationY(-mAnimationViewOne.getHeight() * (1 - progress / 1000.0f));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mAnimationViewOne = findViewById(R.id.animation_view_1);
        mAnimationViewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStatus == STATUS_SELECTING) {
                    mAnimationViewOne.bringToFront();
                    mAnimationViewOne.animate().x((mScaleTransformView.getWidth() - mAnimationViewOne.getWidth()) / 2)
                            .y((mScaleTransformView.getHeight() - mAnimationViewOne.getHeight()) / 2)
                            .scaleXBy(mScaleTransformView.getWidth() / mAnimationViewOne.getWidth())
                            .scaleYBy(mScaleTransformView.getHeight() / mAnimationViewOne.getHeight())
                            .withLayer()
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    mStatus = STATUS_SELECTED;
                                }
                            });

                }

                if (mStatus == STATUS_SELECTED) {
                    resetAllViewFromClick(v);
                }
            }
        });

        mAnimationViewTwo = findViewById(R.id.animation_view_2);

        mAnimationViewTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStatus == STATUS_SELECTING) {
                    mAnimationViewTwo.bringToFront();
                    mAnimationViewTwo.animate().x((mScaleTransformView.getWidth() - mAnimationViewOne.getWidth()) / 2)
                            .y((mScaleTransformView.getHeight() - mAnimationViewOne.getHeight()) / 2)
                            .scaleXBy(mScaleTransformView.getWidth() / mAnimationViewOne.getWidth())
                            .scaleYBy(mScaleTransformView.getHeight() / mAnimationViewOne.getHeight())
                            .withLayer()
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    mStatus = STATUS_SELECTED;
                                }
                            });

                }

                if (mStatus == STATUS_SELECTED) {
                    resetAllViewFromClick(v);
                }
            }
        });

        mAnimationViewThree = findViewById(R.id.animation_view_3);
        mAnimationViewThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStatus == STATUS_SELECTING) {
                    mAnimationViewThree.bringToFront();
                    mAnimationViewThree.animate().x((mScaleTransformView.getWidth() - mAnimationViewThree.getWidth()) / 2)
                            .y((mScaleTransformView.getHeight() - mAnimationViewThree.getHeight()) / 2)
                            .scaleXBy(mScaleTransformView.getWidth() / mAnimationViewThree.getWidth())
                            .scaleYBy(mScaleTransformView.getHeight() / mAnimationViewThree.getHeight())
                            .withLayer()
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    mStatus = STATUS_SELECTED;
                                }
                            });

                }

                if (mStatus == STATUS_SELECTED) {
                    resetAllViewFromClick(v);
                }
            }
        });

        mAnimationViewFour = findViewById(R.id.animation_view_4);
        mAnimationViewFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStatus == STATUS_SELECTING) {
                    mAnimationViewFour.bringToFront();
                    mAnimationViewFour.animate().x((mScaleTransformView.getWidth() - mAnimationViewFour.getWidth()) / 2)
                            .y((mScaleTransformView.getHeight() - mAnimationViewFour.getHeight()) / 2)
                            .scaleXBy(mScaleTransformView.getWidth() / mAnimationViewFour.getWidth())
                            .scaleYBy(mScaleTransformView.getHeight() / mAnimationViewFour.getHeight())
                            .withLayer()
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    mStatus = STATUS_SELECTED;
                                }
                            });

                }

                if (mStatus == STATUS_SELECTED) {
                    resetAllViewFromClick(v);
                }
            }
        });

        mAnimationViewFive = findViewById(R.id.animation_view_5);
        mAnimationViewFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStatus == STATUS_SELECTING) {
                    mAnimationViewFive.bringToFront();
                    mAnimationViewFive.animate().x((mScaleTransformView.getWidth() - mAnimationViewFive.getWidth()) / 2)
                            .y((mScaleTransformView.getHeight() - mAnimationViewFive.getHeight()) / 2)
                            .scaleXBy(mScaleTransformView.getWidth() / mAnimationViewFive.getWidth())
                            .scaleYBy(mScaleTransformView.getHeight() / mAnimationViewFive.getHeight())
                            .withLayer()
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    mStatus = STATUS_SELECTED;
                                }
                            });

                }

                if (mStatus == STATUS_SELECTED) {
                    resetAllViewFromClick(v);
                }
            }
        });

        mScaleTransformView = (ScaleTransformView) findViewById(R.id.gesture_view_container);
        mScaleTransformView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                mScaleTransformView.getViewTreeObserver().removeOnPreDrawListener(this);
                Log.e(TAG, "width before scale: " + mAnimationViewOne.getWidth());
                mAnimationViewOne.setX(mScaleTransformView.getLeft()-mAnimationViewOne.getWidth());
                mAnimationViewOne.setY(mScaleTransformView.getTop()-mAnimationViewOne.getHeight());
                Log.e(TAG, "width after scale: " + mAnimationViewOne.getWidth());

                mAnimationViewTwo.setX(mScaleTransformView.getLeft()-mAnimationViewTwo.getWidth());
                mAnimationViewTwo.setY(mScaleTransformView.getTop()-mAnimationViewTwo.getHeight());

                mAnimationViewThree.setTranslationX(mScaleTransformView.getLeft());
                mAnimationViewThree.setTranslationY(mScaleTransformView.getBottom());

                mAnimationViewFour.setTranslationY(mScaleTransformView.getBottom());

                mAnimationViewFive.setTranslationX(mScaleTransformView.getRight());
                mAnimationViewFive.setTranslationY(mScaleTransformView.getBottom());

                mBackgroundView.setAlpha(0.0f);

                return true;
            }
        });

        mScaleTransformView.setOnScaleListener(new ScaleTransformView.OnScaleListener() {
            @Override
            public void onScaleBegin() {
                if (mStatus == STATUS_SELECTING || mStatus == STATUS_SELECTED) {
                    return;
                }
                mScaleFactor = 1.0f;
                mAnimationViewOne.setScaleX(1.0f);
                mAnimationViewOne.setScaleY(1.0f);

                mAnimationViewTwo.setScaleX(1.0f);
                mAnimationViewTwo.setScaleY(1.0f);

                mAnimationViewThree.setScaleX(1.0f);
                mAnimationViewThree.setScaleY(1.0f);

                mAnimationViewFour.setScaleX(1.0f);
                mAnimationViewFour.setScaleY(1.0f);

                mAnimationViewFive.setScaleX(1.0f);
                mAnimationViewFive.setScaleY(1.0f);

                mBackgroundView.animate().alpha(1.0f).withLayer();
            }

            @Override
            public void onScale(float scaleFactor) {

                if (mStatus == STATUS_SELECTING || mStatus == STATUS_SELECTED) {
                    return;
                }

                if (scaleFactor > 1) {
                    return;
                }
                if (scaleFactor < 0.6f) {
                    scaleFactor *= scaleFactor;
                }
                mScaleFactor *= scaleFactor;
                mAnimationViewOne.setTranslationX(-mAnimationViewOne.getWidth() * mScaleFactor + mAnimationViewOne.getPaddingLeft());
                mAnimationViewOne.setTranslationY(-mAnimationViewOne.getHeight() * mScaleFactor);

                mAnimationViewTwo.setTranslationX(mAnimationViewTwo.getWidth() * mScaleFactor + mAnimationViewTwo.getPaddingRight());
                mAnimationViewTwo.setTranslationY(-mAnimationViewTwo.getHeight() * mScaleFactor);

                mAnimationViewThree.setTranslationX(-mAnimationViewThree.getWidth() * mScaleFactor + mAnimationViewThree.getPaddingLeft());
                mAnimationViewThree.setTranslationY(mAnimationViewThree.getHeight() * mScaleFactor);

                mAnimationViewFour.setTranslationY(mAnimationViewFour.getHeight() * mScaleFactor);

                mAnimationViewFive.setTranslationX(mAnimationViewFive.getWidth() * mScaleFactor + mAnimationViewFive.getPaddingRight());
                mAnimationViewFive.setTranslationY(mAnimationViewFive.getHeight() * mScaleFactor);
                Log.d(TAG, " mScaleFactor: " + mScaleFactor);
            }

            @Override
            public void onScaleEnd() {
                if (mStatus == STATUS_SELECTING || mStatus == STATUS_SELECTED) {
                    return;
                }
                final float scale = getResources().getDisplayMetrics().density;
                if (mScaleFactor > 0.7f && mScaleFactor < 1.0f) {

                    mAnimationViewOne.animate().x(15 * scale).y(15 * scale).withLayer();
                    mAnimationViewTwo.animate().x( mScaleTransformView.getWidth() - mAnimationViewTwo.getWidth() - 15 * scale).y(15*scale).withLayer();

                    mAnimationViewThree.animate().x(30 * scale).y(mScaleTransformView.getHeight() - mAnimationViewThree.getHeight() - 30 * scale).withLayer();

                    mAnimationViewFour.animate().y(mScaleTransformView.getHeight() - mAnimationViewFour.getHeight() - 30 * scale).withLayer();

                    mAnimationViewFive.animate().x(mScaleTransformView.getWidth() - mAnimationViewFive.getWidth() - 30 * scale)
                            .y(mScaleTransformView.getHeight() - mAnimationViewFive.getHeight() - 30 * scale).withLayer();

                    mStatus = STATUS_SELECTING;
                } else {
                    mAnimationViewOne.bringToFront();
                    mAnimationViewOne.animate().x((mScaleTransformView.getWidth() - mAnimationViewOne.getWidth()) / 2)
                            .y((mScaleTransformView.getHeight() - mAnimationViewOne.getHeight()) / 2)
                            .scaleXBy(mScaleTransformView.getWidth() / mAnimationViewOne.getWidth())
                            .scaleYBy(mScaleTransformView.getHeight() / mAnimationViewOne.getHeight()).withLayer();

                    mAnimationViewTwo.animate().x( mScaleTransformView.getWidth() - mAnimationViewTwo.getWidth() - 15 * scale).y(15*scale).withLayer();
                    mAnimationViewThree.animate().x(30 * scale).y(mScaleTransformView.getHeight() - mAnimationViewThree.getHeight() - 30 * scale).withLayer();
                    mAnimationViewFour.animate().y(mScaleTransformView.getHeight() - mAnimationViewFour.getHeight() - 30 * scale).withLayer();
                    mAnimationViewFive.animate().x(mScaleTransformView.getWidth() - mAnimationViewFive.getWidth() - 30 * scale)
                            .y(mScaleTransformView.getHeight() - mAnimationViewFive.getHeight() - 30 * scale).withLayer();
                    mStatus = STATUS_SELECTED;
                }
            }
        });

        mBackgroundView = findViewById(R.id.background_view);
    }

    private void resetAllViewFromClick(View view) {
//        if (view != mAnimationViewOne) {
//            mAnimationViewOne.setX(mScaleTransformView.getLeft() + mAnimationViewOne.getWidth());
//            mAnimationViewOne.setY(mAnimationViewOne.getHeight());
//        }
//
//        if (view != mAnimationViewTwo) {
//            mAnimationViewTwo.setX(mScaleTransformView.getRight() - mAnimationViewOne.getWidth());
//            mAnimationViewTwo.setY(mAnimationViewOne.getHeight());
//        }

        mAnimationViewOne.animate().x(-mAnimationViewOne.getWidth())
                .y(-mAnimationViewOne.getHeight())
                .scaleX(1.0f)
                .scaleY(1.0f)
                .withLayer().setDuration(600).withEndAction(new Runnable() {
            @Override
            public void run() {
                mStatus = STATUS_HODE_ON;
            }
        });

        mAnimationViewTwo.animate().x(mScaleTransformView.getRight())
                .y(-mAnimationViewTwo.getHeight())
                .scaleX(1.0f)
                .scaleY(1.0f)
                .withLayer().setDuration(600).withEndAction(new Runnable() {
            @Override
            public void run() {
                mStatus = STATUS_HODE_ON;
            }
        });

        mAnimationViewThree.animate().x(mScaleTransformView.getLeft() - mAnimationViewThree.getWidth())
                .y(mScaleTransformView.getHeight())
                .scaleX(1.0f)
                .scaleY(1.0f)
                .withLayer().setDuration(600).withEndAction(new Runnable() {
            @Override
            public void run() {
                mStatus = STATUS_HODE_ON;
            }
        });

        mAnimationViewFour.animate().y(mScaleTransformView.getHeight())
                .scaleX(1.0f)
                .scaleY(1.0f)
                .withLayer().setDuration(600).withEndAction(new Runnable() {
            @Override
            public void run() {
                mStatus = STATUS_HODE_ON;
            }
        });

        mAnimationViewFive.animate().x(mScaleTransformView.getRight())
                .y(mScaleTransformView.getHeight())
                .scaleX(1.0f)
                .scaleY(1.0f)
                .withLayer().setDuration(600).withEndAction(new Runnable() {
            @Override
            public void run() {
                mStatus = STATUS_HODE_ON;

                mBackgroundView.animate().alpha(0).withLayer();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
