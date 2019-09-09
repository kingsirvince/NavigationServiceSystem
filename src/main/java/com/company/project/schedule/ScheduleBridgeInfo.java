package com.company.project.schedule;

import com.company.project.service.BridgeInfoService;
import com.company.project.service.FloodgateInfoService;
import com.company.project.service.PipelineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleBridgeInfo {

    @Autowired
    private BridgeInfoService bridgeInfoService;
    @Autowired //自动装配要每个都写注解，否则会没有装配进来，空指针报错
    private FloodgateInfoService floodgateInfoService;
    @Autowired
    private PipelineInfoService pipelineInfoService;

    @Scheduled(cron = "0 0/1 * * * ?") //每分钟一次
    private void task() {
        Random ran = new Random();
        Double subtrahend = (1 + ran.nextDouble());
        floodgateInfoService.updateLimitHeight(subtrahend);
        bridgeInfoService.updateLimitHeight(subtrahend);
        pipelineInfoService.updateLimitHeight(subtrahend);


    }
}
