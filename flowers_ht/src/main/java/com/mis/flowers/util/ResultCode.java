package com.mis.flowers.util;

public enum ResultCode {

    /*
     *成功
     */
    SUCCESS(0, "成功"),
    /*
     *失败
     */
    Fail(2, "失败"),
    /*
        内部错误
     */
    INTERNAL_SERVER_ERROR(5, "内部错误"),
    /*
     *参数不合法
     */
    ERROR_PARAM(6, "参数不合法");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
