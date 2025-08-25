package com.prabhakarwadatkar.bcapractical;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class Practical15Activity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical15);

        videoView = findViewById(R.id.video_view);
        Button playButton = findViewById(R.id.play_button);
        Button pauseButton = findViewById(R.id.pause_button);

        // Set video source (local resource in res/raw/sample_video.mp4)
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.sample_video;
        videoView.setVideoURI(Uri.parse(videoPath));

        playButton.setOnClickListener(v -> {
            if (!videoView.isPlaying()) {
                videoView.start();
            }
        });

        pauseButton.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause();
            }
        });
    }
}