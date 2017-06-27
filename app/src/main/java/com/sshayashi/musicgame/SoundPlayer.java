package com.sshayashi.musicgame;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by starprince on 2017/06/28.
 */

public class SoundPlayer
{

    private static SoundPlayer instance;
    private AudioAttributes audioAttributes;
    private SoundPool soundPool;

    private SoundPlayer()
    {
        initSoundPool();
    }

    public static SoundPlayer getInstance()
    {
        if(instance == null)
            instance = new SoundPlayer();

        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initSoundPool(){
        audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                // CONTENT_TYPE_MUSIC
                // CONTENT_TYPE_SPEECH, etc.
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                // ストリーム数に応じて
                .setMaxStreams(2)
                .build();

        // one.wav をロードしておく
//        soundOne = soundPool.load(this, R.raw.one, 1);
//        // two.wav をロードしておく
//        soundTwo = soundPool.load(this, R.raw.two, 1);
        return;
    }

    public void play(int id){
        // play(ロードしたID, 左音量, 右音量, 優先度, ループ,再生速度)
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1);
        return ;
    }
}