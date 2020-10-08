package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Bean container.
 *
 * @description: bean容器
 * @author: liyang07
 * @date: 2020 /10/08
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     * 用于存放所有被标记的目标对象
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 加载bean的注解列表
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION =
            Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);

    /**
     * 容器是否已经被加载过
     */
    private boolean loaded = false;

    /**
     * 获取Bean容器实例
     *
     * @return the instance
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }


    private enum ContainerHolder {

        /**
         * Holder container holder.
         */
//
        HOLDER;
        private BeanContainer instance;

        ContainerHolder() {
            instance = new BeanContainer();
        }
    }

    /**
     * 扫描加载所有的bean
     *
     * @param packageName the package name
     */
    public synchronized void loadBeans(String packageName) {

        // 判断是否加载过
        if (isLoaded()) {
            log.warn("BeanCOntainer has been loaded");
            return;
        }

        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("extract nothing from packageName:{}", packageName);
            return;
        }

        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                // 判断类上面是否标记了自定义注解
                if (clazz.isAnnotationPresent(annotation)) {
                    //目标类作为键，目标类的实例作为值，放入beanMap中
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }

    /**
     * 是否已经加载过Bean
     *
     * @return the boolean
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * Bean 实例数
     *
     * @return the int
     */
    public int size() {
        return beanMap.size();
    }


    /**
     * Add bean object.
     *
     * @param clazz the clazz
     * @param bean  the bean
     * @return the object
     */
    public Object addBean(Class<?> clazz, Object bean) {
        return beanMap.put(clazz, bean);
    }

    /**
     * Remove bean object.
     *
     * @param clazz the clazz
     * @return the object
     */
    public Object removeBean(Class<?> clazz) {
        return beanMap.remove(clazz);
    }

    /**
     * Get bean object.
     *
     * @param clazz the clazz
     * @return the object
     */
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }

    /**
     * Get classes set.
     *
     * @return the set
     */
    public Set<Class<?>> getClasses() {
        return beanMap.keySet();
    }

    /**
     * Gets beans.
     *
     * @return the beans
     */
    public Set<Object> getBeans() {
        return new HashSet<>(beanMap.values());
    }

    /**
     * Gets class by annotation.
     *
     * @param annotation the annotation
     * @return the class by annotation
     */
    public Set<Class<?>> getClassByAnnotation(Class<? extends Annotation> annotation) {
        Set<Class<?>> classSet = new HashSet<>();

        // 1.获取beanMap的所有class对象
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)) {
            log.warn("nothing in beanMap");
            return classSet;
        }

        // 2.通过注解筛选被注解标记的class对象，并添加到classSet里
        for (Class<?> clazz : keySet) {
            // 类是否有相关注解的标记
            if (clazz.isAnnotationPresent(annotation)) {
                classSet.add(clazz);
            }
        }
        return classSet;
    }

    /**
     * Gets class by super.
     * 根据接口或父类获取实现类或子类的Class集合，不包括其本身
     *
     * @param interfaceOrClass the interface or class
     * @return the class by super
     */
    public Set<Class<?>> getClassBySuper(Class<?> interfaceOrClass) {
        Set<Class<?>> classSet = new HashSet<>();

        // 1.获取beanMap的所有class对象
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)) {
            log.warn("nothing in beanMap");
            return classSet;
        }

        // 2.判断keySet里面的元素是否是传入的接口或者类的子类，如果是，添加到classSet里面
        for (Class<?> clazz : keySet) {
            if (interfaceOrClass.isAssignableFrom(clazz) && !clazz.equals(interfaceOrClass)) {
                classSet.add(clazz);
            }
        }
        return classSet;
    }
}
