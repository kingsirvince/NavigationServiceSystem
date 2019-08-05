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
    public void readExcelInputArray() {

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

        public String getChannelDivisionID(Coordinate coordinate){

        String channelDivisionID="";
        BigDecimal longitude = coordinate.getLongitude();
        BigDecimal latitude = coordinate.getLatitude();
        Double longitudeDouble=longitude.doubleValue();//bigdecimal转double
        Double latitudeDouble=latitude.doubleValue();


            System.out.println(arrayCD[0][0]+"******开始计算航道划分***********************************************");

        for (int j = 0; j < 255; j++)
        {
            Double longitude_max, longitude_min, latitude_max, latitude_min;

            longitude_max =Double.valueOf(arrayCD[1][j]);
            longitude_min =Double.valueOf(arrayCD[2][j]);
            latitude_max = Double.valueOf(arrayCD[3][j]);
            latitude_min = Double.valueOf(arrayCD[4][j]);


            if (!(longitude_min > longitudeDouble || longitudeDouble > longitude_max)
                    && !(latitude_min > latitudeDouble || latitudeDouble > latitude_max))
            {
                channelDivisionID=arrayCD[0][j];
            }else {
                channelDivisionID="NoMatch";
            }

        }
        return channelDivisionID;
    }
}
