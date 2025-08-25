package com.prabhakarwadatkar.bcapractical;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Practical7Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical7);

        TextView textView = findViewById(R.id.shared_text);

        Intent intent = getIntent();
        if (Intent.ACTION_SEND.equals(intent.getAction()) && "text/plain".equals(intent.getType())) {
            String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
            if (sharedText != null) {
                textView.setText("Shared Text: " + sharedText);
            } else {
                textView.setText("No text shared");
            }
        } else {
            textView.setText("Open this app via Share option to see shared text");
        }
    }
}