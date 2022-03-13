package com.wyl.basic.base.validation;

/**
 * cloud-study IValidatable
 *
 * <p>
 * 实现了此接口，表示此类将会支持验证框架
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/10/14 21:06
 */
public interface IValidatable {
    /**
     * 此类需要校验什么值
     * 支持length长度检验。也可以视情况实现支持类似于email，正则等等校验
     *
     * @return 需要验证的值
     */
    Object value();
}
