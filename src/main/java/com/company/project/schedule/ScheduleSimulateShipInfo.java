package com.company.project.schedule;

import com.company.project.service.SimulateShipInfoService;
import com.company.project.util.SimulateShipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleSimulateShipInfo {
    @Autowired
    private SimulateShipInfoService simulateShipInfoService;
    /**
     * new进来这个类，就可以调用里面方法了
     */
    SimulateShipUtil simulateShipUtil = new SimulateShipUtil();

    int speedMax = 300;     //最大速度
    int speedMin = 150;     //最小速度
    int amount1 = 14400;    // amount     总行数
    //正向
    int shipNum1 = 40;      //船数量
    int[] idInit1 = simulateShipUtil.getIdInit(shipNum1, amount1);
    int[] speed1 = simulateShipUtil.getSpeed(speedMax, speedMin, shipNum1);
    int mmsiInit1 = 444440001;          //从哪条船开始
    int[] idPoint1 = new int[shipNum1];
    int[] i1 = new int[shipNum1];
    //反向
    int shipNum2 = 40;
    int[] idInit2 = simulateShipUtil.getIdInit(shipNum2, amount1);
    int[] speed2 = simulateShipUtil.getSpeed(speedMax, speedMin, shipNum2);
    int mmsiInit2 = 444440041;          //从哪条船开始
    int[] idPoint2 = new int[shipNum2];
    int[] i2 = new int[shipNum2];
/*    int[] idInit = {ran.nextInt(amount1),
            ran.nextInt(amount1),
            ran.nextInt(amount1),
            ran.nextInt(amount1),
            ran.nextInt(amount1)}; //定义每条船舶初始位置*/


    /*    int[] speed = {ran.nextInt(speedMax - speedMin + 1) + speedMin,
                ran.nextInt(speedMax - speedMin + 1) + speedMin,
                ran.nextInt(speedMax - speedMin + 1) + speedMin,
                ran.nextInt(speedMax - speedMin + 1) + speedMin,
                ran.nextInt(speedMax - speedMin + 1) + speedMin}; //定义每条船速度*/
    //正向，20条，
    @Scheduled(cron = "0/2 * * * * ?")
    private void simulateTasks() {
/*
        for (int i : idInit) {
            System.out.println(i + " - ");
        }
        for (int i : speed) {
            System.out.println(i + " - ");
        }
*/
        for (int j = 0; j < shipNum1; j++) {

            int mmsi = mmsiInit1 + j;
            idPoint1[j] = idInit1[j] + speed1[j] * i1[j];
            simulateShipInfoService.simulateCH02601(mmsi, idPoint1[j]);
//            System.out.println("simulateCH02601: " + "  idPoint: " + idPoint1[j] + ", mmsi: " + mmsi + "   *    " + LocalDateTime.now());
            if (idPoint1[j] < amount1) {
                i1[j]++;
            } else {
                i1[j] = 1;
            }
        }
    }
    //反向，20条，
    @Scheduled(cron = "0/2 * * * * ?")
    private void simulateTasks1() {
/*
        for (int i : idInit) {
            System.out.println(i + " - ");
        }
        for (int i : speed) {
            System.out.println(i + " - ");
        }
*/
        for (int j = 0; j < shipNum2; j++) {

            int mmsi = mmsiInit2 + j;
            idPoint2[j] = idInit2[j] - speed2[j] * i2[j];
            simulateShipInfoService.simulateCH02601(mmsi, idPoint2[j]);
//            System.out.println("simulateCH02601: " + "  idPoint: " + idPoint2[j] + ", mmsi: " + mmsi + "   *    " + LocalDateTime.now());
            if (idPoint2[j] > 0) {
                i2[j]++;
            } else {
                i2[j] = 1;
            }
        }
    }

}
  /*  int mmsiInitial2 = 444440021; //从哪条船开始
    int idInitial2 = 14400;   //idInitial 初始记录位置
    int num2 = 20;          //num        一次跳跃的行数
    int x2 = 100;        //每条船之间idPoint差的倍数
    int amount2 = 0;   // * amount     总行数
    int id2 = 0;          // * id         读取的是哪一行
    int i2 = 0;*/
//反向，20条船，间隔100点位，速度2点位，
    /*@Scheduled(cron = "0/1 * * * * ?")
    private void simulateTasks2() {

        if (id2 > amount2) {
            id2 = idInitial2 - num2 * i2;
            i2++;
        } else {
            id2 = idInitial2;
            i2 = 1;
        }

        for (int j = 0; j < 20; j++) {

            int mmsi = mmsiInitial2 + j;
            int idPoint = id2 - x2 * j;
            simulateShipInfoService.simulateCH02601(mmsi, idPoint);
            //System.out.println("simulateCH02601 反向: " + "  idPoint: " + idPoint + ", mmsi: " + mmsi + "   *    " + LocalDateTime.now());
        }
    }*/
//}


//    int divisor = 720;
//    int remainder = 0;
//    int subtract = 0;
//    int r = remainder;
//    int s = subtract;
/*        if (subtract < 20) {

            if (r < 720) {
                r = r + 1;

                simulateShipInfoService.updateCH02601(divisor, r, subtract);
                System.out.println("UpdateCH02601:   除数: " + divisor + ", 余数: " + r + ", 减数: " + subtract + "   *  " + LocalDateTime.now());
                r = num * i;
                i++;
            } else if (r >= 720) {
                r = 0;
                simulateShipInfoService.updateCH02601(divisor, r, subtract);
                System.out.println("UpdateCH02601:   除数: " + divisor + ", 余数: " + r + ", 减数: " + subtract + "   *  " + LocalDateTime.now());
                i = 1;
                subtract++;
            }
        } else if (subtract >= 20) {
            subtract = 0;
        }*/

