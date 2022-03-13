package com.wyl.basic.utils;

import cn.hutool.core.util.StrUtil;

import java.io.Serializable;

/**
 * cloud-study DefValueHelper
 *
 * <p>
 * 默认值
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/14 22:33
 */
public final class DefValueHelper {
    private DefValueHelper() {
    }

    public static String getOrDef(String val, String def) {
        return StrUtil.isEmpty(val) ? def : val;
    }

    public static <T extends Serializable> T getOrDef(T val, T def) {
        return val == null ? def : val;
    }

}
