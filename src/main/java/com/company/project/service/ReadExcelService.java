package com.company.project.service;

import com.company.project.util.ReadExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * http读取excel的功能代码，未使用
 */
@Service
public class ReadExcelService {
    public Map<Integer, Map<Integer, Object>> addCustomerInfo(MultipartFile file) {
//    public Map<Integer, Map<Integer, Object>> addCustomerInfo(MultipartFile file) {
        Map<Integer, Map<Integer, Object>> map = new HashMap<>();
        try {
            map = ReadExcelUtil.readExcelContentz(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //excel数据存在map里，map.get(0).get(0)为excel第1行第1列的值，此处可对数据进行处理

        //测试map里有没有读到excel
        for(Map.Entry<Integer, Map<Integer, Object>> entry : map.entrySet()){
            Integer mapKey = entry.getKey();
            Map<Integer, Object> mapValue = entry.getValue();
            System.out.println("*****************************************************");
            System.out.println(mapKey+":"+mapValue);
        }
        //
        return map;


    }

    /**
     * 双重嵌套map，遍历
     * @param czbk
     */
    public static void keySet(Map<Integer, Map<Integer, Object>> czbk) {
        //keySet()获取键 　将班级名存放至Set中
        Set<Integer> classNameSet = czbk.keySet();
        Iterator<Integer> it = classNameSet.iterator();

        while (it.hasNext()) {
            Integer classNamekey = it.next();  //键
            //czbk集合的方法get获取值　值是一个HashMap集合
            Map<Integer, Object> classMap = czbk.get(classNamekey);//值　map

            //调用keySet 获取值　存储到Set
            Set<Integer> studentIdSet = classMap.keySet();  //值map 中的键
            Iterator<Integer> studentIt = studentIdSet.iterator();

            while (studentIt.hasNext()) {
                //studentIt.next()获取的是学号
                Integer IdKey = studentIt.next();
                Object nameValue = classMap.get(IdKey);
                System.out.println(classNamekey + "..." + IdKey + "..." + nameValue);

                /*
                赋值给ChannelDivision数组
                 */

            }
        }
/*        ---------------------
                作者：vazh0922
        来源：CSDN
        原文：https://blog.csdn.net/zkhubu/article/details/81238068
        版权声明：本文为博主原创文章，转载请附上博文链接！*/
    }

}
/*---------------------
    作者：qq_41369766
    来源：CSDN
    原文：https://blog.csdn.net/qq_41369766/article/details/81288974
    版权声明：本文为博主原创文章，转载请附上博文链接！*/

