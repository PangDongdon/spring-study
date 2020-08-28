package com.dongdong.spring.test.DesignMode.adapterModel;

import net.dongliu.commons.Sys;

/**
 * @Description:
 * @Date: 2020/8/26  10:46
 * @Author: dongdong
 */
public class AudioPlayer  implements  MediaPlayer {
    MediaApater mediaApater;
    @Override
    public void play(String audioType, String fileName) {
       if(audioType.equalsIgnoreCase("mp3")){
           System.out.println("Playing mp3 file Name:"+fileName);
       }else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
           mediaApater=new MediaApater(audioType);
           mediaApater.play(audioType, fileName);
       }else{
           System.out.println("Invalid  media"+audioType+"format not supported");
       }
    }
}
