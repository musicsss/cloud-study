package com.wyl.basic.exception;

/**
 * cloud-study CommonException
 *
 * <p>
 * 非业务异常
 * 用于在处理非业务逻辑时，进行抛出的异常。
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/14 22:22
 */
public class CommonException extends BaseCheckedException {
    public CommonException(int code, String message) {
        super(code, message);
    }

    public CommonException(int code, String format, Object... args) {
        super(code, format, args);
    }

    public CommonException wrap(int code, String format, Object... args) {
        return new CommonException(code, format, args);
    }

    @Override
    public String toString() {
        return "BizException [message=" + getMessage() + ", code=" + getCode() + "]";
    }
}
