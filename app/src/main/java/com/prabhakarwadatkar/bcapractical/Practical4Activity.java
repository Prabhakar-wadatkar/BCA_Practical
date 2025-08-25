package com.prabhakarwadatkar.bcapractical;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Practical4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4);

        Button buttonActivity1 = findViewById(R.id.button_activity1);
        Button buttonActivity2 = findViewById(R.id.button_activity2);

        buttonActivity1.setOnClickListener(v -> {
            Intent intent = new Intent(Practical4Activity.this, SubActivity1.class);
            startActivity(intent);
        });

        buttonActivity2.setOnClickListener(v -> {
            Intent intent = new Intent(Practical4Activity.this, SubActivity2.class);
            startActivity(intent);
        });
    }
}