package com.dongdong.spring.test.DesignMode.adapterModel;

/**
 * @Description:
 * @Date: 2020/8/26  10:38
 * @Author: dongdong
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
     System.out.println("Playing mp4 file Name:"+fileName);
    }
}
