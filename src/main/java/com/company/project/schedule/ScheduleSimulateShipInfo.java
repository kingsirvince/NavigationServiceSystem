package com.company.project.schedule;

import com.company.project.service.ShipInfoService;
import com.company.project.service.ShipInfoStaticService;
import com.company.project.service.SimulateShipInfoService;
import com.company.project.util.SimulateShipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleSimulateShipInfo {
    @Autowired
    private SimulateShipInfoService simulateShipInfoService;
    @Autowired
    private ShipInfoService shipInfoService;
    @Autowired
    private ShipInfoStaticService shipInfoStaticService;
    /**
     * new进来这个类，就可以调用里面方法了
     */
    SimulateShipUtil simulateShipUtil = new SimulateShipUtil();

    /**
     * 正向 12条 航迹
     */
    public static String filePath_hj01001 = "src\\main\\resources\\excel\\hj01001.xls";
    public static String filePath_hj01002 = "src\\main\\resources\\excel\\hj01002.xls";
    public static String filePath_hj01003 = "src\\main\\resources\\excel\\hj01003.xls";
    public static String filePath_hj01004 = "src\\main\\resources\\excel\\hj01004.xls";
    public static String filePath_hj01005 = "src\\main\\resources\\excel\\hj01005.xls";
    public static String filePath_hj01006 = "src\\main\\resources\\excel\\hj01006.xls";
    public static String filePath_hj01007 = "src\\main\\resources\\excel\\hj01007.xls";
    public static String filePath_hj01008 = "src\\main\\resources\\excel\\hj01008.xls";
    public static String filePath_hj01009 = "src\\main\\resources\\excel\\hj01009.xls";
    public static String filePath_hj01010 = "src\\main\\resources\\excel\\hj01010.xls";
    public static String filePath_hj01011 = "src\\main\\resources\\excel\\hj01011.xls";
    public static String filePath_hj01012 = "src\\main\\resources\\excel\\hj01012.xls";
    //把excel航迹经纬度 读入到 数组 array_hj
    String[][] array_hj01001 = simulateShipUtil.readExcelInputArray(filePath_hj01001);
    String[][] array_hj01002 = simulateShipUtil.readExcelInputArray(filePath_hj01002);
    String[][] array_hj01003 = simulateShipUtil.readExcelInputArray(filePath_hj01003);
    String[][] array_hj01004 = simulateShipUtil.readExcelInputArray(filePath_hj01004);
    String[][] array_hj01005 = simulateShipUtil.readExcelInputArray(filePath_hj01005);
    String[][] array_hj01006 = simulateShipUtil.readExcelInputArray(filePath_hj01006);
    String[][] array_hj01007 = simulateShipUtil.readExcelInputArray(filePath_hj01007);
    String[][] array_hj01008 = simulateShipUtil.readExcelInputArray(filePath_hj01008);
    String[][] array_hj01009 = simulateShipUtil.readExcelInputArray(filePath_hj01009);
    String[][] array_hj01010 = simulateShipUtil.readExcelInputArray(filePath_hj01010);
    String[][] array_hj01011 = simulateShipUtil.readExcelInputArray(filePath_hj01011);
    String[][] array_hj01012 = simulateShipUtil.readExcelInputArray(filePath_hj01012);

    /**
     * 反向 12条 航迹
     */
    public static String filePath_hj02001 = "src\\main\\resources\\excel\\hj02001.xls";
    public static String filePath_hj02002 = "src\\main\\resources\\excel\\hj02002.xls";
    public static String filePath_hj02003 = "src\\main\\resources\\excel\\hj02003.xls";
    public static String filePath_hj02004 = "src\\main\\resources\\excel\\hj02004.xls";
    public static String filePath_hj02005 = "src\\main\\resources\\excel\\hj02005.xls";
    public static String filePath_hj02006 = "src\\main\\resources\\excel\\hj02006.xls";
    public static String filePath_hj02007 = "src\\main\\resources\\excel\\hj02007.xls";
    public static String filePath_hj02008 = "src\\main\\resources\\excel\\hj02008.xls";
    public static String filePath_hj02009 = "src\\main\\resources\\excel\\hj02009.xls";
    public static String filePath_hj02010 = "src\\main\\resources\\excel\\hj02010.xls";
    public static String filePath_hj02011 = "src\\main\\resources\\excel\\hj02011.xls";
    public static String filePath_hj02012 = "src\\main\\resources\\excel\\hj02012.xls";
    String[][] array_hj02001 = simulateShipUtil.readExcelInputArray(filePath_hj02001);
    String[][] array_hj02002 = simulateShipUtil.readExcelInputArray(filePath_hj02002);
    String[][] array_hj02003 = simulateShipUtil.readExcelInputArray(filePath_hj02003);
    String[][] array_hj02004 = simulateShipUtil.readExcelInputArray(filePath_hj02004);
    String[][] array_hj02005 = simulateShipUtil.readExcelInputArray(filePath_hj02005);
    String[][] array_hj02006 = simulateShipUtil.readExcelInputArray(filePath_hj02006);
    String[][] array_hj02007 = simulateShipUtil.readExcelInputArray(filePath_hj02007);
    String[][] array_hj02008 = simulateShipUtil.readExcelInputArray(filePath_hj02008);
    String[][] array_hj02009 = simulateShipUtil.readExcelInputArray(filePath_hj02009);
    String[][] array_hj02010 = simulateShipUtil.readExcelInputArray(filePath_hj02010);
    String[][] array_hj02011 = simulateShipUtil.readExcelInputArray(filePath_hj02011);
    String[][] array_hj02012 = simulateShipUtil.readExcelInputArray(filePath_hj02012);

    static String[][] ship = new String[400][5];  // 船的数组，包括400条船。id、经度、维度、角度、速度 5个列

/*@Autowired
private SimulateShipUtil simulateShipUtil;*/

    public static ScheduleSimulateShipInfo scheduleSimulateShipInfo;

    public ScheduleSimulateShipInfo()  {

    }

    @PostConstruct
    public void init() {
        scheduleSimulateShipInfo = this;
        scheduleSimulateShipInfo.simulateShipInfoService = this.simulateShipInfoService;
        scheduleSimulateShipInfo.simulateShipUtil = this.simulateShipUtil;

    }

    /**
     * 计算速度和方向的参数
     */
    Integer rowCountSimulateShipInfo = 400; //动态模拟船总数
    int speedMaxBase = 6;   //基础最大速度（跳跃行数）
    int speedMinBase = 3;   //基础最小速度（跳跃行数）

    Double[] getLongArray1 = new Double[rowCountSimulateShipInfo];
    Double[] getLongArray2 = new Double[rowCountSimulateShipInfo];
    Double[] getLatArray1 = new Double[rowCountSimulateShipInfo];
    Double[] getLatArray2 = new Double[rowCountSimulateShipInfo];
    Double[] angle = new Double[rowCountSimulateShipInfo];
    Double[] speed = new Double[rowCountSimulateShipInfo];
    //    Double[] angleFirst = new Double[rowCountSimulateShipInfo];
    //    Double[] speedFirst = new Double[rowCountSimulateShipInfo];
//    Double precision = 0.0000001;
    int iJudge = 0;
/*    *//** 正向航迹
     * hj01000
     * array_hj01000
     *//*
    String shipTrack00_01 = "hj01000"; //航迹
    int speedMax00_01 = speedMaxBase;     //最大速度
    int speedMin00_01 = speedMinBase;     //最小速度
    int amount00_01 = 14400;    // amount     总行数
    //正向
    int shipNum00_01 = 20;      //船数量
    int[] idInit00_01 = simulateShipUtil.getIdInit(shipNum00_01, amount00_01);
    int[] speed00_01 = simulateShipUtil.getSpeed(speedMax00_01, speedMin00_01, shipNum00_01);
    int shipidInit00_01 = 1;          //从哪条船开始
    int[] idPoint00_01 = new int[shipNum00_01];
    int[] i00_01 = new int[shipNum00_01];*/


    /**
     * hj01001
     */
    String shipTrack01_01 = "hj01001"; //航迹
    int speedMax01_01 = speedMaxBase;     //最大速度
    int speedMin01_01 = speedMinBase;     //最小速度
    int amount01_01 = 10834;    // amount     总行数
    //正向
    int shipNum01_01 = 20;      //船数量
    int[] idInit01_01 = simulateShipUtil.getIdInit(shipNum01_01, amount01_01);
    int[] speed01_01 = simulateShipUtil.getSpeed(speedMax01_01, speedMin01_01, shipNum01_01);
    int shipidInit01_01 = 1;          //从哪条船开始
    int[] idPoint01_01 = new int[shipNum01_01];
    int[] i01_01 = new int[shipNum01_01];

    /**
     * hj01002
     */
    String shipTrack02_01 = "hj01002"; //航迹
    int speedMax02_01 = speedMaxBase;     //最大速度
    int speedMin02_01 = speedMinBase;     //最小速度
    int amount02_01 = 14386;    // amount     总行数
    //正向
    int shipNum02_01 = 20;      //船数量
    int[] idInit02_01 = simulateShipUtil.getIdInit(shipNum02_01, amount02_01);
    int[] speed02_01 = simulateShipUtil.getSpeed(speedMax02_01, speedMin02_01, shipNum02_01);
    int shipidInit02_01 = shipNum01_01+shipidInit01_01;          //从哪条船开始
    int[] idPoint02_01 = new int[shipNum02_01];
    int[] i02_01 = new int[shipNum02_01];
    /**
     * hj01003
     */
    String shipTrack03_01 = "hj01003"; //航迹
    int speedMax03_01 = speedMaxBase;     //最大速度
    int speedMin03_01 = speedMinBase;     //最小速度
    int amount03_01 = 13450;    // amount     总行数
    //正向
    int shipNum03_01 = 20;      //船数量
    int[] idInit03_01 = simulateShipUtil.getIdInit(shipNum03_01, amount03_01);
    int[] speed03_01 = simulateShipUtil.getSpeed(speedMax03_01, speedMin03_01, shipNum03_01);
    int shipidInit03_01 = shipNum02_01+shipidInit02_01;          //从哪条船开始
    int[] idPoint03_01 = new int[shipNum03_01];
    int[] i03_01 = new int[shipNum03_01];
    /**
     * hj01004
     */
    String shipTrack04_01 = "hj01004"; //航迹
    int speedMax04_01 = speedMaxBase;     //最大速度
    int speedMin04_01 = speedMinBase;     //最小速度
    int amount04_01 = 13552;    // amount     总行数
    //正向
    int shipNum04_01 = 20;      //船数量
    int[] idInit04_01 = simulateShipUtil.getIdInit(shipNum04_01, amount04_01);
    int[] speed04_01 = simulateShipUtil.getSpeed(speedMax04_01, speedMin04_01, shipNum04_01);
    int shipidInit04_01 = shipNum03_01+shipidInit03_01;          //从哪条船开始
    int[] idPoint04_01 = new int[shipNum04_01];
    int[] i04_01 = new int[shipNum04_01];
    /**
     * hj01005
     */
    String shipTrack05_01 = "hj01005"; //航迹
    int speedMax05_01 = speedMaxBase;     //最大速度
    int speedMin05_01 = speedMinBase;     //最小速度
    int amount05_01 = 15683;    // amount     总行数
    //正向
    int shipNum05_01 = 20;      //船数量
    int[] idInit05_01 = simulateShipUtil.getIdInit(shipNum05_01, amount05_01);
    int[] speed05_01 = simulateShipUtil.getSpeed(speedMax05_01, speedMin05_01, shipNum05_01);
    int shipidInit05_01 = shipNum04_01+shipidInit04_01;          //从哪条船开始
    int[] idPoint05_01 = new int[shipNum05_01];
    int[] i05_01 = new int[shipNum05_01];
    /**
     * hj01006
     */
    String shipTrack06_01 = "hj01006"; //航迹
    int speedMax06_01 = speedMaxBase;     //最大速度
    int speedMin06_01 = speedMinBase;     //最小速度
    int amount06_01 = 13236;    // amount     总行数
    //正向
    int shipNum06_01 = 20;      //船数量
    int[] idInit06_01 = simulateShipUtil.getIdInit(shipNum06_01, amount06_01);
    int[] speed06_01 = simulateShipUtil.getSpeed(speedMax06_01, speedMin06_01, shipNum06_01);
    int shipidInit06_01 = shipNum05_01+shipidInit05_01;          //从哪条船开始
    int[] idPoint06_01 = new int[shipNum06_01];
    int[] i06_01 = new int[shipNum06_01];
    /**
     * hj01007
     */
    String shipTrack07_01 = "hj01007"; //航迹
    int speedMax07_01 = speedMaxBase;     //最大速度
    int speedMin07_01 = speedMinBase;     //最小速度
    int amount07_01 = 3914;    // amount     总行数
    //正向
    int shipNum07_01 = 10;      //船数量
    int[] idInit07_01 = simulateShipUtil.getIdInit(shipNum07_01, amount07_01);
    int[] speed07_01 = simulateShipUtil.getSpeed(speedMax07_01, speedMin07_01, shipNum07_01);
    int shipidInit07_01 = shipNum06_01+shipidInit06_01;          //从哪条船开始
    int[] idPoint07_01 = new int[shipNum07_01];
    int[] i07_01 = new int[shipNum07_01];
    /**
     * hj01008
     */
    String shipTrack08_01 = "hj01008"; //航迹
    int speedMax08_01 = speedMaxBase;     //最大速度
    int speedMin08_01 = speedMinBase;     //最小速度
    int amount08_01 = 5073;    // amount     总行数
    //正向
    int shipNum08_01 = 10;      //船数量
    int[] idInit08_01 = simulateShipUtil.getIdInit(shipNum08_01, amount08_01);
    int[] speed08_01 = simulateShipUtil.getSpeed(speedMax08_01, speedMin08_01, shipNum08_01);
    int shipidInit08_01 = shipNum07_01+shipidInit07_01;          //从哪条船开始
    int[] idPoint08_01 = new int[shipNum08_01];
    int[] i08_01 = new int[shipNum08_01];
    /**
     * hj01009
     */
    String shipTrack09_01 = "hj01009"; //航迹
    int speedMax09_01 = speedMaxBase;     //最大速度
    int speedMin09_01 = speedMinBase;     //最小速度
    int amount09_01 = 7189;    // amount     总行数
    //正向
    int shipNum09_01 = 10;      //船数量
    int[] idInit09_01 = simulateShipUtil.getIdInit(shipNum09_01, amount09_01);
    int[] speed09_01 = simulateShipUtil.getSpeed(speedMax09_01, speedMin09_01, shipNum09_01);
    int shipidInit09_01 = shipNum08_01+shipidInit08_01;          //从哪条船开始
    int[] idPoint09_01 = new int[shipNum09_01];
    int[] i09_01 = new int[shipNum09_01];
    /**
     * hj01010
     */
    String shipTrack10_01 = "hj01010"; //航迹
    int speedMax10_01 = speedMaxBase;     //最大速度
    int speedMin10_01 = speedMinBase;     //最小速度
    int amount10_01 = 12174;    // amount     总行数
    //正向
    int shipNum10_01 = 20;      //船数量
    int[] idInit10_01 = simulateShipUtil.getIdInit(shipNum10_01, amount10_01);
    int[] speed10_01 = simulateShipUtil.getSpeed(speedMax10_01, speedMin10_01, shipNum10_01);
    int shipidInit10_01 = shipNum09_01+shipidInit09_01;          //从哪条船开始
    int[] idPoint10_01 = new int[shipNum10_01];
    int[] i10_01 = new int[shipNum10_01];
    /**
     * hj01011
     */
    String shipTrack11_01 = "hj01011"; //航迹
    int speedMax11_01 = speedMaxBase;     //最大速度
    int speedMin11_01 = speedMinBase;     //最小速度
    int amount11_01 = 6227;    // amount     总行数
    //正向
    int shipNum11_01 = 10;      //船数量
    int[] idInit11_01 = simulateShipUtil.getIdInit(shipNum11_01, amount11_01);
    int[] speed11_01 = simulateShipUtil.getSpeed(speedMax11_01, speedMin11_01, shipNum11_01);
    int shipidInit11_01 = shipNum10_01+shipidInit10_01;          //从哪条船开始
    int[] idPoint11_01 = new int[shipNum11_01];
    int[] i11_01 = new int[shipNum11_01];
    /**
     * hj01012
     */
    String shipTrack12_01 = "hj01012"; //航迹
    int speedMax12_01 = speedMaxBase;     //最大速度
    int speedMin12_01 = speedMinBase;     //最小速度
    int amount12_01 = 13838;    // amount     总行数
    //正向
    int shipNum12_01 = 20;      //船数量
    int[] idInit12_01 = simulateShipUtil.getIdInit(shipNum12_01, amount12_01);
    int[] speed12_01 = simulateShipUtil.getSpeed(speedMax12_01, speedMin12_01, shipNum12_01);
    int shipidInit12_01 = shipNum11_01+shipidInit11_01;          //从哪条船开始
    int[] idPoint12_01 = new int[shipNum12_01];
    int[] i12_01 = new int[shipNum12_01];


    /** 反向航迹
     * hj02001
     */
    int speedMax02001 = speedMaxBase;     //最大速度
    int speedMin02001 = speedMinBase;     //最小速度
    int amount02001 = 19703;    // amount     总行数
    //正向
    int shipNum02001 = 20;      //船数量
    int[] idInit02001 = simulateShipUtil.getIdInit(shipNum02001, amount02001);
    int[] speed02001 = simulateShipUtil.getSpeed(speedMax02001, speedMin02001, shipNum02001);
    int shipidInit02001 = shipNum12_01+shipidInit12_01;          //从哪条船开始
    int[] idPoint02001 = new int[shipNum02001];
    int[] i02001 = new int[shipNum02001];
    /** 
     * hj02002
     */
    int speedMax02002 = speedMaxBase;     //最大速度
    int speedMin02002 = speedMinBase;     //最小速度
    int amount02002 = 14272;    // amount     总行数
    //正向
    int shipNum02002 = 20;      //船数量
    int[] idInit02002 = simulateShipUtil.getIdInit(shipNum02002, amount02002);
    int[] speed02002 = simulateShipUtil.getSpeed(speedMax02002, speedMin02002, shipNum02002);
    int shipidInit02002 = shipNum02001+shipidInit02001;          //从哪条船开始
    int[] idPoint02002 = new int[shipNum02002];
    int[] i02002 = new int[shipNum02002];
    /** 反向航迹
     * hj02003
     */
    int speedMax02003 = speedMaxBase;     //最大速度
    int speedMin02003 = speedMinBase;     //最小速度
    int amount02003 = 14978;    // amount     总行数
    //正向
    int shipNum02003 = 20;      //船数量
    int[] idInit02003 = simulateShipUtil.getIdInit(shipNum02003, amount02003);
    int[] speed02003 = simulateShipUtil.getSpeed(speedMax02003, speedMin02003, shipNum02003);
    int shipidInit02003 =  shipNum02002+shipidInit02002;          //从哪条船开始
    int[] idPoint02003 = new int[shipNum02003];
    int[] i02003 = new int[shipNum02003];
    /** 反向航迹
     * hj02004
     */
    int speedMax02004 = speedMaxBase;     //最大速度
    int speedMin02004 = speedMinBase;     //最小速度
    int amount02004 = 15702;    // amount     总行数
    //正向
    int shipNum02004 = 20;      //船数量
    int[] idInit02004 = simulateShipUtil.getIdInit(shipNum02004, amount02004);
    int[] speed02004 = simulateShipUtil.getSpeed(speedMax02004, speedMin02004, shipNum02004);
    int shipidInit02004 = shipNum02003+shipidInit02003;           //从哪条船开始
    int[] idPoint02004 = new int[shipNum02004];
    int[] i02004 = new int[shipNum02004];
    /** 反向航迹
     * hj02005
     */
    int speedMax02005 = speedMaxBase;     //最大速度
    int speedMin02005 = speedMinBase;     //最小速度
    int amount02005 = 15635;    // amount     总行数
    //正向
    int shipNum02005 = 20;      //船数量
    int[] idInit02005 = simulateShipUtil.getIdInit(shipNum02005, amount02005);
    int[] speed02005 = simulateShipUtil.getSpeed(speedMax02005, speedMin02005, shipNum02005);
    int shipidInit02005 = shipNum02004+shipidInit02004;          //从哪条船开始
    int[] idPoint02005 = new int[shipNum02005];
    int[] i02005 = new int[shipNum02005];
    /** 反向航迹
     * hj02006
     */
    int speedMax02006 = speedMaxBase;     //最大速度
    int speedMin02006 = speedMinBase;     //最小速度
    int amount02006 = 13117;    // amount     总行数
    //正向
    int shipNum02006 = 20;      //船数量
    int[] idInit02006 = simulateShipUtil.getIdInit(shipNum02006, amount02006);
    int[] speed02006 = simulateShipUtil.getSpeed(speedMax02006, speedMin02006, shipNum02006);
    int shipidInit02006 = shipNum02005+shipidInit02005;           //从哪条船开始
    int[] idPoint02006 = new int[shipNum02006];
    int[] i02006 = new int[shipNum02006];
    /** 反向航迹
     * hj02007
     */
    int speedMax02007 = speedMaxBase;     //最大速度
    int speedMin02007 = speedMinBase;     //最小速度
    int amount02007 = 5564;    // amount     总行数
    //正向
    int shipNum02007 = 10;      //船数量
    int[] idInit02007 = simulateShipUtil.getIdInit(shipNum02007, amount02007);
    int[] speed02007 = simulateShipUtil.getSpeed(speedMax02007, speedMin02007, shipNum02007);
    int shipidInit02007 = shipNum02006+shipidInit02006;           //从哪条船开始
    int[] idPoint02007 = new int[shipNum02007];
    int[] i02007 = new int[shipNum02007];
    /** 反向航迹
     * hj02008
     */
    int speedMax02008 = speedMaxBase;     //最大速度
    int speedMin02008 = speedMinBase;     //最小速度
    int amount02008 = 7154;    // amount     总行数
    //正向
    int shipNum02008 = 10;      //船数量
    int[] idInit02008 = simulateShipUtil.getIdInit(shipNum02008, amount02008);
    int[] speed02008 = simulateShipUtil.getSpeed(speedMax02008, speedMin02008, shipNum02008);
    int shipidInit02008 = shipNum02007+shipidInit02007;           //从哪条船开始
    int[] idPoint02008 = new int[shipNum02008];
    int[] i02008 = new int[shipNum02008];
    /** 反向航迹
     * hj02009
     */
    int speedMax02009 = speedMaxBase;     //最大速度
    int speedMin02009 = speedMinBase;     //最小速度
    int amount02009 = 7189;    // amount     总行数
    //正向
    int shipNum02009 = 10;      //船数量
    int[] idInit02009 = simulateShipUtil.getIdInit(shipNum02009, amount02009);
    int[] speed02009 = simulateShipUtil.getSpeed(speedMax02009, speedMin02009, shipNum02009);
    int shipidInit02009 = shipNum02008+shipidInit02008;           //从哪条船开始
    int[] idPoint02009 = new int[shipNum02009];
    int[] i02009 = new int[shipNum02009];
    /** 反向航迹
     * hj02010
     */
    int speedMax02010 = speedMaxBase;     //最大速度
    int speedMin02010 = speedMinBase;     //最小速度
    int amount02010 = 13825;    // amount     总行数
    //正向
    int shipNum02010 = 20;      //船数量
    int[] idInit02010 = simulateShipUtil.getIdInit(shipNum02010, amount02010);
    int[] speed02010 = simulateShipUtil.getSpeed(speedMax02010, speedMin02010, shipNum02010);
    int shipidInit02010 = shipNum02009+shipidInit02009;           //从哪条船开始
    int[] idPoint02010 = new int[shipNum02010];
    int[] i02010 = new int[shipNum02010];
    /** 反向航迹
     * hj02011
     */
    int speedMax02011 = speedMaxBase;     //最大速度
    int speedMin02011 = speedMinBase;     //最小速度
    int amount02011 = 7890;    // amount     总行数
    //正向
//    int shipNum02011 = 30;      //船数量
    int shipNum02011 = 10;      //船数量
    int[] idInit02011 = simulateShipUtil.getIdInit(shipNum02011, amount02011);
    int[] speed02011 = simulateShipUtil.getSpeed(speedMax02011, speedMin02011, shipNum02011);
    int shipidInit02011 = shipNum02010+shipidInit02010;           //从哪条船开始
    int[] idPoint02011 = new int[shipNum02011];
    int[] i02011 = new int[shipNum02011];
    /** 反向航迹
     * hj02012
     */
    int speedMax02012 = speedMaxBase;     //最大速度
    int speedMin02012 = speedMinBase;     //最小速度
    int amount02012 = 13527;    // amount     总行数
    //正向
    int shipNum02012 = 20;      //船数量
    int[] idInit02012 = simulateShipUtil.getIdInit(shipNum02012, amount02012);
    int[] speed02012 = simulateShipUtil.getSpeed(speedMax02012, speedMin02012, shipNum02012);
    int shipidInit02012 = shipNum02011+shipidInit02011;          //从哪条船开始
    int[] idPoint02012 = new int[shipNum02012];
    int[] i02012 = new int[shipNum02012];



    /**
     * 航迹数组赋值给ship数组  (正向）经纬度  hj01001~hj01012
     * @param array_hj
     * @param shipNum
     * @param shipidInit
     * @param idPoint
     * @param idInit
     * @param speed
     * @param i
     * @param amount
     */
    private void shipArrayGetPosition(String[][] array_hj, int shipNum, int shipidInit, int[] idPoint, int[] idInit, int[] speed, int[] i, int amount) {
        for (int j = 0; j < shipNum; j++) {

            int shipid = shipidInit + j;
            idPoint[j] = idInit[j] + speed[j] * i[j];
            if (idPoint[j] >= amount - 1) {
                idPoint[j] = amount - 1;
            }
            //shipid赋值
            ship[shipid - 1][0] = String.valueOf(shipid);
            //经度  (航迹数组赋值给ship数组）
            ship[shipid - 1][1] = array_hj[1][idPoint[j]];
            //纬度
            ship[shipid - 1][2] = array_hj[2][idPoint[j]];

            if (idPoint[j] < amount-1) {
                i[j]++;
            } else {
                i[j] = 1;
            }
        }
    }
    /**
     * 航迹数组赋值给ship数组  (反向）经纬度   hj02001~hj02012
     * @param array_hj
     * @param shipNum
     * @param shipidInit
     * @param idPoint
     * @param idInit
     * @param speed
     * @param i
     * @param amount
     */
    private void shipArrayGetPositionReverse(String[][] array_hj, int shipNum, int shipidInit, int[] idPoint, int[] idInit, int[] speed, int[] i, int amount) {
        for (int j = 0; j < shipNum; j++) {

            int shipid = shipidInit + j;
            idPoint[j] = idInit[j] - speed[j] * i[j];
            if (idPoint[j] <= 1) {
                idPoint[j] = 1;
            }
            //shipid赋值
            ship[shipid - 1][0] = String.valueOf(shipid);
            //经度  (航迹数组赋值给ship数组）
            ship[shipid - 1][1] = array_hj[1][idPoint[j]];
            //纬度
            ship[shipid - 1][2] = array_hj[2][idPoint[j]];

            if (idPoint[j] > 1) {
                i[j]++;
            } else {
                i[j] = 1;
            }
        }
    }


    /**
     * New
     * 新简化任务
     */
    @Scheduled(cron = "0/2 * * * * ?")
    private void taskNew() {
        //得到经纬度赋值该  经度：ship[x][1]  纬度：ship[x][2] ;
        //正向航迹12条
        shipArrayGetPosition(array_hj01001, shipNum01_01, shipidInit01_01, idPoint01_01, idInit01_01, speed01_01, i01_01, amount01_01);
        shipArrayGetPosition(array_hj01002, shipNum02_01, shipidInit02_01, idPoint02_01, idInit02_01, speed02_01, i02_01, amount02_01);
        shipArrayGetPosition(array_hj01003, shipNum03_01, shipidInit03_01, idPoint03_01, idInit03_01, speed03_01, i03_01, amount03_01);
        shipArrayGetPosition(array_hj01004, shipNum04_01, shipidInit04_01, idPoint04_01, idInit04_01, speed04_01, i04_01, amount04_01);
        shipArrayGetPosition(array_hj01005, shipNum05_01, shipidInit05_01, idPoint05_01, idInit05_01, speed05_01, i05_01, amount05_01);
        shipArrayGetPosition(array_hj01006, shipNum06_01, shipidInit06_01, idPoint06_01, idInit06_01, speed06_01, i06_01, amount06_01);
        shipArrayGetPosition(array_hj01007, shipNum07_01, shipidInit07_01, idPoint07_01, idInit07_01, speed07_01, i07_01, amount07_01);
        shipArrayGetPosition(array_hj01008, shipNum08_01, shipidInit08_01, idPoint08_01, idInit08_01, speed08_01, i08_01, amount08_01);
        shipArrayGetPosition(array_hj01009, shipNum09_01, shipidInit09_01, idPoint09_01, idInit09_01, speed09_01, i09_01, amount09_01);
        shipArrayGetPosition(array_hj01010, shipNum10_01, shipidInit10_01, idPoint10_01, idInit10_01, speed10_01, i10_01, amount10_01);
        shipArrayGetPosition(array_hj01011, shipNum11_01, shipidInit11_01, idPoint11_01, idInit11_01, speed11_01, i11_01, amount11_01);
        shipArrayGetPosition(array_hj01012, shipNum12_01, shipidInit12_01, idPoint12_01, idInit12_01, speed12_01, i12_01, amount12_01);
        //反向
        shipArrayGetPositionReverse(array_hj02001, shipNum02001, shipidInit02001, idPoint02001, idInit02001, speed02001, i02001, amount02001);
        shipArrayGetPositionReverse(array_hj02002, shipNum02002, shipidInit02002, idPoint02002, idInit02002, speed02002, i02002, amount02002);
        shipArrayGetPositionReverse(array_hj02003, shipNum02003, shipidInit02003, idPoint02003, idInit02003, speed02003, i02003, amount02003);
        shipArrayGetPositionReverse(array_hj02004, shipNum02004, shipidInit02004, idPoint02004, idInit02004, speed02004, i02004, amount02004);
        shipArrayGetPositionReverse(array_hj02005, shipNum02005, shipidInit02005, idPoint02005, idInit02005, speed02005, i02005, amount02005);
        shipArrayGetPositionReverse(array_hj02006, shipNum02006, shipidInit02006, idPoint02006, idInit02006, speed02006, i02006, amount02006);
        shipArrayGetPositionReverse(array_hj02007, shipNum02007, shipidInit02007, idPoint02007, idInit02007, speed02007, i02007, amount02007);
        shipArrayGetPositionReverse(array_hj02008, shipNum02008, shipidInit02008, idPoint02008, idInit02008, speed02008, i02008, amount02008);
        shipArrayGetPositionReverse(array_hj02009, shipNum02009, shipidInit02009, idPoint02009, idInit02009, speed02009, i02009, amount02009);
        shipArrayGetPositionReverse(array_hj02010, shipNum02010, shipidInit02010, idPoint02010, idInit02010, speed02010, i02010, amount02010);
        shipArrayGetPositionReverse(array_hj02011, shipNum02011, shipidInit02011, idPoint02011, idInit02011, speed02011, i02011, amount02011);
        shipArrayGetPositionReverse(array_hj02012, shipNum02012, shipidInit02012, idPoint02012, idInit02012, speed02012, i02012, amount02012);


        //计算方向、速度   方向：ship[x][3]  速度：ship[x][4]
        //第一遍不计算；
        if (iJudge == 0) {
            for (int i = 0; i < rowCountSimulateShipInfo; i++) {
                getLongArray2[i] = Double.valueOf(ship[i][1]);
                getLatArray2[i] = Double.valueOf(ship[i][2]);
                System.out.println("----------正常-------------  getLongArray2[i] = " + getLongArray2  +"  --  i = "+i );

            }
        }
        //第二遍开始计算
        if (iJudge != 0) {
            for (int i = 0; i < rowCountSimulateShipInfo; i++) {
                getLongArray1[i] = getLongArray2[i];
                getLatArray1[i] = getLatArray2[i];

                getLongArray2[i] = Double.valueOf(ship[i][1]);
                getLatArray2[i] = Double.valueOf(ship[i][2]);


                angle[i] = simulateShipUtil.getAngle(getLongArray1[i], getLatArray1[i], getLongArray2[i], getLatArray2[i]);
                speed[i] = simulateShipUtil.getSpeed(getLongArray1[i], getLatArray1[i], getLongArray2[i], getLatArray2[i]);
                ship[i][3] = String.format("%.2f", angle[i]); //转成String，保留2位小数，四舍五入
                ship[i][4] = String.format("%.2f", speed[i]);
            }
            for (int i = 0; i < rowCountSimulateShipInfo; i++) {
                simulateShipInfoService.insertLongLatAngleSpeedToStatic(
                        Double.valueOf(ship[i][1]),
                        Double.valueOf(ship[i][2]),
                        ship[i][3],
                        ship[i][4],
                        Integer.valueOf(ship[i][0]));
//                System.out.println(ship[i][0] + "  " + ship[i][1] + "  " + ship[i][2] + "  " + ship[i][3] + "  " + ship[i][4]);

            }
            System.out.println("/-----------------One Time-------  : "+ LocalDateTime.now());

//新增到static表
//            shipInfoStaticService.updateToShipInfoStatic();
//            System.out.println("```````````从模拟表simulate_ship_info更新 经纬度/速度/方向 新增到ship_info_static形成静态长表·············· 2 ····" + LocalDateTime.now());
//            for (int i = 0; i < rowCountSimulateShipInfo; i++) {
//                simulateShipInfoService.updateLongLatAngleSpeed(
//                        Double.valueOf(ship[i][1]),
//                        Double.valueOf(ship[i][2]),
//                        ship[i][3],
//                        ship[i][4],
//                        Integer.valueOf(ship[i][0]));
//                System.out.println(ship[i][0] + "  " + ship[i][1] + "  " + ship[i][2] + "  " + ship[i][3] + "  " + ship[i][4]);
//
//            }
//
////新增到static表
//            shipInfoStaticService.updateToShipInfoStatic();
//            System.out.println("```````````从模拟表simulate_ship_info更新 经纬度/速度/方向 新增到ship_info_static形成静态长表·············· 2 ····" + LocalDateTime.now());

        }

        iJudge++;
    }





//    public static BlockingQueue<Boat> queue = new ArrayBlockingQueue<>(10000);


    /**
     * 通用方法simulateShipUpdatePosition
     * hj01001 hj01002 ... hj01012
     */


    /**
     *  制作数据用：正常运行屏蔽掉
     */
   /* @Scheduled(cron = "0/10 * * * * ?")
    private void task() {
*//*      姚滕俊：
        for (40){

            计算各参数 经纬度，角度，速度 （判断逻辑2是不是0，不是0的话，把2的值付给1，把2更新成新值）

            queue.add(new Boat(idInit01_01,));
        }
        for(40)

*//*
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

        if (iJudge % 2 != 0) {
            System.out.println("@@@ A1 ：    _________________________________________________________________________________________A1 ___Time： 开始 " + LocalDateTime.now());
            try {
                getLongArray1 = simulateShipUtil.getLongArray();
                getLatArray1 = simulateShipUtil.getLatArray();
            } catch (Exception e) {
                System.out.println("___________________");
                System.out.println(e.getMessage());
                System.out.println("___________________");
            }
            getAngleSpeedAndUpdateA1SubtractA2();
            System.out.println("```````````将经纬度/速度/方向赋值更新刀模拟表simulate_ship_info········A1-A2······ 1 ····" + LocalDateTime.now());

        }
//i为偶数  A2赋值  A2-A1
        if (iJudge % 2 == 0) {
            if (iJudge == 0) {
                System.out.println("￥￥￥ A2 ：    __·_·__·__·__·__·__·__·_·_·__·__·__·_&&&&&&&&&&&&_·____A2: iJudge=0 ___Time： 开始 " + LocalDateTime.now());
                getLongArray2 = simulateShipUtil.getLongArray();
                getLatArray2 = simulateShipUtil.getLatArray();
            } else {
                System.out.println("￥￥￥ A2 ：    __·_·__·__·__·__·__·__·_·_·__·__·__·__·__·__·__·_·__·__·__·__·__·__·__·_·__·__·__·____A2 ___Time： 开始 " + LocalDateTime.now());
                getLongArray2 = simulateShipUtil.getLongArray();
                getLatArray2 = simulateShipUtil.getLatArray();
                getAngleSpeedAndUpdateA2SubtractA1();
                System.out.println("```````````将经纬度/速度/方向赋值更新刀模拟表simulate_ship_info·········A2-A1····· 1 ····" + LocalDateTime.now());

            }
        }
        if (iJudge != 0) {

            shipInfoStaticService.updateToShipInfoStatic();
        System.out.println("```````````从模拟表simulate_ship_info更新 经纬度/速度/方向 新增到ship_info_static形成静态长表·············· 2 ····" + LocalDateTime.now());
        }
        iJudge++;
    }

    */


    /**
     * 计算速度和方向并更新到表
     * A2-A1  i为偶数
     */
/*    private void getAngleSpeedAndUpdateA2SubtractA1() {
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
            ship[i][3] = String.format("%.2f", angle[i]); //转成String，保留2位小数，四舍五入
            ship[i][4] = String.format("%.2f", speed[i]);
            simulateShipInfoService.updateLongLatAngleSpeed(Double.valueOf(ship[i][1]), Double.valueOf(ship[i][2]), ship[i][3], ship[i][4], i + 1);
            System.out.println("//-@@@@@@id：" + (i + 1) + "   //-***经度：" + Double.valueOf(ship[i][1]) + " 纬度：" + Double.valueOf(ship[i][2]) + "  **角度：" + ship[i][3] + " --速度：" + ship[i][4] + "   ---  A2-A1 ----    " + LocalDateTime.now());
        }
    }*/

    /**
     * 计算速度和方向并更新到表
     * A1-A2  i为奇数
     */
/*
    private void getAngleSpeedAndUpdateA1SubtractA2() {
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
            ship[i][3] = String.format("%.2f", angle[i]); //转成String，保留2位小数，四舍五入
            ship[i][4] = String.format("%.2f", speed[i]);
            simulateShipInfoService.updateLongLatAngleSpeed(Double.valueOf(ship[i][1]), Double.valueOf(ship[i][2]), ship[i][3], ship[i][4], i + 1);
            System.out.println("//-@@@@@@id：" + (i + 1) + "   //-***经度：" + Double.valueOf(ship[i][1]) + " 纬度：" + Double.valueOf(ship[i][2]) + "  **角度：" + ship[i][3] + " --速度：" + ship[i][4] + "   ---  A1-A2 ----    " + LocalDateTime.now());

        }
    }
*/



/*    private void simulateShipUpdatePosition(String shipTrack, int shipNum, int mmsiInit, int[] idPoint, int[] idInit, int[] speed, int[] i, int amount) {
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
    }*/




 /*   *//**
     * channel_point simulateCH02601专用方法
     *
     * @param shipNum1
     * @param mmsiInit1
     * @param idPoint1
     * @param idInit1
     * @param speed1
     * @param i1
     * @param amount1
     *//*
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
    }*/
/**
 *  制作数据用：正常运行屏蔽掉
 *
 */
    //正向，shipNum条船，得到每条船的下一个idPoint，即位置
/*    @Scheduled(cron = "1,31 * * * * ?")
    private void simulateTasks() {

        simulateShipUpdatePositionchannel_point(shipNum1, mmsiInit1, idPoint1, idInit1, speed1, i1, amount1);
    }

    //反向，20条，
    @Scheduled(cron = "1,31 * * * * ?")
    private void simulateTasks1() {

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
    }*/


}



