package com.dongdong.spring.test.DesignMode.adapterModel;

/**
 * @Description: 高级的媒体播放器
 * @Date: 2020/8/26  10:32
 * @Author: dongdong
 */
public interface AdvancedMediaPlayer {
     void playVlc(String fileName);
     void playMp4(String fileName);
}
