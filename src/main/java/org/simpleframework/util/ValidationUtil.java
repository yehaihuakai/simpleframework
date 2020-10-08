package org.simpleframework.util;

import java.util.Collection;

/**
 * The type Validation util.
 *
 * @description:
 * @author: liyang07
 * @date: 2020 /10/08
 */
public class ValidationUtil {

    /**
     * Is empty boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    public static boolean isEmpty(Collection<?> obj) {
        return null == obj || obj.isEmpty();
    }

    /**
     * Is empty boolean.
     *
     * @param objs the objs
     * @return the boolean
     */
    public static boolean isEmpty(Object[] objs) {
        return null == objs || objs.length == 0;
    }

    /**
     * String是否为null或""
     *
     * @param obj String
     * @return 是否为空
     */
    public static boolean isEmpty(String obj) {
        return (null == obj || "".equals(obj));
    }
}
