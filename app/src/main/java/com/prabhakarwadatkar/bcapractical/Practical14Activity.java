package com.prabhakarwadatkar.bcapractical;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Practical14Activity extends AppCompatActivity {
    private TextView animationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical14);

        animationTextView = findViewById(R.id.animation_text);
        Button animateButton = findViewById(R.id.animate_button);

        animateButton.setOnClickListener(v -> {
            ObjectAnimator animator = ObjectAnimator.ofFloat(animationTextView, "alpha", 1f, 0f, 1f);
            animator.setDuration(2000); // 2 seconds for full cycle (fade out and back in)
            animator.start();
        });
    }
}