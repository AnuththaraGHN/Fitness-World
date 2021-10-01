package com.example.fitnessworld;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

public class ProgressBarAnnimation extends Animation {
    private Context context;
    private ProgressBar progressBar;
    private float from;
    private float to;

    public ProgressBarAnnimation(Context context, ProgressBar progressBar) {
        this.context = context;
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
    }

    public ProgressBarAnnimation(ProgressBar progressBar) {

    }

    @Override
    protected void applyTransformation (float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int)value);

        if (value == to){
            context.startActivity(new Intent(context, BMICalculatorActivity.class));
        }
    }
}
