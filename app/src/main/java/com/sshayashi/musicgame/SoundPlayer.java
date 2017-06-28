package com.sshayashi.musicgame;

import android.media.AudioAttributes;
import android.media.AudioManager;
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
    private int[] musicIds;

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

    private void initSoundPool(){

        musicIds = new int[12];
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        } else {
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
        }
        musicIds[0] = soundPool.load(MyApplication.getAppContext(),R.raw.piano2_1do,1);
        musicIds[1] = soundPool.load(MyApplication.getAppContext(),R.raw.piano2_2re,1);
        musicIds[2] = soundPool.load(MyApplication.getAppContext(),R.raw.piano2_3mi,1);
        musicIds[3] = soundPool.load(MyApplication.getAppContext(),R.raw.piano2_4fa,1);
        musicIds[4] = soundPool.load(MyApplication.getAppContext(),R.raw.piano2_5so,1);
        musicIds[5] = soundPool.load(MyApplication.getAppContext(),R.raw.piano2_6ra,1);
        musicIds[6] = soundPool.load(MyApplication.getAppContext(),R.raw.piano2_7si,1);
        musicIds[7] = soundPool.load(MyApplication.getAppContext(),R.raw.piano1_8do,1);
        musicIds[8] = soundPool.load(MyApplication.getAppContext(),R.raw.piano1_am_chord,1);
        musicIds[9] = soundPool.load(MyApplication.getAppContext(),R.raw.piano1_c_chord,1);
        musicIds[10] = soundPool.load(MyApplication.getAppContext(),R.raw.piano1_f_chord,1);
        musicIds[11] = soundPool.load(MyApplication.getAppContext(),R.raw.piano1_g_chord,1);
        return;
    }

    public void play(int id,int rate){
        int len = musicIds.length;
        float r = (float) rate / 11.0f;
        soundPool.play(musicIds[id%len], 1.0f, 1.0f, 0, 1, 2 * r);
        return ;
    }
}