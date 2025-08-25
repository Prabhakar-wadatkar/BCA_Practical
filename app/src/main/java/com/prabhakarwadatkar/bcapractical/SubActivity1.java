package com.prabhakarwadatkar.bcapractical;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        TextView textView = findViewById(R.id.sub_activity_text);
        textView.setText("Sub Activity 1");
    }
}