package demo.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        /*System.out.println(EnumStarvingSingleton.getInstance());

        Class clazz = EnumStarvingSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumStarvingSingleton enumStarvingSingleton = (EnumStarvingSingleton) constructor.newInstance();
        System.out.println(enumStarvingSingleton.getInstance());

        System.out.println(enumStarvingSingleton);*/

        Class clazz = EnumStarvingSingleton2.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumStarvingSingleton enumStarvingSingleton1 = (EnumStarvingSingleton) constructor.newInstance();
        EnumStarvingSingleton enumStarvingSingleton2 = (EnumStarvingSingleton) constructor.newInstance();
        System.out.println(enumStarvingSingleton1);
        System.out.println(enumStarvingSingleton2);

    }
}
