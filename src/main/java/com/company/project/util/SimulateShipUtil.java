package com.company.project.util;

import com.company.project.service.SimulateShipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * 提供随机的模拟船舶初始位置、速度
 * random函数
 */
@Component
public class SimulateShipUtil {

    @Autowired
    SimulateShipInfoService simulateShipInfoService;

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

    public Double[] getLongArray() {
        List<Double> listLong = simulateShipInfoService.getLong();

        //list赋值给数组   list.toArray
        Double[] getLong = new Double[listLong.size()];
        listLong.toArray(getLong);
        return getLong;
    }


    public Double[] getLatArray() {
        List<Double> listLat = simulateShipInfoService.getLat();
        Double[] getLat = new Double[listLat.size()];
        listLat.toArray(getLat);
        return getLat;
    }
}