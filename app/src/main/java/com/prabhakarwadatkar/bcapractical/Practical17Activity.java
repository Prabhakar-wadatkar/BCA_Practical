package com.prabhakarwadatkar.bcapractical;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class Practical17Activity extends AppCompatActivity {
    private TextView counterTextView;
    private BroadcastReceiver counterReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical17);

        counterTextView = findViewById(R.id.counter_text);
        Button startButton = findViewById(R.id.start_button);
        Button stopButton = findViewById(R.id.stop_button);

        // Set up BroadcastReceiver for counter updates
        counterReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int count = intent.getIntExtra(CounterService.EXTRA_COUNT, 0);
                counterTextView.setText("Counter: " + count);
            }
        };

        // Register receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(
                counterReceiver, new IntentFilter(CounterService.ACTION_COUNTER_UPDATE));

        startButton.setOnClickListener(v -> {
            Intent serviceIntent = new Intent(this, CounterService.class);
            startService(serviceIntent);
            counterTextView.setText("Counter: Starting...");
        });

        stopButton.setOnClickListener(v -> {
            Intent serviceIntent = new Intent(this, CounterService.class);
            stopService(serviceIntent);
            counterTextView.setText("Counter: Stopped");
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister receiver to prevent leaks
        LocalBroadcastManager.getInstance(this).unregisterReceiver(counterReceiver);
    }
}