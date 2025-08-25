package com.prabhakarwadatkar.bcapractical;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class Practical19Activity extends AppCompatActivity {
    private VideoView videoView;
    private SeekBar seekBar;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable updateSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical19);

        videoView = findViewById(R.id.video_view);
        seekBar = findViewById(R.id.seek_bar);
        Button playButton = findViewById(R.id.play_button);
        Button pauseButton = findViewById(R.id.pause_button);
        Button stopButton = findViewById(R.id.stop_button);

        // Set video source (online URL)
        String videoPath = "https://youtu.be/m7QuO0IsT7g?si=wPSENbwkpCWrPTHT";
        videoView.setVideoURI(Uri.parse(videoPath));

        // Set up SeekBar (display progress only, no manual seeking)
        seekBar.setEnabled(false); // Prevent manual seeking for simplicity
        videoView.setOnPreparedListener(mp -> {
            seekBar.setMax(videoView.getDuration());
            updateSeekBar = new Runnable() {
                @Override
                public void run() {
                    if (videoView.isPlaying()) {
                        seekBar.setProgress(videoView.getCurrentPosition());
                        handler.postDelayed(this, 100);
                    }
                }
            };
            handler.post(updateSeekBar);
        });

        playButton.setOnClickListener(v -> {
            if (!videoView.isPlaying()) {
                videoView.start();
                handler.post(updateSeekBar);
            }
        });

        pauseButton.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause();
                handler.removeCallbacks(updateSeekBar);
            }
        });

        stopButton.setOnClickListener(v -> {
            videoView.stopPlayback();
            videoView.setVideoURI(Uri.parse(videoPath)); // Reset video
            seekBar.setProgress(0);
            handler.removeCallbacks(updateSeekBar);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (videoView.isPlaying()) {
            videoView.pause();
            handler.removeCallbacks(updateSeekBar);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(updateSeekBar);
    }
}