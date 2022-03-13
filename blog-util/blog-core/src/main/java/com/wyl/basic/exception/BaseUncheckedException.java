package com.wyl.basic.exception;

import cn.hutool.core.util.StrUtil;
import com.wyl.basic.utils.StrPool;

/**
 * cloud-study BaseUncheckedException
 *
 * <p>
 * TODO
 * </p>
 *
 * @author ylWang
 * @version 1.0.0
 * @date 2021/11/14 22:19
 */
public class BaseUncheckedException extends RuntimeException implements BaseException {

    private static final long serialVersionUID = -778887391066124051L;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 具体异常码
     */
    private int code;

    public BaseUncheckedException(Throwable cause) {
        super(cause);
    }

    public BaseUncheckedException(final int code, Throwable cause) {
        super(cause);
        this.code = code;
    }


    public BaseUncheckedException(final int code, final String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseUncheckedException(final int code, final String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public BaseUncheckedException(final int code, final String format, Object... args) {
        super(StrUtil.contains(format, StrPool.BRACE) ? StrUtil.format(format, args) : String.format(format, args));
        this.code = code;
        this.message = StrUtil.contains(format, StrPool.BRACE) ? StrUtil.format(format, args) : String.format(format, args);
    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getCode() {
        return code;
    }
}
