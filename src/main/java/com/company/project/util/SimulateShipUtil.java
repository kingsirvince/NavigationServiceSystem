package com.company.project.util;

import com.company.project.service.SimulateShipInfoService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * 提供随机的模拟船舶初始位置、速度
 * random函数
 */
@Component
public class SimulateShipUtil{

    @Autowired
    public SimulateShipInfoService simulateShipInfoService;

    public static SimulateShipUtil simulateShipUtil;

    public SimulateShipUtil() {

    }
    @PostConstruct
    public void init() {
        simulateShipUtil=this;
        simulateShipUtil.simulateShipInfoService=this.simulateShipInfoService;

    }

    //    int shipNum;
//int randomInt = ran.nextInt(100);
//double d = ran.nextDouble();  0~1;


    Random ran = new Random();




    //
    public int[] getIdInit(int shipNum, int amount) {

        int[] idInit = new int[shipNum];
        for (int i = 0; i < shipNum; i++) {
            idInit[i] = ran.nextInt(amount);
            System.out.println(idInit[i]);
        }
        return idInit;
    }

    public int[] getSpeed(int speedMax, int speedMin, int shipNum) {
        int[] speed = new int[shipNum];
        for (int i = 0; i < shipNum; i++) {
            speed[i] = ran.nextInt(speedMax - speedMin + 1) + speedMin;
            System.out.println(speed[i]);
        }
        return speed;
    }

    /**
     * 将经度从mysql返回的list中，提取到数组getLong中
     * @return
     */
    public Double[] getLongArray() {
        List<Double> listLong = simulateShipUtil.simulateShipInfoService.getLong();

        //list赋值给数组   list.toArray
        Double[] getLong = new Double[listLong.size()];
        listLong.toArray(getLong);
        return getLong;
    }


    public Double[] getLatArray() {
        List<Double> listLat = simulateShipUtil.simulateShipInfoService.getLat();
        Double[] getLat = new Double[listLat.size()];
        listLat.toArray(getLat);
        return getLat;
    }


    /**
     *算角度
     * @param lat_a 纬度1
     * @param lng_a 经度1
     * @param lat_b 纬度2
     * @param lng_b 经度2
     * @return
     */
    public   double getAngle( double lng_a,double lat_a, double lng_b,double lat_b ) {

        double y = Math.sin(lng_b - lng_a) * Math.cos(lat_b);
        double x = Math.cos(lat_a) * Math.sin(lat_b) - Math.sin(lat_a) * Math.cos(lat_b) * Math.cos(lng_b - lng_a);
        double brng = Math.atan2(y, x);

        brng = Math.toDegrees(brng);
        if (brng < 0)
            brng = brng + 360;
        return brng;

    }

    /**
     * 算速度
     */
    public double getSpeed( double lng_a,double lat_a, double lng_b,double lat_b) {
        double x = Math.pow((lng_b - lng_a),2);
        double y = Math.pow((lat_b - lat_a), 2);
        double speed= Math.sqrt(x+y)*111322.2222*3600/1000/1.825;
        return speed;
    }

/* ————————————————
        版权声明：本文为CSDN博主「月光日光」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/xiaobai091220106/article/details/50879414*/

    /**
     * 从航迹excel读取到数组
     * @param filePath
     * @return
     */
    public String[][] readExcelInputArray(String filePath) throws IOException, BiffException {
//        本地读取excel
        String[][] array;

        Workbook readwb = null;
        // List<String> list = new ArrayList<String>();

            // 构建Workbook对象, 只读Workbook对象 直接从本地文件创建Workbook
            //只能读xls格式，xlsx不支持
            readwb = Workbook.getWorkbook(new FileInputStream(new File(filePath)));
            // Sheet的下标是从0开始 获取第一张Sheet表
            Sheet readsheet = readwb.getSheet(0);
            // 获取Sheet表中所包含的总列数
            int rsColumns = readsheet.getColumns();
            // 获取Sheet表中所包含的总行数
            int rsRows = readsheet.getRows();
            // 获取指定单元格的对象引用
             array = (new String[rsColumns][rsRows]);
            for (int i = 0; i < rsColumns; i++) {
                for (int j = 0; j < rsRows; j++) {
                    Cell cell = readsheet.getCell(i, j);
                    // System.out.print(cell.getContents() + " ");
                    // list.add(cell.getContents());
                    array[i][j] = cell.getContents();
                }
            }
            //遍历打印数组
            for (int i = 0; i < rsColumns; i++) {
                for (int j = 0; j < rsRows; j++) {
                    System.out.print( " array["+i+"] [" + j+"] =" +array[i][j] );
                }
                System.out.println("  ");
                System.out.println("---------------------数据分割线-------------+----"+filePath);
            }

        return array;

    }
}