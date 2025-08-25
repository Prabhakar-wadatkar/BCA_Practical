package com.prabhakarwadatkar.bcapractical;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Practical8Activity extends AppCompatActivity {
    private BroadcastReceiver airplaneModeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical8);

        TextView textView = findViewById(R.id.receiver_status);
        textView.setText("Toggle airplane mode to see BroadcastReceiver in action");

        airplaneModeReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
                String message = isAirplaneModeOn ? "Airplane Mode Enabled" : "Airplane Mode Disabled";
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        };

        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (airplaneModeReceiver != null) {
            unregisterReceiver(airplaneModeReceiver);
        }
    }
}