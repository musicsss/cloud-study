package com.wyl.basic.exception;

import com.wyl.basic.exception.code.BaseExceptionCode;
import com.wyl.basic.exception.code.ExceptionCode;

/**
 * cloud-study ForbiddenException
 *
 * <p>
 * 403  禁止访问
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/14 22:23
 */
public class ForbiddenException extends BaseUncheckedException {
    private static final long serialVersionUID = 1L;

    public ForbiddenException(int code, String message) {
        super(code, message);
    }
    public static ForbiddenException wrap(BaseExceptionCode ex) {
        return new ForbiddenException(ex.getCode(), ex.getMsg());
    }

    public static ForbiddenException wrap(String msg) {
        return new ForbiddenException(ExceptionCode.FORBIDDEN.getCode(), msg);
    }

    @Override
    public String toString() {
        return "ForbiddenException [message=" + getMessage() + ", code=" + getCode() + "]";
    }
}
