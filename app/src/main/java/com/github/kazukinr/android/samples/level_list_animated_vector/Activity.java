package com.github.kazukinr.android.samples.level_list_animated_vector;

import com.github.kazukinr.android.samples.R;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kazuki on 2016/06/26.
 */

public class Activity extends AppCompatActivity {


    @BindView(R.id.animatedTarget)
    ImageView mAnimatedTarget;
    @BindView(R.id.animatedTarget3Column)
    ImageView mAnimatedTarget3Column;

    private Selection mCurrentSelection;
    private Selection mCurrentSelection3Columns;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_vector);

        ButterKnife.bind(this);
        initialize();
    }

    private void initialize() {
        mCurrentSelection = Selection.LEFT;
        Drawable drawable = mAnimatedTarget.getDrawable().mutate();
        drawable.setLevel(0);

        mCurrentSelection3Columns = Selection.LEFT;
        Drawable drawable3 = mAnimatedTarget3Column.getDrawable().mutate();
        drawable3.setLevel(0);
    }

    @OnClick(R.id.button)
    void onClick(View v) {
        Drawable drawable = mAnimatedTarget.getDrawable();
        switch (mCurrentSelection) {
            case LEFT:
                drawable.setLevel(0);
                mCurrentSelection = Selection.RIGHT;
                break;
            case RIGHT:
                drawable.setLevel(1);
                mCurrentSelection = Selection.LEFT;
                break;
        }

        AnimatedVectorDrawable animatedVector = (AnimatedVectorDrawable) drawable.getCurrent();
        animatedVector.start();
    }

    @OnClick(R.id.toLeft)
    void toLeft() {
        Drawable drawable = mAnimatedTarget3Column.getDrawable();
        switch (mCurrentSelection3Columns) {
            case LEFT:
                return;
            case CENTER:
                drawable.setLevel(1);
                mCurrentSelection3Columns = Selection.LEFT;
                break;
            case RIGHT:
                drawable.setLevel(3);
                mCurrentSelection3Columns = Selection.CENTER;
                break;
        }

        AnimatedVectorDrawable animatedVector = (AnimatedVectorDrawable) drawable.getCurrent();
        animatedVector.start();
    }

    @OnClick(R.id.toRight)
    void toRight() {
        Drawable drawable = mAnimatedTarget3Column.getDrawable();
        switch (mCurrentSelection3Columns) {
            case LEFT:
                drawable.setLevel(0);
                mCurrentSelection3Columns = Selection.CENTER;
                break;
            case CENTER:
                drawable.setLevel(2);
                mCurrentSelection3Columns = Selection.RIGHT;
                break;
            case RIGHT:
                return;
        }

        AnimatedVectorDrawable animatedVector = (AnimatedVectorDrawable) drawable.getCurrent();
        animatedVector.start();
    }

    private enum Selection {
        LEFT,
        RIGHT,
        CENTER
    }
}
