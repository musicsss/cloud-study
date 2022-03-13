package com.wyl.basic.exception.code;

/**
 * cloud-study BaseExceptionCode
 *
 * <p>
 * 异常编码
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/14 22:14
 */
public interface BaseExceptionCode {
    /**
     * 异常编码
     *
     * @return 异常编码
     */
    int getCode();

    /**
     * 异常消息
     *
     * @return 异常消息
     */
    String getMsg();
}
