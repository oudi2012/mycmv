package com.ddky.fms.refund.exception;

/**
 * @author a
 */
public class BusinessException extends RuntimeException {

    private String code;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable e) {
        super(message, e);
    }
}
