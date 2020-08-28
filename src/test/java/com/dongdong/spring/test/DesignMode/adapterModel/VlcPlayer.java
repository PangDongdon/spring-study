package com.dongdong.spring.test.DesignMode.adapterModel;

/**
 * @Description:
 * @Date: 2020/8/26  10:35
 * @Author: dongdong
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
       System.out.println("Playing vlc file Name"+fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
