package com.auribises.activitydemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlaySongActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtSongName;
    Button btnPlay,btnStop;
    String songName;
    Dialog dialog;

    void askToPlay(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Play : "+songName);
        builder.setMessage("Are you Sure ?");
        builder.setPositiveButton("Play", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                playStop(true);

            }
        });
        //builder.setCancelable(false); // Even if you press back key, it will not be destroyed
        builder.setNegativeButton("Cancel",null);
        builder.create().show();
    }

    void askForOptions(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] items = {"Play "+songName,"Download","Lyrics"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                switch (i){
                    case 0:
                        playStop(true);
                        break;

                    case 1:

                        break;

                    case 2:

                        break;
                }

            }
        });
        builder.create().show();

    }



    TextView dtxtSongName;
    Button dbtnPlay, dbtnStop;

    void customDialog(){
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.cutsom_dialog);

        dtxtSongName = (TextView)dialog.findViewById(R.id.textViewSongName);
        dbtnPlay = (Button)dialog.findViewById(R.id.buttonPlay);
        dbtnStop = (Button)dialog.findViewById(R.id.buttonStop);

        dtxtSongName.setText(songName);
        dbtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playStop(true);
            }
        });



        //dialog.setCancelable(false);
        dialog.show();
        //dialog.dismiss();
    }



    void initViews(){

        txtSongName = (TextView)findViewById(R.id.textView3);

        btnPlay = (Button)findViewById(R.id.buttonPlay);
        btnStop = (Button)findViewById(R.id.buttonStop);

        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        Intent rcv = getIntent();
        songName = rcv.getStringExtra("keySong");

        txtSongName.setText(songName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        initViews();
    }

    void playStop(boolean flag){

        Intent intent = new Intent(PlaySongActivity.this,MyMusicService.class);
        Intent intent1 = new Intent("a.b.c.d");

        if(flag){
            intent.putExtra("keySong",songName);
            intent1.putExtra("keySong",songName);
            startService(intent);
            sendBroadcast(intent1);
        }else{
            stopService(intent);
        }
    }

    @Override
    public void onClick(View view) {



        if(view.getId() == R.id.buttonPlay){
           //askToPlay();
           // askForOptions();
            customDialog();
        }else{
            playStop(false);
        }

    }
}
