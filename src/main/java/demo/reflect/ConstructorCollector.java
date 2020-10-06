package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/04
 **/
public class ConstructorCollector {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("demo.reflect.ReflectTarget");
        // 1.获取所有的共有构造方法
        System.out.println("---------- 获取所有的共有构造方法 ----------");
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }

        // 2.获取所有构造方法
        System.out.println("---------- 获取所有构造方法 ----------");
        conArray = clazz.getDeclaredConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }

        // 3.获取单个的带参构造方法
        System.out.println("---------- 获取单个的带参构造方法 ----------");
        Constructor con = clazz.getConstructor(String.class, int.class);
        System.out.println(con);

        // 4.获取私有的构造方法
        System.out.println("---------- 获取私有的构造方法 ----------");
        con = clazz.getDeclaredConstructor(int.class);
        System.out.println(con);

        System.out.println("---------- 调用私有构造方法创建实例 ----------");
        // 暴力访问，忽略修饰符
        con.setAccessible(true);
        ReflectTarget reflectTarget = (ReflectTarget) con.newInstance(1);
    }
}
