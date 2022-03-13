package com.wyl.basic.model;

import java.util.Map;

/**
 * cloud-study EchoVO
 *
 * <p>
 * 注入VO 父类
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/11 21:45
 */
public interface EchoVO {

    /**
     * 回显值 集合
     *
     * @return 回显值 集合
     */
    Map<String, Object> getEchoMap();
}
