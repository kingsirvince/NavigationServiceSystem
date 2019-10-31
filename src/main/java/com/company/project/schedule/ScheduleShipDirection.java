package com.company.project.schedule;

import com.company.project.service.SimulateShipInfoService;
import com.company.project.util.SimulateShipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * 废弃
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

    Integer rowCountSimulateShipInfo = 400;
    Double[] getLongArray1;
    Double[] getLongArray2;
    Double[] getLatArray1;
    Double[] getLatArray2;
    Double[] angle = new Double[rowCountSimulateShipInfo];
    Double[] angleFirst = new Double[rowCountSimulateShipInfo];
    Double[] speed = new Double[rowCountSimulateShipInfo];
    Double[] speedFirst = new Double[rowCountSimulateShipInfo];
    Double precision = 0.0000001;

/*    @Scheduled(cron = "1,31 * * * * ?")
    private void getLongLatArray1() {
        System.out.println("@@@ 一 组 ：    ____________________________________________________________________________________________Time： 开始 " + LocalDateTime.now());

        getLongArray1 = simulateShipUtil.getLongArray();
        getLatArray1 = simulateShipUtil.getLatArray();
        for (Double a : getLongArray1) {
//            System.out.println("一组Long： " + a);
        }
//        System.out.println("一组 ： "+ getLongArray1[0] + LocalDateTime.now());
        System.out.println("@@@ 一 组 ： 0： " + getLongArray1[0] + "   last： " + getLongArray1[getLongArray1.length - 1] + "   _______________________Time：  结束 " + LocalDateTime.now());
    }

    @Scheduled(cron = "21,51 * * * * ?")
    private void getLongLatArray2() {
        System.out.println("￥￥￥ 二 组 ： _·_·__·__·__·__·__·__·_·_·__·__·__·__·__·__·__·_·__·__·__·__·__·__·__·_·__·__·__·__·__·__·_Time： 开始 " + LocalDateTime.now());

        getLongArray2 = simulateShipUtil.getLongArray();
        getLatArray2 = simulateShipUtil.getLatArray();
        for (Double a : getLongArray2) {
//           System.out.println("二组Long:  " + a);
        }
//        System.out.println("二组 ： "+ getLongArray2[0] + LocalDateTime.now());
        System.out.println("￥￥￥ 二 组 ： 0： " + getLongArray1[0] + "   last： " + getLongArray1[getLongArray1.length - 1] + "   _·_·__·__·__·__·__·__·_Time： 结束 " + LocalDateTime.now());
    }



    @Scheduled(cron = "54 * * * * ?")
    public void getAngleAndUpdate() {
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
//            System.out.println("//-@@@@@@id：" + (i+1)+"   //-*******角度："+angleString+"   //------速度："+speedString + "   -------    "+LocalDateTime.now());

        }

    }*/

}

/*    @Scheduled(cron = "0/10 * * * * ?")
    private Double[]  getLongLatArray1() {
        getLongArray1 = simulateShipUtil.getLongArray();
        getLatArray1 = simulateShipUtil.getLatArray();
        for (Double a : getLongArray1) {
//            System.out.println("一组Long： " + a);
        }
        System.out.println("一组 ： "+ getLongArray1[0] + LocalDateTime.now());
        return getLongArray1 ;
    }*/
/*    @Scheduled(cron = "0/10 * * * * ?")
    private Double[] getLatArray1() {

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
    }*/
