package com.feel.common.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author: zz
 * @Description:
 * @Date: 8:12 PM 6/9/19
 * @Modified By
 */
public class ArrayUtils {

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断Map是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 判断数组是否为空
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断List是否为空
     * @param list
     * @return
     */
    public static boolean isEmpty(List<Object> list) {
        return list == null || list.size() == 0;
    }
}
