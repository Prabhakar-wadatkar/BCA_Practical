package com.prabhakarwadatkar.bcapractical;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class CounterService extends Service {
    public static final String ACTION_COUNTER_UPDATE = "com.prabhakarwadatkar.bcapractical.COUNTER_UPDATE";
    public static final String EXTRA_COUNT = "count";
    private Thread counterThread;
    private boolean isRunning = false;

    @Override
    public IBinder onBind(Intent intent) {
        return null; // Not a bound service
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!isRunning) {
            isRunning = true;
            counterThread = new Thread(() -> {
                for (int i = 1; i <= 5 && isRunning; i++) {
                    try {
                        Thread.sleep(1000); // 1-second delay
                        Intent broadcastIntent = new Intent(ACTION_COUNTER_UPDATE);
                        broadcastIntent.putExtra(EXTRA_COUNT, i);
                        LocalBroadcastManager.getInstance(CounterService.this).sendBroadcast(broadcastIntent);
                    } catch (InterruptedException e) {
                        isRunning = false;
                    }
                }
                stopSelf(); // Stop service when done
            });
            counterThread.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
        if (counterThread != null) {
            counterThread.interrupt();
        }
    }
}