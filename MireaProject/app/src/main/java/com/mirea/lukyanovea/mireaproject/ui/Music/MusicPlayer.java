package com.mirea.lukyanovea.mireaproject.ui.Music;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mirea.lukyanovea.mireaproject.R;


public class MusicPlayer extends Fragment {
    Button playButton;
    boolean musicPlay = false;

    public MusicPlayer() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_player, container, false);
        playButton = view.findViewById(R.id.button);
        playButton.setOnClickListener(view1 -> PlayOrStopMusic());
        return view;
    }


    // Music Player
    public void onClickPlayMusic() {
        getActivity().startService(
                new Intent(getActivity(), MusicService.class));
    }
    public void onClickStopMusic() {
        getActivity().stopService(
                new Intent(getActivity(), MusicService.class));
    }
    public  void  PlayOrStopMusic(){
        if (!musicPlay){
            onClickPlayMusic();
            musicPlay = true;
            playButton.setText("Stop");
        }
        else{
            onClickStopMusic();
            musicPlay = false;
            playButton.setText("Play");
        }
    }


}
