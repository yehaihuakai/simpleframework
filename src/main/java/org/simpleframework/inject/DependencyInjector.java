package org.simpleframework.inject;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.annotation.Autowired;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * The type Dependency injector.
 *
 * @description:
 * @author: liyang07
 * @date: 2020 /10/08
 */
@Slf4j
public class DependencyInjector {

    /**
     * Bean容器
     */
    private BeanContainer beanContainer;

    /**
     * Instantiates a new Dependency injector.
     */
    public DependencyInjector() {
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行 IOC
     */
    public void doIoc() {

        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("empty classes in BeanContainer");
            return;
        }

        // 1.遍历Bean容器中所有的class对象
        for (Class<?> clazz : beanContainer.getClasses()) {
            // 2.遍历class对象中所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }

            for (Field field : fields) {
                // 3.找出被Autowired标记的成员变量
                if (field.isAnnotationPresent(Autowired.class)) {
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    String autowiredValue = autowired.value();

                    // 4.获取这些成员变量的类型
                    Class<?> fieldClass = field.getType();

                    // 5.获取这些成员变量的类型在容器里对应的实例
                    Object fieldValue = getFieldInstance(fieldClass, autowiredValue);

                    if (null == fieldValue) {
                        throw new RuntimeException("unable to inject relevant type ,target fieldClass is : "
                                + fieldClass + " autowiredValue: " + autowiredValue);
                    } else {
                        // 6.通过反射将对应的成员变量实例注入到成员变量所在类的实例里
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setField(field, targetBean, fieldValue, true);
                    }
                }
            }
        }

    }

    /**
     * 根据Class，在BeanContainer里获取其实例或者实现类
     */
    private Object getFieldInstance(Class<?> fieldClass, String autowiredValue) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        if (null != fieldValue) {
            return fieldValue;
        }
        return beanContainer.getBean(getImplementClass(fieldClass, autowiredValue));
    }

    /**
     * 获取接口的实现类
     */
    private Class<?> getImplementClass(Class<?> fieldClass, String autowiredValue) {
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if (ValidationUtil.isEmpty(classSet)) {
            return null;
        }
        if (ValidationUtil.isEmpty(autowiredValue)) {
            if (classSet.size() == 1) {
                return classSet.iterator().next();
            } else {
                // 存在多个实现类且用户未指定其中的一个实现类，则抛出异常
                throw new RuntimeException("multiple implemented class for " + fieldClass.getName()
                        + "plase set @Autowired value to pick one");
            }
        } else {
            for (Class<?> clazz : classSet) {
                if (autowiredValue.equalsIgnoreCase(clazz.getSimpleName())) {
                    return clazz;
                }
            }
        }
        return null;
    }
}
