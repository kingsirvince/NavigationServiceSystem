package com.company.project.util;

import com.company.project.model.ShipMonitor;
import com.company.project.service.ShipMonitorService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * 监控请求，记录到数据表ship_monitor
 * @Description:服务切面 springboot服务切面（获取请求url、ip、参数、方法名、耗时）
 * @Author: lifay   有兴趣也可以打印返回数据(不过数据量太多没写了)，加上ret打印就行
 * @datetime:2019/11/18 16:00
 *
 */

@Aspect
@Component
public class ServerAspect {

    @Autowired
    private ShipMonitorService shipMonitorService;
    //加入匹配的类型，这些类型会直接放入结果（抓取参数值，无法得到参数名）。匹配不到进入getFieldsValue，抓取实体类的参数名和参数值
    private static String[] types = {"java.math.BigDecimal","java.lang.Integer", "java.lang.Double",
            "java.lang.Float", "java.lang.Long", "java.lang.Short",
            "java.lang.Byte", "java.lang.Boolean", "java.lang.Char",
            "java.lang.String", "int", "double", "long", "short", "byte",
            "boolean", "char", "float"};


    private final Logger logger = LoggerFactory.getLogger(ServerAspect.class);

    @Around("execution(public * com.company.project.web..*.*(..))")
    public Object controllerLog(ProceedingJoinPoint pdj) throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        long startTime = System.currentTimeMillis();//开始时间

        Object[] args = pdj.getArgs();//获取参数数组
        Object ret = pdj.proceed(args);//执行原方法并获取返回结果

        long endTime = System.currentTimeMillis();//结束时间

        // 记录下请求内容中的参数名和参数值
        StringBuilder sbOriginal = new StringBuilder();
        //获取所有的参数
        args = pdj.getArgs();
        for (int k = 0; k < args.length; k++) {
            Object arg = args[k];
            // 获取对象类型
            String typeName = arg.getClass().getTypeName();
            for (String t : types) {
                //1 判断是否是基础类型
                if (t.equals(typeName)) {
                    sbOriginal.append(arg + "; ");
                }else{
                    //2 通过反射获取实体类属性
                    if (getFieldsValue(arg)!=""){
                    sbOriginal.append(getFieldsValue(arg));
                    break;
                    }
                }
            }
        }
// 记录下请求内容
        StringBuilder sb = new StringBuilder();
        sb.append("###请求URL: " + request.getRequestURL().toString());
        sb.append("   ###IP: " + request.getRemoteAddr());
        sb.append("   ###参数Params: " + sbOriginal);
//        sb.append("   ###参数Params: " + Arrays.toString(args));
        sb.append("   ###请求方法CLASS_METHOD: " + pdj.getSignature().getDeclaringTypeName() + "." + pdj.getSignature().getName());
        sb.append("   ###耗时: " + (endTime - startTime) + "毫秒");

        logger.info(sb.toString());

        //System.out.println(sb);

        //url的字符串，取得访问页面和方法， 截取第三个/后面的字符串，所以循环3遍
        String strUrl=request.getRequestURL().toString();

        for (int i=0;i<3;i++) {
            String str1 = strUrl.substring(0, strUrl.indexOf("/")); //  /之前
            String str2 = strUrl.substring(str1.length() + 1, strUrl.length());//  /之后（不带/）
            System.out.println(str2);
            strUrl = str2;
        }

        //截取requestId
        String strRequestId = null;


        requestId:
        //  寻找requestId
        if (sb.indexOf("requestId") != -1) {
            String strRequestIdBefore1 = sb.toString().substring(0, sb.indexOf("requestId"));
            String strRequestIdAfter1 = sb.toString().substring(strRequestIdBefore1.length(), sb.length());
            if (strRequestIdAfter1.indexOf(";") != -1) {
                strRequestId = strRequestIdAfter1.substring(0, strRequestIdAfter1.indexOf(";"));
                break requestId;
            } else if (strRequestIdAfter1.indexOf(",") != -1) {
                strRequestId = strRequestIdAfter1.substring(0, strRequestIdAfter1.indexOf(","));
                break requestId;
            } else {
                strRequestId = strRequestIdAfter1.substring(0, 15);//管理平台发出的“requestId:10001" 共15位
            }
        }
        //  寻找mmsi，区分请求shipMmsi:444440000 和 查询参数中的shipMmsi;444440000
        else if (sb.indexOf("shipMmsi:") != -1) {
            String strRequestIdBefore = sb.toString().substring(0, sb.indexOf("shipMmsi:"));
            String strRequestIdAfter = sb.toString().substring(strRequestIdBefore.length(), sb.length());
            if (strRequestIdAfter.indexOf(";") != -1) {
                strRequestId = strRequestIdAfter.substring(0, strRequestIdAfter.indexOf(";"));
                break requestId;
            } else if (strRequestIdAfter.indexOf(",") != -1) {
                strRequestId = strRequestIdAfter.substring(0, strRequestIdAfter.indexOf(","));
                break requestId;
            } else {
                strRequestId = strRequestIdAfter.substring(0, 18);//mmsi发出的“shipMmsi:400004444" 共18位
            }
        }

        else if (sb.indexOf("shipMmsi") != -1) {
            String strRequestIdBefore = sb.toString().substring(0, sb.indexOf("shipMmsi"));
            String strRequestIdAfter = sb.toString().substring(strRequestIdBefore.length(), sb.length());
            if (strRequestIdAfter.indexOf(";") != -1) {
                strRequestId = strRequestIdAfter.substring(0, strRequestIdAfter.indexOf(";"));
                break requestId;
            } else if (strRequestIdAfter.indexOf(",") != -1) {
                strRequestId = strRequestIdAfter.substring(0, strRequestIdAfter.indexOf(","));
                break requestId;
            } else {
                strRequestId = strRequestIdAfter.substring(0, 18);//mmsi发出的“shipMmsi:400004444" 共18位
            }
        }

        //写入到ship_monitor表中
        ShipMonitor shipMonitor = new ShipMonitor();
        String monitorLog = sb.toString();
        String type = strUrl;
        shipMonitor.setMonitorLog(monitorLog);
        shipMonitor.setType(type);
        shipMonitor.setRequestId(strRequestId);
        shipMonitorService.save(shipMonitor);

        return ret;
    }






    //解析实体类，获取实体类中的属性
    public static String getFieldsValue(Object obj) {
        //通过反射获取所有的字段，getFileds()获取public的修饰的字段
        //getDeclaredFields获取private protected public修饰的字段
        Field[] fields = obj.getClass().getDeclaredFields();
        String typeName = obj.getClass().getTypeName();
        for (String t : types) {
            if (t.equals(typeName)) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Field f : fields) {
            //在反射时能访问私有变量
            f.setAccessible(true);
            try {
                for (String str : types) {
                    //这边会有问题，如果实体类里面继续包含实体类，这边就没法获取。
                    //其实，我们可以通递归的方式去处理实体类包含实体类的问题。
                    if (f.getType().getName().equals(str)) {
                        sb.append(f.getName() + ":" + f.get(obj) + ",");
                    }
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.append("}");
        return sb.toString();
    }

}
