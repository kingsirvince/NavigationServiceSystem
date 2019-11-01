package com.company.project.schedule;

import com.company.project.model.ShipMonitor;
import com.company.project.service.ShipHistoryService;
import com.company.project.service.ShipMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleShipHistory {

    @Autowired
    private ShipHistoryService shipHistoryService;
    @Autowired
    private ShipMonitorService shipMonitorService;

        @Scheduled(cron = "0 */1 * * * ?") //每分钟一次
    private void task() {
        shipHistoryService.uploadToHistory();

            //合并
            String monitorLog = " 上传船舶信息记入历史数据库；   ";
            System.out.println("****************  " + monitorLog + "   ****************  ");
            //写入到ship_monitor表中,监控显示
            ShipMonitor shipMonitor = new ShipMonitor();
            shipMonitor.setMonitorlog(monitorLog);
            shipMonitor.setType("shipHistory");


            shipMonitorService.save(shipMonitor);
    }
}
