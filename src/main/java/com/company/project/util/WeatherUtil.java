package com.company.project.util;

import org.springframework.stereotype.Component;

@Component
public class WeatherUtil {

    public void startWeather() {

    String[] arguments = new String[] {"python", "src\\main\\resources\\python\\weather0918.py"};
        try {
            System.out.println("//--------------------启动天气爬虫----------------------//");
        Process process = Runtime.getRuntime().exec(arguments);

        int re = process.waitFor();
        System.out.println(re);
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

}
