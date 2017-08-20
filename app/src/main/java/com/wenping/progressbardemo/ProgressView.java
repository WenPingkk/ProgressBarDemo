package com.wenping.progressbardemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by wenping on 8/20/2017.
 */

public class ProgressView extends RelativeLayout {

    private TextView mProgressTitle;
    private TextView mProgressLeft;
    private TextView mProgressRight;
    private ProgressBar mProgressBar;

    private String mTitle;
    private String mLeftTitle;
    private String mRightText;

    private int mCurrentProgress;
    private int mMaxProgress;

    public ProgressView(Context context) {
        this(context,null);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //1.关联布局控件

        View.inflate(getContext(),R.layout.view_progress_status,this);
        //2,读取属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProgressView);

        mTitle = typedArray.getString(R.styleable.ProgressView_progressTitle);
        mLeftTitle = typedArray.getString(R.styleable.ProgressView_progressLeftText);
        mRightText = typedArray.getString(R.styleable.ProgressView_progressRightText);
        mCurrentProgress = typedArray.getInt(R.styleable.ProgressView_currentProgress, 0);
        mMaxProgress = typedArray.getInt(R.styleable.ProgressView_maxProgress, 100);

        typedArray.recycle();
        //
        mProgressTitle = (TextView) findViewById(R.id.viewProgressTitle);
        mProgressLeft = (TextView) findViewById(R.id.viewLeftText);
        mProgressRight = (TextView) findViewById(R.id.viewRightText);
        mProgressBar = (ProgressBar) findViewById(R.id.viewProgressBar);

        mProgressTitle.setText(mTitle);
        mProgressLeft.setText(mLeftTitle);
        mProgressRight.setText(mRightText);

        mProgressBar.setMax(mMaxProgress);
        mProgressBar.setProgress(mCurrentProgress);

    }

    public void setMaxProgress(int maxProgress) {
        mProgressBar.setMax(maxProgress);
    }

    public void setCurrentProgress(int currentProgress) {
        mProgressBar.setProgress(currentProgress);
    }

    public void setTitle(String title) {
        mProgressTitle.setText(title);
    }

    public void setLeftTitle(String leftTitle) {
        mProgressLeft.setText(leftTitle);
    }

    public void setrightTitle(String rightText) {
        mProgressRight.setText(rightText);
    }


}
