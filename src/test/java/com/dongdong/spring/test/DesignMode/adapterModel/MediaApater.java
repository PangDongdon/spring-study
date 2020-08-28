package com.dongdong.spring.test.DesignMode.adapterModel;

/**
 * @Description: 普通--适配器--高级
 * @Date: 2020/8/26  10:41
 * @Author: dongdong
 */
public class MediaApater implements  MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public  MediaApater(String  audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer=new VlcPlayer();
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer=new Mp4Player();
        }
    }
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
