package com.prabhakarwadatkar.bcapractical;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Practical18Activity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView progressTextView;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical18);

        progressBar = findViewById(R.id.progress_bar);
        progressTextView = findViewById(R.id.progress_text);
        Button incrementButton = findViewById(R.id.increment_button);

        // Set initial progress
        progressBar.setProgress(progress);
        progressTextView.setText("Progress: " + progress + "%");

        incrementButton.setOnClickListener(v -> {
            if (progress < 100) {
                progress += 10;
                progressBar.setProgress(progress);
                progressTextView.setText("Progress: " + progress + "%");
            }
        });
    }
}