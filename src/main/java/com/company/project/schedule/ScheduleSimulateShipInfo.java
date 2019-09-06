package com.company.project.schedule;

import com.company.project.model.Boat;
import com.company.project.service.SimulateShipInfoService;
import com.company.project.util.SimulateShipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
/*@Autowired
private SimulateShipUtil simulateShipUtil;*/

/*private static ScheduleSimulateShipInfo scheduleSimulateShipInfo;

    @PostConstruct
    public void init() {
        scheduleSimulateShipInfo=this;
        scheduleSimulateShipInfo.simulateShipInfoService=this.simulateShipInfoService;

    }*/

    int speedMax1 = 8;     //最大速度(跳跃行速）
    int speedMin1 = 3;     //最小速度
    int amount1 = 14400;    // amount     总行数
    //正向
    int shipNum1 = 20;      //船数量
    int[] idInit1 = simulateShipUtil.getIdInit(shipNum1, amount1);
    int[] speed1 = simulateShipUtil.getSpeed(speedMax1, speedMin1, shipNum1);
    int mmsiInit1 = 444440001;          //从哪条船开始
    int[] idPoint1 = new int[shipNum1];
    int[] i1 = new int[shipNum1];
    //反向
    int shipNum2 = 20;
    int[] idInit2 = simulateShipUtil.getIdInit(shipNum2, amount1);
    int[] speed2 = simulateShipUtil.getSpeed(speedMax1, speedMin1, shipNum2);
    int mmsiInit2 = 444440021;          //从哪条船开始
    int[] idPoint2 = new int[shipNum2];
    int[] i2 = new int[shipNum2];
    /**
     * hj01001
     */
    String shipTrack01_01 = "hj01001"; //航迹
    int speedMax01_01 = 8;     //最大速度
    int speedMin01_01 = 3;     //最小速度
    int amount01_01 = 10834;    // amount     总行数
    //正向
    int shipNum01_01 = 40;      //船数量
    int[] idInit01_01 = simulateShipUtil.getIdInit(shipNum01_01, amount01_01);
    int[] speed01_01 = simulateShipUtil.getSpeed(speedMax01_01, speedMin01_01, shipNum01_01);
    int mmsiInit01_01 = 444440041;          //从哪条船开始
    int[] idPoint01_01 = new int[shipNum01_01];
    int[] i01_01 = new int[shipNum01_01];

    /**
     * hj01002
     */
    String shipTrack02_01 = "hj01002"; //航迹
    int speedMax02_01 = 8;     //最大速度
    int speedMin02_01 = 3;     //最小速度
    int amount02_01 = 14386;    // amount     总行数
    //正向
    int shipNum02_01 = 40;      //船数量
    int[] idInit02_01 = simulateShipUtil.getIdInit(shipNum02_01, amount02_01);
    int[] speed02_01 = simulateShipUtil.getSpeed(speedMax02_01, speedMin02_01, shipNum02_01);
    int mmsiInit02_01 = 444440081;          //从哪条船开始
    int[] idPoint02_01 = new int[shipNum02_01];
    int[] i02_01 = new int[shipNum02_01];
    /**
     * hj01003
     */
    String shipTrack03_01 = "hj01003"; //航迹
    int speedMax03_01 = 8;     //最大速度
    int speedMin03_01 = 3;     //最小速度
    int amount03_01 = 13450;    // amount     总行数
    //正向
    int shipNum03_01 = 40;      //船数量
    int[] idInit03_01 = simulateShipUtil.getIdInit(shipNum03_01, amount03_01);
    int[] speed03_01 = simulateShipUtil.getSpeed(speedMax03_01, speedMin03_01, shipNum03_01);
    int mmsiInit03_01 = 444440121;          //从哪条船开始
    int[] idPoint03_01 = new int[shipNum03_01];
    int[] i03_01 = new int[shipNum03_01];
    /**
     * hj01004
     */
    String shipTrack04_01 = "hj01004"; //航迹
    int speedMax04_01 = 8;     //最大速度
    int speedMin04_01 = 3;     //最小速度
    int amount04_01 = 13552;    // amount     总行数
    //正向
    int shipNum04_01 = 40;      //船数量
    int[] idInit04_01 = simulateShipUtil.getIdInit(shipNum04_01, amount04_01);
    int[] speed04_01 = simulateShipUtil.getSpeed(speedMax04_01, speedMin04_01, shipNum04_01);
    int mmsiInit04_01 = 444440161;          //从哪条船开始
    int[] idPoint04_01 = new int[shipNum04_01];
    int[] i04_01 = new int[shipNum04_01];
    /**
     * hj01005
     */
    String shipTrack05_01 = "hj01005"; //航迹
    int speedMax05_01 = 8;     //最大速度
    int speedMin05_01 = 3;     //最小速度
    int amount05_01 = 15683;    // amount     总行数
    //正向
    int shipNum05_01 = 40;      //船数量
    int[] idInit05_01 = simulateShipUtil.getIdInit(shipNum05_01, amount05_01);
    int[] speed05_01 = simulateShipUtil.getSpeed(speedMax05_01, speedMin05_01, shipNum05_01);
    int mmsiInit05_01 = 444440201;          //从哪条船开始
    int[] idPoint05_01 = new int[shipNum05_01];
    int[] i05_01 = new int[shipNum05_01];
    /**
     * hj01006
     */
    String shipTrack06_01 = "hj01006"; //航迹
    int speedMax06_01 = 8;     //最大速度
    int speedMin06_01 = 3;     //最小速度
    int amount06_01 = 13236;    // amount     总行数
    //正向
    int shipNum06_01 = 40;      //船数量
    int[] idInit06_01 = simulateShipUtil.getIdInit(shipNum06_01, amount06_01);
    int[] speed06_01 = simulateShipUtil.getSpeed(speedMax06_01, speedMin06_01, shipNum06_01);
    int mmsiInit06_01 = 444440241;          //从哪条船开始
    int[] idPoint06_01 = new int[shipNum06_01];
    int[] i06_01 = new int[shipNum06_01];
    /**
     * hj01007
     */
    String shipTrack07_01 = "hj01007"; //航迹
    int speedMax07_01 = 8;     //最大速度
    int speedMin07_01 = 3;     //最小速度
    int amount07_01 = 3914;    // amount     总行数
    //正向
    int shipNum07_01 = 10;      //船数量
    int[] idInit07_01 = simulateShipUtil.getIdInit(shipNum07_01, amount07_01);
    int[] speed07_01 = simulateShipUtil.getSpeed(speedMax07_01, speedMin07_01, shipNum07_01);
    int mmsiInit07_01 = 444440281;          //从哪条船开始
    int[] idPoint07_01 = new int[shipNum07_01];
    int[] i07_01 = new int[shipNum07_01];
    /**
     * hj01008
     */
    String shipTrack08_01 = "hj01008"; //航迹
    int speedMax08_01 = 8;     //最大速度
    int speedMin08_01 = 3;     //最小速度
    int amount08_01 = 5073;    // amount     总行数
    //正向
    int shipNum08_01 = 20;      //船数量
    int[] idInit08_01 = simulateShipUtil.getIdInit(shipNum08_01, amount08_01);
    int[] speed08_01 = simulateShipUtil.getSpeed(speedMax08_01, speedMin08_01, shipNum08_01);
    int mmsiInit08_01 = 444440291;          //从哪条船开始
    int[] idPoint08_01 = new int[shipNum08_01];
    int[] i08_01 = new int[shipNum08_01];
    /**
     * hj01009
     */
    String shipTrack09_01 = "hj01009"; //航迹
    int speedMax09_01 = 8;     //最大速度
    int speedMin09_01 = 3;     //最小速度
    int amount09_01 = 7189;    // amount     总行数
    //正向
    int shipNum09_01 = 20;      //船数量
    int[] idInit09_01 = simulateShipUtil.getIdInit(shipNum09_01, amount09_01);
    int[] speed09_01 = simulateShipUtil.getSpeed(speedMax09_01, speedMin09_01, shipNum09_01);
    int mmsiInit09_01 = 444440311;          //从哪条船开始
    int[] idPoint09_01 = new int[shipNum09_01];
    int[] i09_01 = new int[shipNum09_01];
    /**
     * hj01010
     */
    String shipTrack10_01 = "hj01010"; //航迹
    int speedMax10_01 = 8;     //最大速度
    int speedMin10_01 = 3;     //最小速度
    int amount10_01 = 12174;    // amount     总行数
    //正向
    int shipNum10_01 = 40;      //船数量
    int[] idInit10_01 = simulateShipUtil.getIdInit(shipNum10_01, amount10_01);
    int[] speed10_01 = simulateShipUtil.getSpeed(speedMax10_01, speedMin10_01, shipNum10_01);
    int mmsiInit10_01 = 444440331;          //从哪条船开始
    int[] idPoint10_01 = new int[shipNum10_01];
    int[] i10_01 = new int[shipNum10_01];
    /**
     * hj01011
     */
    String shipTrack11_01 = "hj01011"; //航迹
    int speedMax11_01 = 8;     //最大速度
    int speedMin11_01 = 3;     //最小速度
    int amount11_01 = 6227;    // amount     总行数
    //正向
    int shipNum11_01 = 10;      //船数量
    int[] idInit11_01 = simulateShipUtil.getIdInit(shipNum11_01, amount11_01);
    int[] speed11_01 = simulateShipUtil.getSpeed(speedMax11_01, speedMin11_01, shipNum11_01);
    int mmsiInit11_01 = 444440371;          //从哪条船开始
    int[] idPoint11_01 = new int[shipNum11_01];
    int[] i11_01 = new int[shipNum11_01];
    /**
     * hj01012
     */
    String shipTrack12_01 = "hj01012"; //航迹
    int speedMax12_01 = 8;     //最大速度
    int speedMin12_01 = 3;     //最小速度
    int amount12_01 = 13838;    // amount     总行数
    //正向
    int shipNum12_01 = 20;      //船数量
    int[] idInit12_01 = simulateShipUtil.getIdInit(shipNum12_01, amount12_01);
    int[] speed12_01 = simulateShipUtil.getSpeed(speedMax12_01, speedMin12_01, shipNum12_01);
    int mmsiInit12_01 = 444440381;          //从哪条船开始
    int[] idPoint12_01 = new int[shipNum12_01];
    int[] i12_01 = new int[shipNum12_01];
    /**
     * 计算速度和方向的参数
     */
    Integer rowCountSimulateShipInfo = 400;
    Double[] getLongArray1 = new Double[rowCountSimulateShipInfo];
    Double[] getLongArray2 = new Double[rowCountSimulateShipInfo];
    Double[] getLatArray1 = new Double[rowCountSimulateShipInfo];
    Double[] getLatArray2 = new Double[rowCountSimulateShipInfo];
    Double[] angle = new Double[rowCountSimulateShipInfo];
    Double[] angleFirst = new Double[rowCountSimulateShipInfo];
    Double[] speed = new Double[rowCountSimulateShipInfo];
    Double[] speedFirst = new Double[rowCountSimulateShipInfo];
    Double precision = 0.0000001;
    int iJudge = 0;


    public static BlockingQueue<Boat> queue = new ArrayBlockingQueue<>(10000);
