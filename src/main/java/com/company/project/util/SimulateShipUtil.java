package com.company.project.util;

import com.company.project.service.SimulateShipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

/**
 * 提供随机的模拟船舶初始位置、速度
 * random函数
 */
@Component
public class SimulateShipUtil{

    @Autowired
    public SimulateShipInfoService simulateShipInfoService;

    public static SimulateShipUtil simulateShipUtil;

    public SimulateShipUtil() {

    }
    @PostConstruct
    public void init() {
        simulateShipUtil=this;
        simulateShipUtil.simulateShipInfoService=this.simulateShipInfoService;

    }

    //    int shipNum;
//int randomInt = ran.nextInt(100);
//double d = ran.nextDouble();  0~1;


    Random ran = new Random();




    //
    public int[] getIdInit(int shipNum, int amount) {

        int[] idInit = new int[shipNum];
        for (int i = 0; i < shipNum; i++) {
            idInit[i] = ran.nextInt(amount);
            System.out.println(idInit[i]);
        }
        return idInit;
    }

    public int[] getSpeed(int speedMax, int speedMin, int shipNum) {
        int[] speed = new int[shipNum];
        for (int i = 0; i < shipNum; i++) {
            speed[i] = ran.nextInt(speedMax - speedMin + 1) + speedMin;
            System.out.println(speed[i]);
        }
        return speed;
    }

    /**
     * 将经度从mysql返回的list中，提取到数组getLong中
     * @return
     */
    public Double[] getLongArray() {
        List<Double> listLong = simulateShipUtil.simulateShipInfoService.getLong();

        //list赋值给数组   list.toArray
        Double[] getLong = new Double[listLong.size()];
        listLong.toArray(getLong);
        return getLong;
    }


    public Double[] getLatArray() {
        List<Double> listLat = simulateShipUtil.simulateShipInfoService.getLat();
        Double[] getLat = new Double[listLat.size()];
        listLat.toArray(getLat);
        return getLat;
    }


    /**
     *算角度
     * @param lat_a 纬度1
     * @param lng_a 经度1
     * @param lat_b 纬度2
     * @param lng_b 经度2
     * @return
     */
    public   double getAngle( double lng_a,double lat_a, double lng_b,double lat_b ) {

        double y = Math.sin(lng_b - lng_a) * Math.cos(lat_b);
        double x = Math.cos(lat_a) * Math.sin(lat_b) - Math.sin(lat_a) * Math.cos(lat_b) * Math.cos(lng_b - lng_a);
        double brng = Math.atan2(y, x);

        brng = Math.toDegrees(brng);
        if (brng < 0)
            brng = brng + 360;
        return brng;

    }

    /**
     * 算速度
     */
    public double getSpeed( double lng_a,double lat_a, double lng_b,double lat_b) {
        double x = Math.pow((lng_b - lng_a),2);
        double y = Math.pow((lat_b - lat_a), 2);
        double speed= Math.sqrt(x+y)*111322.2222*3600/1000/1.825;
        return speed;
    }

/* ————————————————
        版权声明：本文为CSDN博主「月光日光」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/xiaobai091220106/article/details/50879414*/
}