package com.wyl.basic.annotation.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * cloud-study IgnoreResponseBodyAdvice
 *
 * <p>
 * 忽略全局响应包装
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/10/14 21:11
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface IgnoreResponseBodyAdvice {

}