/*    int[] idInit = {ran.nextInt(amount1),
            ran.nextInt(amount1),
            ran.nextInt(amount1),
            ran.nextInt(amount1),
            ran.nextInt(amount1)}; //定义每条船舶初始位置*/
@Scheduled(cron = "0/10 * * * * ?")
private void task1() {

}

    /**
     * 通用方法simulateShipUpdatePosition
     * hj01001 hj01002
     */
    @Scheduled(cron = "0/10 * * * * ?")
    private void task() {
/*
        for (40){

            计算各参数 经纬度，角度，速度 （判断逻辑2是不是0，不是0的话，把2的值付给1，把2更新成新值）

            queue.add(new Boat(idInit01_01,));
        }
        for(40)

*/





        simulateShipUpdatePosition(shipTrack01_01, shipNum01_01, mmsiInit01_01, idPoint01_01, idInit01_01, speed01_01, i01_01, amount01_01);
        System.out.println("-----~~~~~~~完成 1 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack02_01, shipNum02_01, mmsiInit02_01, idPoint02_01, idInit02_01, speed02_01, i02_01, amount02_01);
        System.out.println("-----~~~~~~~完成 2 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack03_01, shipNum03_01, mmsiInit03_01, idPoint03_01, idInit03_01, speed03_01, i03_01, amount03_01);
        System.out.println("-----~~~~~~~完成 3 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack04_01, shipNum04_01, mmsiInit04_01, idPoint04_01, idInit04_01, speed04_01, i04_01, amount04_01);
        System.out.println("-----~~~~~~~完成 4 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack05_01, shipNum05_01, mmsiInit05_01, idPoint05_01, idInit05_01, speed05_01, i05_01, amount05_01);
        System.out.println("-----~~~~~~~完成 5 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack06_01, shipNum06_01, mmsiInit06_01, idPoint06_01, idInit06_01, speed06_01, i06_01, amount06_01);
        System.out.println("-----~~~~~~~完成 6 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack07_01, shipNum07_01, mmsiInit07_01, idPoint07_01, idInit07_01, speed07_01, i07_01, amount07_01);
        System.out.println("-----~~~~~~~完成 7 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack08_01, shipNum08_01, mmsiInit08_01, idPoint08_01, idInit08_01, speed08_01, i08_01, amount08_01);
        System.out.println("-----~~~~~~~完成 8 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack09_01, shipNum09_01, mmsiInit09_01, idPoint09_01, idInit09_01, speed09_01, i09_01, amount09_01);
        System.out.println("-----~~~~~~~完成 9 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack10_01, shipNum10_01, mmsiInit10_01, idPoint10_01, idInit10_01, speed10_01, i10_01, amount10_01);
        System.out.println("-----~~~~~~~完成 10 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack11_01, shipNum11_01, mmsiInit11_01, idPoint11_01, idInit11_01, speed11_01, i11_01, amount11_01);
        System.out.println("-----~~~~~~~完成 11 ~~~~~------" + LocalDateTime.now());
        simulateShipUpdatePosition(shipTrack12_01, shipNum12_01, mmsiInit12_01, idPoint12_01, idInit12_01, speed12_01, i12_01, amount12_01);
        System.out.println("-----~~~~~~~完成 12 ~~~~~------" + LocalDateTime.now());

        //计算速度和方向
        //读取一组
//i为奇数  A1赋值  A1-A2
 /*       if (iJudge % 2 != 0) {
            System.out.println("@@@ A1 ：    _________________________________________________________________________________________A1 ___Time： 开始 " + LocalDateTime.now());
            try {
                getLongArray1 = simulateShipUtil.getLongArray();
                getLatArray1 = simulateShipUtil.getLatArray();
            }catch (Exception e){
                System.out.println("___________________");
                System.out.println(e.getMessage());
                System.out.println("___________________");
            }
            getAngleSpeedAndUpdateA1SubtractA2();
        }
//i为偶数  A2赋值  A2-A1
        if (iJudge % 2 == 0) {
            if (iJudge != 0) {
                System.out.println("￥￥￥ A2 ：    __·_·__·__·__·__·__·__·_·_·__·__·__·__·__·__·__·_·__·__·__·__·__·__·__·_·__·__·__·____A12 ___Time： 开始 " + LocalDateTime.now());
                getLongArray2 = simulateShipUtil.getLongArray();
                getLatArray2 = simulateShipUtil.getLatArray();
                getAngleSpeedAndUpdateA2SubtractA1();

            }
        }
        iJudge++;*/
    }

    /**
     * 计算速度和方向并更新到表
     * A2-A1  i为偶数
     */
  /*  private void getAngleSpeedAndUpdateA2SubtractA1() {
        for (int i = 0; i < getLongArray1.length; i++) {
            angleFirst[i] = simulateShipUtil.getAngle(getLongArray1[i], getLatArray1[i], getLongArray2[i], getLatArray2[i]);
            speedFirst[i] = simulateShipUtil.getSpeed(getLongArray1[i], getLatArray1[i], getLongArray2[i], getLatArray2[i]);
            if (angleFirst[i] > precision) {
                angle[i] = angleFirst[i];
            } else {
                System.out.println("角度为0了***********");
            }

            if (speedFirst[i] > precision) {
                speed[i] = speedFirst[i];
            } else {
                System.out.println("速度为0了------------");
            }
            String angleString = String.format("%.2f", angle[i]); //转成String，保留2位小数，四舍五入
            String speedString = String.format("%.2f", speed[i]);
            simulateShipInfoService.updateAngleSpeed(angleString, speedString, i + 1);
            System.out.println("//-@@@@@@id：" + (i + 1) + "   //-*******角度：" + angleString + "   //------速度：" + speedString + "   ---  A2-A1 ----    " + LocalDateTime.now());
        }
    }*/

    /**
     * 计算速度和方向并更新到表
     * A1-A2  i为奇数
     */
   /* private void getAngleSpeedAndUpdateA1SubtractA2() {
        for (int i = 0; i < getLongArray1.length; i++) {
            angleFirst[i] = simulateShipUtil.getAngle(getLongArray2[i], getLatArray2[i], getLongArray1[i], getLatArray1[i]);
            speedFirst[i] = simulateShipUtil.getSpeed(getLongArray2[i], getLatArray2[i], getLongArray1[i], getLatArray1[i]);
            if (angleFirst[i] > precision) {
                angle[i] = angleFirst[i];
            } else {
                System.out.println("角度为0了***********");
            }

            if (speedFirst[i] > precision) {
                speed[i] = speedFirst[i];
            } else {
                System.out.println("速度为0了------------");
            }
            String angleString = String.format("%.2f", angle[i]); //转成String，保留2位小数，四舍五入
            String speedString = String.format("%.2f", speed[i]);
            simulateShipInfoService.updateAngleSpeed(angleString, speedString, i + 1);
            System.out.println("//-@@@@@@id：" + (i + 1) + "   //-*******角度：" + angleString + "   //------速度：" + speedString + "   ---  A1-A2 ----    " + LocalDateTime.now());
        }
    }*/
/*
    @Scheduled(cron = "1/10 * * * * ?")
    private void task1() {
        simulateShipUpdatePosition(shipTrack01_01, shipNum01_01, mmsiInit01_01, idPoint01_01, idInit01_01, speed01_01, i01_01, amount01_01);
        System.out.println("-----~~~~~~~完成 1 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task2() {
        simulateShipUpdatePosition(shipTrack02_01, shipNum02_01, mmsiInit02_01, idPoint02_01, idInit02_01, speed02_01, i02_01, amount02_01);
        System.out.println("-----~~~~~~~完成 2 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task3() {
        simulateShipUpdatePosition(shipTrack03_01, shipNum03_01, mmsiInit03_01, idPoint03_01, idInit03_01, speed03_01, i03_01, amount03_01);
        System.out.println("-----~~~~~~~完成 3 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task4() {
        simulateShipUpdatePosition(shipTrack04_01, shipNum04_01, mmsiInit04_01, idPoint04_01, idInit04_01, speed04_01, i04_01, amount04_01);
        System.out.println("-----~~~~~~~完成 4 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task5() {
        simulateShipUpdatePosition(shipTrack05_01, shipNum05_01, mmsiInit05_01, idPoint05_01, idInit05_01, speed05_01, i05_01, amount05_01);
        System.out.println("-----~~~~~~~完成 5 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task6() {
        simulateShipUpdatePosition(shipTrack06_01, shipNum06_01, mmsiInit06_01, idPoint06_01, idInit06_01, speed06_01, i06_01, amount06_01);
        System.out.println("-----~~~~~~~完成 6 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task7() {
        simulateShipUpdatePosition(shipTrack07_01, shipNum07_01, mmsiInit07_01, idPoint07_01, idInit07_01, speed07_01, i07_01, amount07_01);
        System.out.println("-----~~~~~~~完成 7 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task8() {
        simulateShipUpdatePosition(shipTrack08_01, shipNum08_01, mmsiInit08_01, idPoint08_01, idInit08_01, speed08_01, i08_01, amount08_01);
        System.out.println("-----~~~~~~~完成 8 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task9() {
        simulateShipUpdatePosition(shipTrack09_01, shipNum09_01, mmsiInit09_01, idPoint09_01, idInit09_01, speed09_01, i09_01, amount09_01);
        System.out.println("-----~~~~~~~完成 9 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task10() {
        simulateShipUpdatePosition(shipTrack10_01, shipNum10_01, mmsiInit10_01, idPoint10_01, idInit10_01, speed10_01, i10_01, amount10_01);
        System.out.println("-----~~~~~~~完成 10 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task11() {
        simulateShipUpdatePosition(shipTrack11_01, shipNum11_01, mmsiInit11_01, idPoint11_01, idInit11_01, speed11_01, i11_01, amount11_01);
        System.out.println("-----~~~~~~~完成 11 ~~~~~------" + LocalDateTime.now());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    private void task12() {
        simulateShipUpdatePosition(shipTrack12_01, shipNum12_01, mmsiInit12_01, idPoint12_01, idInit12_01, speed12_01, i12_01, amount12_01);
        System.out.println("-----~~~~~~~完成 12 ~~~~~------" + LocalDateTime.now());
    }
*/









    /*    int[] speed = {ran.nextInt(speedMax - speedMin + 1) + speedMin,
                ran.nextInt(speedMax - speedMin + 1) + speedMin,
                ran.nextInt(speedMax - speedMin + 1) + speedMin,
                ran.nextInt(speedMax - speedMin + 1) + speedMin,
                ran.nextInt(speedMax - speedMin + 1) + speedMin}; //定义每条船速度*/


    /**
     * 通用方法
     * hj01001 等
     *
     * @param shipTrack
     * @param shipNum
     * @param mmsiInit
     * @param idPoint
     * @param idInit
     * @param speed
     * @param i
     * @param amount
     */
    private void simulateShipUpdatePosition(String shipTrack, int shipNum, int mmsiInit, int[] idPoint, int[] idInit, int[] speed, int[] i, int amount) {
        for (int j = 0; j < shipNum; j++) {

            int mmsi = mmsiInit + j;
            idPoint[j] = idInit[j] + speed[j] * i[j];
            simulateShipInfoService.simulateShipUpdatePosition(shipTrack, mmsi, idPoint[j]);
//            System.out.println("simulateCH02601: " + "  idPoint: " + idPoint1[j] + ", mmsi: " + mmsi + "   *    " + LocalDateTime.now());
            if (idPoint[j] < amount) {
                i[j]++;
            } else {
                i[j] = 1;
            }
        }
    }

    /**
     * channel_point simulateCH02601专用方法
     *
     * @param shipNum1
     * @param mmsiInit1
     * @param idPoint1
     * @param idInit1
     * @param speed1
     * @param i1
     * @param amount1
     */
    private void simulateShipUpdatePositionchannel_point(int shipNum1, int mmsiInit1, int[] idPoint1, int[] idInit1, int[] speed1, int[] i1, int amount1) {
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

    //正向，shipNum条船，得到每条船的下一个idPoint，即位置
    @Scheduled(cron = "1,31 * * * * ?")
    private void simulateTasks() {
/*
        for (int i : idInit) {
            System.out.println(i + " - ");
        }
        for (int i : speed) {
            System.out.println(i + " - ");
        }
*/
        simulateShipUpdatePositionchannel_point(shipNum1, mmsiInit1, idPoint1, idInit1, speed1, i1, amount1);
    }

    //反向，20条，
    @Scheduled(cron = "1,31 * * * * ?")
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

