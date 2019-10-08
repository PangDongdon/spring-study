package com.dongdong.spring.test.javaDesignModel20;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  13:00
 */
public class Context {
    private Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String weatherMessage(){
        return  weather.getWeather();
    }
}
