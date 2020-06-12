package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class FlingActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{
    private ImageView img;
    GestureDetector detector;
    FlingAnimation flingAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fling);
        img = findViewById(R.id.imgFling);
        detector = new GestureDetector(this, this);
    }

    public boolean onTouchEvent(MotionEvent e) {
        return detector.onTouchEvent(e);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        return false;
    }

    /**
     * 滑屏监测	 *
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (Math.abs(velocityX) > Math.abs(velocityY)) {
            flingAnimation = new FlingAnimation(img, DynamicAnimation.X);
            flingAnimation.setFriction(0.5f);
            flingAnimation.setStartVelocity(velocityX / 5);
        } else {
            flingAnimation = new FlingAnimation(img, DynamicAnimation.Y);
            flingAnimation.setFriction(0.5f);
            flingAnimation.setStartVelocity(velocityY / 5);
        }
        flingAnimation.start();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) { }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent arg0) { }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) { return false; }
}
