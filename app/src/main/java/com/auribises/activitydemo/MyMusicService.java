package com.auribises.activitydemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.widget.Toast;

import java.io.IOException;

public class MyMusicService extends Service {

    String songToPlay;
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"MyMusicService Created",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {

        songToPlay = intent.getStringExtra("keySong");

        Toast.makeText(this,"MyMusicService Started : SongToPlay: "+songToPlay,Toast.LENGTH_LONG).show();


        mediaPlayer = new MediaPlayer();

        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+songToPlay;

        try {

            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();

            //mediaPlayer.pause();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();
        mediaPlayer.release();

        Toast.makeText(this,"MyMusicService Destroyed",Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
