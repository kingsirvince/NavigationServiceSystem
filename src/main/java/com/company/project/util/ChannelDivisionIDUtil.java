package com.company.project.util;

import com.company.project.model.Coordinate;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;

@Component
public class ChannelDivisionIDUtil {


    static String[][] arrayCD;

    public static void readExcelInputArray() {

        /*
        本地读取excel
         */
        jxl.Workbook readwb = null;
        // List<String> list = new ArrayList<String>();
        try {
            // 构建Workbook对象, 只读Workbook对象 直接从本地文件创建Workbook
            //只能读xls格式，xlsx不支持
            readwb = Workbook.getWorkbook(new FileInputStream(new File("D:\\Dev\\IDEA\\【20190726】spring-boot-api-project-seed-boat\\spring-boot-api-project-seed\\src\\main\\resources\\ChannelDivision.xls")));
            // Sheet的下标是从0开始 获取第一张Sheet表
            Sheet readsheet = readwb.getSheet(0);
            // 获取Sheet表中所包含的总列数
            int rsColumns = readsheet.getColumns();
            // 获取Sheet表中所包含的总行数
            int rsRows = readsheet.getRows();
            // 获取指定单元格的对象引用
            arrayCD = (new String[rsColumns][rsRows]);
            for (int i = 0; i < rsColumns; i++) {
                for (int j = 0; j < rsRows; j++) {
                    Cell cell = readsheet.getCell(i, j);
                    // System.out.print(cell.getContents() + " ");
                    // list.add(cell.getContents());
                    arrayCD[i][j] = cell.getContents();
                }
            }
            for (int i = 0; i < rsColumns; i++) {
                for (int j = 0; j < rsRows; j++) {
                    System.out.print(arrayCD[i][j] + " ");
                }
                System.out.println("------------数据分割线-----------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readwb.close();
        }

    }

    /**
     * 计算经纬度，得到航道划分ID
     * ChannelDivision 简写CD，arrayChannelDivision简写arrayCD
     *
     * @param coordinate
     * @return channelDivisionID
     */
    public static String getChannelDivisionID(Coordinate coordinate) {

        String channelDivisionID = "";
        BigDecimal longitude = coordinate.getLongitude();
        BigDecimal latitude = coordinate.getLatitude();
        Double longitudeDouble = longitude.doubleValue();//bigdecimal转double
        Double latitudeDouble = latitude.doubleValue();


        System.out.println( "******************开始计算航道划分***********************************************");

        for (int j = 0; j < 255; j++) {
            Double longitude_max, longitude_min, latitude_max, latitude_min;

            longitude_max = Double.valueOf(arrayCD[1][j]);
            longitude_min = Double.valueOf(arrayCD[2][j]);
            latitude_max = Double.valueOf(arrayCD[3][j]);
            latitude_min = Double.valueOf(arrayCD[4][j]);


            if (!(longitude_min > longitudeDouble || longitudeDouble > longitude_max)
                    && !(latitude_min > latitudeDouble || latitudeDouble > latitude_max)) {
                channelDivisionID = arrayCD[0][j];
            }
        }

        if (channelDivisionID.isEmpty()){
            channelDivisionID = "NoMatch";
        }
        return channelDivisionID;
    }


    public static String[] getNearbyChannelDivisionID(String channelDivisionID) {

        String[] arrayNearbyCDID = new String[5];
        String a = channelDivisionID;
        String aSubLast = a.substring(9);           //string截取，表示从第9位开始截取，到最后，从0计数
        String aSubBefore = a.substring(0, 9);      //表示从第0位开始截取，到第9位
        int num1 = Integer.parseInt(aSubLast) + 1;  //string转int
        int num2 = Integer.parseInt(aSubLast) - 1;
        String strNum1= String.format("%04d",num1);  //int转字符串自动补零,"%04d": 0表示前面补得是0,4表示总共4位，d表示是整形
        String strNum2= String.format("%04d",num2);
        String aCombo1 = aSubBefore + strNum1;
        String aCombo2 = aSubBefore + strNum2;
        System.out.println("*********附近航道划分拼接后：" + aCombo1 + " , " + aCombo2 + "*********");


        arrayNearbyCDID[0] = a;

            if (a.equals("JXCH026HD0001")) {
                arrayNearbyCDID[1] = "JXCH026HD0002";
            } else if (a.equals("JXCH026HD0075")) {
                arrayNearbyCDID[1] = "JXCH026HD0074";
                arrayNearbyCDID[2] = "JXCH026HD0076";
                arrayNearbyCDID[3] = "JXCH024HD0190";
            } else if (a.equals("JXCH026HD0078")) {
                arrayNearbyCDID[1] = "JXCH026HD0077";
                arrayNearbyCDID[2] = "JXCH026HD0079";
                arrayNearbyCDID[3] = "JXCH021HD0243";
            } else if (a.equals("JXCH026HD0082")) {
                arrayNearbyCDID[1] = "JXCH026HD0081";
                arrayNearbyCDID[2] = "JXCH026HD0083";
                arrayNearbyCDID[3] = "JXCH024HD0191";
            } else if (a.equals("JXCH001HD0112")) {
                arrayNearbyCDID[1] = "JXCH001HD0111";
            } else if (a.equals("JXCH026HD0101")) {
                arrayNearbyCDID[1] = "JXCH026HD0109";
                arrayNearbyCDID[2] = "JXCH001HD0111";
                arrayNearbyCDID[3] = "JXCH025HD0145";
                arrayNearbyCDID[4] = "JXCH025HD0146";
            } else if (a.equals("JXCH025HD0130")) {
                arrayNearbyCDID[1] = "JXCH025HD0129";
                arrayNearbyCDID[2] = "JXCH025HD0131";
                arrayNearbyCDID[3] = "JXCH024HD0185";
                arrayNearbyCDID[4] = "JXCH024HD0186";
            } else if (a.equals("JXCH025HD0140")) {
                arrayNearbyCDID[1] = "JXCH025HD0139";
                arrayNearbyCDID[2] = "JXCH025HD0141";
                arrayNearbyCDID[3] = "JXCH021HD0225";
            } else if (a.equals("JXCH024HD0164")) {
                arrayNearbyCDID[1] = "JXCH024HD0165";
            } else if (a.equals("JXCH025HD0113")) {
                arrayNearbyCDID[1] = "JXCH025HD0114";
            } else if (a.equals("JXCH025HD0163")) {
                arrayNearbyCDID[1] = "JXCH025HD0162";
            } else if (a.equals("JXCH024HD0242")) {
                arrayNearbyCDID[1] = "JXCH024HD0241";
            } else if (a.equals("JXCH001HD0102")) {
                arrayNearbyCDID[1] = "JXCH026HD0101";
                arrayNearbyCDID[2] = "JXCH001HD0103";
            } else {
                arrayNearbyCDID[1] = aCombo1;
                arrayNearbyCDID[2] = aCombo2;
            }
            for (int i=0;i<arrayNearbyCDID.length;i++){
        System.out.println("*********周围航道划分："+arrayNearbyCDID[i]);}
        return arrayNearbyCDID;
    }
}
