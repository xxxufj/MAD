package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class SpringActivity extends AppCompatActivity {

    private ImageView img;
    private SeekBar dampRatioSeekBar;
    private SeekBar stiffnessSeekBar;

    private TextView damplingRatioValue;
    private TextView stiffnessValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring);
        dampRatioSeekBar = findViewById(R.id.dampSeekbar);
        stiffnessSeekBar = findViewById(R.id.stiffSeekbar);
        damplingRatioValue = findViewById(R.id.damplingRatioValue);
        stiffnessValue = findViewById(R.id.stiffnessValue);
        dampRatioSeekBar.setProgress(dampRatioSeekBar.getMax()/2);
        stiffnessSeekBar.setProgress(stiffnessSeekBar.getMax()/2);
        damplingRatioValue.setText(Double.toString((double)dampRatioSeekBar.getMax()/2));
        stiffnessValue.setText(Float.toString(stiffnessSeekBar.getMax()/2));

        dampRatioSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                damplingRatioValue.setText(Double.toString((double)progress/10000));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                springAnimator((float)dampRatioSeekBar.getProgress()/10000,(float)stiffnessSeekBar.getProgress());
            }
        });

        stiffnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                stiffnessValue.setText(Float.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                springAnimator((float)dampRatioSeekBar.getProgress()/10000,stiffnessSeekBar.getProgress());
            }
        });
    }


    private void springAnimator(float dampingRatio, float stiffness){
        img = findViewById(R.id.imgSpring);
        SpringAnimation springAnimation = new SpringAnimation(img, DynamicAnimation.Y);
        springAnimation.setStartVelocity(10000);

        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(dampingRatio);
        springForce.setStiffness(stiffness);
        springForce.setFinalPosition(img.getX());

        springAnimation.setSpring(springForce);
        springAnimation.start();
    }
}
