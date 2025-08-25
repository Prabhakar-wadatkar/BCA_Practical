package com.prabhakarwadatkar.bcapractical;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Practical16Activity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical16);

        imageView = findViewById(R.id.image_view);
        Button animateButton = findViewById(R.id.animate_button);

        animateButton.setOnClickListener(v -> {
            // Create animators for translation, rotation, and scaling
            ObjectAnimator translateX = ObjectAnimator.ofFloat(imageView, "translationX", 0f, 200f);
            translateX.setDuration(1000);

            ObjectAnimator rotate = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
            rotate.setDuration(1000);

            ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 1.5f, 1f);
            scaleX.setDuration(1000);

            ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 1.5f, 1f);
            scaleY.setDuration(1000);

            // Combine animations using AnimatorSet
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(translateX, rotate, scaleX, scaleY);
            animatorSet.start();
        });
    }
}