package com.wyl.basic.exception;

import com.wyl.basic.exception.code.ExceptionCode;

/**
 * cloud-study ArgumentException
 *
 * <p>
 * 业务参数异常
 * 用于在业务中，检测到非法参数时，进行抛出的异常。
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/14 22:13
 */
public class ArgumentException extends BaseUncheckedException {

    private static final long serialVersionUID = -3843907364558373817L;

    public ArgumentException(Throwable cause) {
        super(cause);
    }

    public ArgumentException(String message) {
        super(ExceptionCode.BASE_VALID_PARAM.getCode(), message);
    }

    public ArgumentException(String message, Throwable cause) {
        super(ExceptionCode.BASE_VALID_PARAM.getCode(), message, cause);
    }

    public ArgumentException(final String format, Object... args) {
        super(ExceptionCode.BASE_VALID_PARAM.getCode(), format, args);
    }

    @Override
    public String toString() {
        return "ArgumentException [message=" + getMessage() + ", code=" + getCode() + "]";
    }

}