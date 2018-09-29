package com.paul.mobilelearning;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Objects;

public class Videos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        Intent i = getIntent();
        String activeVideoName = i.getStringExtra("videoName");
        String term = i.getStringExtra("term");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(activeVideoName);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);


        if(Objects.equals(activeVideoName, "Video 1")){

            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.introduction);
            //Intent intent = new Intent(null, Uri.parse("https://www.youtube.com/watch?v=UjU1QDKetiQ"), this, Videos.class);
            //startActivity(intent);

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
            videoView.start();

        }


    }
}
