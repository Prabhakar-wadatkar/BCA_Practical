package com.prabhakarwadatkar.bcapractical;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Practical13Activity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical13);

        imageView = findViewById(R.id.image_view);
        Button animateButton = findViewById(R.id.animate_button);

        animateButton.setOnClickListener(v -> {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationX", 0f, 200f);
            animator.setDuration(1000); // 1 second
            animator.start();
        });
    }
}