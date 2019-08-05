package com.company.project;

import com.company.project.model.Coordinate;
import com.company.project.util.ChannelDivisionIDUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.math.BigDecimal;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//测试航道划分功能
        ChannelDivisionIDUtil channelDivisionIDUtil = new ChannelDivisionIDUtil();
        channelDivisionIDUtil.readExcelInputArray();
        Coordinate coordinate = new Coordinate(BigDecimal.valueOf(120.34058), BigDecimal.valueOf(30.51423));
        String channelDivisionID = channelDivisionIDUtil.getChannelDivisionID(coordinate);
        System.out.println(channelDivisionID+"***///////////-----------------------*******************");
    }
}

