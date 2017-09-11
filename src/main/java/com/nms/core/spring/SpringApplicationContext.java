package com.nms.core.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by syx on 17-6-14.
 */
public class SpringApplicationContext implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SpringApplicationContext.class);

    private static Map<String, List<String>> needsAutowirdFields = new ConcurrentHashMap<String, List<String>>();

    private static ApplicationContext context = null;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return context;
    }

    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }

    public static Object getBean(String beanName, Class beanType){
        return context.getBean(beanName, beanType);
    }

    public static Object autowired(Object obj){

        String className = obj.getClass().getName();
        List<String> fieldsName = needsAutowirdFields.get(className);
        if(fieldsName == null){
            //首次加载
            fieldsName = new LinkedList<String>();
            Field[] fields = obj.getClass().getDeclaredFields();
            for(Field f : fields){
                try {
                    f.setAccessible(true);
                    if(f.get(obj) != null){
                        continue;
                    }

                    if (f.getAnnotation(Autowired.class) != null) {
                        Qualifier qualifier = f.getAnnotation(Qualifier.class);
                        Object objVal = null;
                        if (qualifier != null) {
                            //byName
                            objVal = SpringApplicationContext.getBean(qualifier.value());
                        }else {
                            //byType
                            objVal = SpringApplicationContext.getBean(f.getName(), f.getType());
                        }
                        f.set(obj, objVal);
                        //增加到列表，下次可以快速
                        fieldsName.add(f.getName());
                    }
                }catch(Exception err){
                    logger.error("装配spring autowired时发生错误，" + err.getMessage());
                }
            }
            needsAutowirdFields.put(className, fieldsName);
        }else{
            //二次加载
            Field f = null;
            for(String name : fieldsName){
                try {
                    f = obj.getClass().getDeclaredField(name);
                    f.setAccessible(true);
                    if(f.get(obj) != null){
                        continue;
                    }

                    Qualifier qualifier = f.getAnnotation(Qualifier.class);
                    Object objVal = null;
                    if (qualifier != null) {
                        //byName
                        objVal = SpringApplicationContext.getBean(qualifier.value());
                    }else {
                        //byType
                        objVal = SpringApplicationContext.getBean(f.getName(), f.getType());
                    }
                    f.set(obj, objVal);
                }catch(Exception err){
                    logger.error("装配spring autowired时发生错误，" + err.getMessage());
                }
            }
        }
        return obj;
    }
}
