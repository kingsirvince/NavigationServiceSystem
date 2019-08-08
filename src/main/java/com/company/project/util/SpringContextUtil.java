package com.company.project.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 在普通类可以通过调用mapper和service，
 * 例如：ShipUploadServiceImpl shipUploadService = (ShipUploadServiceImpl) SpringContextUtil.getBean(ShipUploadServiceImpl.class);
 */
@Component
public final class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        if (SpringContextUtil.applicationContext == null) {
            SpringContextUtil.applicationContext = applicationContext;
            System.out.println(
                    "========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext="
                            + applicationContext + "========");
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }
}
//---------------------
//        版权声明：本文为CSDN博主「Been_You」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/k_young1997/article/details/88775375