package com.wyl.basic.exception;

import com.wyl.basic.exception.code.ExceptionCode;

/**
 * cloud-study UnauthorizedException
 *
 * <p>
 * 401 未认证 未登录
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/14 22:24
 */
public class UnauthorizedException extends BaseUncheckedException {
    private static final long serialVersionUID = 1L;

    public UnauthorizedException(int code, String message) {
        super(code, message);
    }

    public UnauthorizedException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public static UnauthorizedException wrap(String msg) {
        return new UnauthorizedException(ExceptionCode.UNAUTHORIZED.getCode(), msg);
    }

    @Override
    public String toString() {
        return "UnauthorizedException [message=" + getMessage() + ", code=" + getCode() + "]";
    }
}
