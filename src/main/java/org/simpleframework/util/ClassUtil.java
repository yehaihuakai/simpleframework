package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Class util.
 *
 * @description:
 * @author: liyang07
 * @date: 2020 /10/06
 */
@Slf4j
public class ClassUtil {


    /**
     * The constant FILE_PROTOCOL.
     */
    public static final String FILE_PROTOCOL = "file";
    /**
     * The constant CLASS_SUFFIX.
     */
    public static final String CLASS_SUFFIX = ".class";

    /**
     * 获取包下类集合
     *
     * @param packageName the package name
     * @return the set
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {

        // 1.获取类加载器
        ClassLoader classLoader = getClassLoader();

        // 2.通过类加载器获取到加载的资源信息
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (null == url) {
            log.warn("unable to retrieve anything from package:" + packageName);
            return null;
        }

        // 3.依据不同的资源类型，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            classSet = new HashSet<>();
            File packageDictory = new File(url.getPath());
            extractPackageClass(classSet, packageDictory, packageName);
        }
        // TODO 此处可以加入针对其他类型资源的处理

        return classSet;
    }

    /**
     * Extract package class.
     *
     * @param classSet    the class set
     * @param fileSource  the file source
     * @param packageName the package name
     */
    private static void extractPackageClass(Set<Class<?>> classSet, File fileSource, String packageName) {
        if (!fileSource.isDirectory()) {
            return;
        }

        File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    String absoluteFilePath = file.getAbsolutePath();
                    if (absoluteFilePath.endsWith(CLASS_SUFFIX)) {
                        addToClassSet(absoluteFilePath);
                    }
                }
                return false;
            }

            // 根据class文件的绝对路径，获取并生成class文件，并放入classSet
            private void addToClassSet(String absoluteFilePath) {
                // 1.从class文件的绝对值路径里提取出包含了package的类名
                absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
                className = className.substring(0, className.lastIndexOf("."));

                // 2.通过反射机制获取对应的class对象，并加入到classSet中
                Class<?> targetClass = loadClass(className);
                classSet.add(targetClass);
            }
        });

        if (null != files) {
            for (File f : files) {
                // 递归调用
                extractPackageClass(classSet, f, packageName);
            }
        }
    }

    /**
     * Get ClassLoader.
     *
     * @return the class loader
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * Load class class.
     *
     * @param className the class name
     * @return the class
     */
    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error:", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 实例化class
     *
     * @param <T>        the type parameter
     * @param clazz      the clazz
     * @param accessible 是否支持创建出私有class对象的实例
     * @return the t
     */
    public static <T> T newInstance(Class<?> clazz, boolean accessible) {
        try {
            Constructor constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(accessible);
            return (T) constructor.newInstance();
        } catch (Exception e) {
            log.error("newInstance error", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets field.
     *
     * @param field      the field
     * @param target     the target
     * @param value      the value
     * @param accessible the accessible
     */
    public static void setField(Field field, Object target, Object value, boolean accessible) {
        field.setAccessible(accessible);
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            log.error("setField error:", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        extractPackageClass("com.dion.entity");
    }
}
