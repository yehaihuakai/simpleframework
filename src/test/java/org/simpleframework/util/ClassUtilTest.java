package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/06
 **/
public class ClassUtilTest {

    @DisplayName("提取目标类方法: extractPackageTest")
    @Test
    public void extractPackageTest() {
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("com.dion.entity");
        System.out.println(classSet);
        Assertions.assertEquals(3, classSet.size());
    }
}
