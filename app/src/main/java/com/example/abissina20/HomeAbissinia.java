package com.example.abissina20;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

/**
 * Created by BelA on 6/1/2017.
 */

public class HomeAbissinia extends Fragment {
    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    ImageButton playButton;
    ImageButton stopButton;
    Button button;

    AlertDialog action;
    Handler handler;
    Runnable runnable;

    public void alerDa(){
        String[] listOpt = {getString(R.string.Amharic)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Amharic Lyrics");
        builder.setItems(listOpt,null);
        builder.setNegativeButton("ok",null);
        action = builder.create();
        action.show();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.home_abissinia,container,false);

        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        //Add Music
        mediaPlayer = MediaPlayer.create(getContext(),R.raw.ethio);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        playButton = (ImageButton)view.findViewById(R.id.palyButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();

            }
            });
        stopButton = (ImageButton)view.findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });

        button = (Button)view.findViewById(R.id.lyrics);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerDa();
            }
        });



        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(mediaPlayer.getDuration());
                playCycl();


            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return view;
    }
    public void playCycl(){
        seekBar.setProgress(mediaPlayer.getCurrentPosition());

        if(mediaPlayer.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    playCycl();
                }
            };
            handler.postDelayed(runnable,1000);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }
}
