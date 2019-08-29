package com.company.project.schedule;

import com.company.project.service.SimulateShipInfoService;
import com.company.project.util.SimulateShipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.lang.Math.abs;

/**
 * 模拟船舶方向
 * 定时得到第一组和第二组经纬度，sleep等待
 * 计算方向，赋值给simulate_ship_info
 */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleShipDirection {

    @Autowired
    private SimulateShipInfoService simulateShipInfoService;

    @Autowired
    private SimulateShipUtil simulateShipUtil;

    Double[] getLongArray1;
    Double[] getLongArray2;
    Double[] getLatArray1;
    Double[] getLatArray2;

    Double precision = 0.0000001;

    @Scheduled(cron = "0/10 * * * * ?")
    private Double[] getLongArray1() {
        getLongArray1 = simulateShipUtil.getLongArray();
        for (Double a : getLongArray1) {
//            System.out.println("一组Long： " + a);
        }
        System.out.println("一组 ： "+ getLongArray1[0] + LocalDateTime.now());
        return getLongArray1;
    }
    @Scheduled(cron = "0/10 * * * * ?")
    private Double[] getLatArray1() {
        getLatArray1 = simulateShipUtil.getLatArray();
        for (Double a : getLatArray1) {
//            System.out.println("一组Lat： " + a);
        }
        System.out.println("一组 ： "+ getLatArray1[0] + LocalDateTime.now());
        return getLatArray1;
    }

    @Scheduled(cron = "8/10 * * * * ?")
    public Double[] getLongArray2() {
        getLongArray2 = simulateShipUtil.getLongArray();
        for (Double a : getLongArray2) {
//            System.out.println("二组Long:  " + a);
        }
        System.out.println("二组 ： "+ getLongArray2[0] + LocalDateTime.now());
        return getLongArray2;
    }

    @Scheduled(cron = "8/10 * * * * ?")
    public Double[] getLatArray2() {
        getLatArray2 = simulateShipUtil.getLatArray();
        for (Double a : getLatArray2) {
//            System.out.println("二组Lat:  " + a);
        }
        System.out.println("二组 ： "+ getLatArray2[0] + LocalDateTime.now());
        return getLatArray2;
    }
//可验证差值 lat对不对，后面在加上计算方向
    @Scheduled(cron = "9/10 * * * * ?")
    public void test01(){
        Double[] subtractionLong = new Double[getLongArray1.length];
        for (int i=0; i < getLongArray1.length; i++) {
            subtractionLong[i] = getLongArray2[i] - getLongArray1[i];
            //消除意外的0.0，不更新的点位
            if(abs(subtractionLong[i]) <precision){
                subtractionLong[i] = subtractionLong[0];
            }
            System.out.println("subtractionLong:  "+subtractionLong[i]);
        }
        System.out.println("差值Long ：  " + subtractionLong[1] + LocalDateTime.now());


        Double[] subtractionLat = new Double[getLatArray1.length];
        for (int i=0; i < getLatArray1.length; i++) {
            subtractionLat[i] = getLatArray2[i] - getLatArray1[i];
            if(abs(subtractionLong[i]) <precision){
                subtractionLat[i] = subtractionLat[0];
            }
            System.out.println("subtractionLat:  "+subtractionLat[i]);
        }
        System.out.println("差值Lat ：  " + subtractionLat[1] + LocalDateTime.now());
    }



}


//        Double[] getLatArray=simulateShipUtil.getLatArray();
//        for (Double a : getLatArray) {
//            System.out.println("一组Lat： " + a);
//        }
//
////延时6s
//        try
//        {
//            Thread.sleep(8000);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//
//        Double[] getLongArray2=simulateShipUtil.getLongArray();
//        for (Double a : getLongArray2) {
//            System.out.println("二组Long： " + a);
//        }
//        Double[] getLatArray2=simulateShipUtil.getLatArray();
//        for (Double a : getLatArray2) {
//            System.out.println("二组Lat： " + a);
//        }


/*       List<Double> listLong= simulateShipInfoService.getLong();
       List<Double> listLat= simulateShipInfoService.getLat();
       //list赋值给数组   list.toArray
        Double[] getLong = new Double[listLong.size()];
        listLong.toArray(getLong);
        for (Double a:getLong){
            System.out.println("第一组Long： " + a);
        }

        Double[] getLat = new Double[listLat.size()];
        listLat.toArray(getLat);
        for (Double a:getLat){
            System.out.println("第一组Lat： " +a);
        }*/

//延时6s
/*        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }*/

//        后面在取一次值，在做计算方向

/*        List<Double> listLong2= simulateShipInfoService.getLong();
        List<Double> listLat2= simulateShipInfoService.getLat();
        //list赋值给数组   list.toArray
        Double[] getLong2 = new Double[listLong2.size()];
        listLong2.toArray(getLong2);
        for (Double a:getLong2){
            System.out.println("第二组Long： " +a);
        }

        Double[] getLat2 = new Double[listLat2.size()];
        listLat2.toArray(getLat2);
        for (Double a:getLat2){
            System.out.println("第二组Lat： " +a);
        }
    }*/


