package com.company.project.schedule;

import com.company.project.service.ShipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 将静态表ship_info_static定时更新经纬度、速度、方向 到 ship_info
 */
@Component
@Configuration
@EnableScheduling
public class ScheduleSimulateNum {

@Autowired
private ShipInfoService shipInfoService;

    public static int uid1 = 1;
    public static int uid2 = 400;
    /**
     * id1Initial 一次查询的第一个数；id2Initial 一次查询的最后一个数
     * num 一次更新的数量； amount 模拟数据总个数； i 第几次更新
     */
    int uid1Init=1;
    int uid2Init=400;

    int num=511;
    int amount=1223734;
    int i=0;
    @Scheduled(cron = "0/1 * * * * ?")
    public void SimulateNum() {
        if (uid2<amount){
            uid1=uid1Init+num*i;
            uid2=uid2Init+num*i;
            i++;
        }
        else {
            uid1=uid1Init;
            uid2=uid2Init;
            i=1;
        }
        System.out.println("ScheduleSimulateNum : " + LocalDateTime.now()+"  uid1: " + uid1+", uid2: " + uid2 +" ^^^^^^^^^^^^^^^^^^^^开始^^^^^ " +LocalDateTime.now() );
        shipInfoService.updateToShipInfoFromStatic(uid1,uid2);
        System.out.println("ScheduleSimulateNum : " + LocalDateTime.now()+"  uid1: " + uid1+", uid2: " + uid2 +" ^^^^^^^^^^^^^^^^^^^^结束^^^^^^ " +LocalDateTime.now() );
    }
}
