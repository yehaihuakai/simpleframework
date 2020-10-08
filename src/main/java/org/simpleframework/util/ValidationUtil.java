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
    public static boolean isEmpty(Collection<?> obj){
        return obj == null || obj.isEmpty();
    }
}
