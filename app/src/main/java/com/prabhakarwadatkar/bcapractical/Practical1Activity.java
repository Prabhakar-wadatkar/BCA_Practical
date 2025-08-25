package com.prabhakarwadatkar.bcapractical;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Practical1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical1);
        TextView textView = findViewById(R.id.practical_text);
        textView.setText("Practical 1: Hello World");
    }
}