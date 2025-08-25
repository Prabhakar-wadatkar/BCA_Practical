package com.prabhakarwadatkar.bcapractical;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Practical9Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical9);

        Button showDialogButton = findViewById(R.id.show_dialog_button);
        showDialogButton.setOnClickListener(v -> {
            new AlertDialog.Builder(Practical9Activity.this)
                    .setTitle("Alert Dialog")
                    .setMessage("This is a simple alert dialog box.")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
}