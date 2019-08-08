package com.company.project;

import com.company.project.util.ChannelDivisionIDUtil;
import com.company.project.util.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication(scanBasePackages = {"com.company.project.util"})
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@Import(SpringContextUtil.class)
@MapperScan("com.company.project.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//测试航道划分功能,读取excel，得到航道划分数组
//        ChannelDivisionIDUtil channelDivisionIDUtil = new ChannelDivisionIDUtil();(已经改为静态方法，所以不用生成一个新对象）
        ChannelDivisionIDUtil.readExcelInputArray();

//        Coordinate coordinate = new Coordinate(BigDecimal.valueOf(120.319925957), BigDecimal.valueOf(30.5048366694));
//       //计算航道划分ID
//        String channelDivisionID = channelDivisionIDUtil.getChannelDivisionID(coordinate);
//        System.out.println(channelDivisionID+"***///////////-----------------------*******************");
//        计算周边航道划分ID
//        String[] nearbyChannelDivisionID = channelDivisionIDUtil.getNearbyChannelDivisionID(channelDivisionID);
//        for (int i=0;i<nearbyChannelDivisionID.length;i++){
//            System.out.println("$$$$$$$$$$$$$$$$$$$--周围航道划分："+nearbyChannelDivisionID[i]);}


    }
}

