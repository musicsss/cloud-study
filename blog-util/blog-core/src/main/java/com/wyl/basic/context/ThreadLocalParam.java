package com.wyl.basic.context;

import lombok.Data;

import java.io.Serializable;

/**
 * cloud-study ThreadLocalParam
 *
 * <p>
 * 线程变量封装的参数
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/14 22:54
 */
@Data
public class ThreadLocalParam implements Serializable {
    private Boolean boot;
    private String tenant;
    private Long userid;
    private String name;
    private String account;
}
