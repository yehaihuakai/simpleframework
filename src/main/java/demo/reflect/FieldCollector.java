package demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
public class FieldCollector {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("demo.reflect.ReflectTarget");
        // 1.获取所有共有的字段
        System.out.println("---------- 获取所有共有的字段 ----------");
        Field[] fieldArray = clazz.getFields();
        for (Field field : fieldArray) {
            System.out.println(field);
        }

        // 2.获取所有的字段
        System.out.println("---------- 获取所有的字段 ----------");
        fieldArray = clazz.getDeclaredFields();
        for (Field field : fieldArray) {
            System.out.println(field);
        }

        // 3.获取单个特定共有的field
        System.out.println("---------- 获取单个特定公有的field ----------");
        Field field = clazz.getField("name");
        System.out.println("公有的field name：" + field);
        ReflectTarget ref = (ReflectTarget) clazz.getConstructor().newInstance();

        // 4.给获取到的field赋值
        field.set(ref, "待反射一号");

        // 5.验证对应的那么值
        System.out.println("验证name：" + ref.name);

        // 6.获取单个私有的field
        field = clazz.getDeclaredField("targetInfo");
        field.setAccessible(true);
        System.out.println(field);
        field.set(ref, "123456");
        System.out.println("验证targetInfo" + ref);
    }
}
