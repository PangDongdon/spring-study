package com.dongdong.spring.test.Locktest;

/**
 * @Description:
 * @Date: 2019/10/30  18:05
 * @Author: dongdong
 */
public class DistanceUtil {
    public static final double EARTH_RADIUS = 6371.393;//地球半径

    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    public static double getDistance(double lat1, double lng1, double lat2, double lng2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s*1000;
    }

    public static void  main(String[]  args){
        System.out.println(getDistance(31.29457400,121.48992300,31.296703338623047,121.48568725585938));
    }


}
