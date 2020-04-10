package com.mis.flowers.util;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean success() {
        return this.code == ResultCode.SUCCESS.code();
    }

    public boolean hasObject() {
        return success() && data != null;
    }

    public static <T> Result<T> createResult(ResultCode resultCode) {
        Result<T> result = new Result<>();
        result.setCode(resultCode.code());
        result.setMessage(resultCode.message());
        return result;
    }


    //    返回成功结果，无data
    public static <T> Result<T> createSuccess() {
        return createResult(ResultCode.SUCCESS);
    }

    //    返回成功结果，有data
    public static <T> Result<T> createSuccess(T data) {
        Result<T> result = createSuccess();
        result.setData(data);
        return result;
    }

    //    返回失败结果，无data
    public static <T> Result<T> createFailUre(int code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    //    返回失败结果，有data
    public static <T> Result<T> createFailUre(T data) {
        Result<T> result = createSuccess();
        result.setData(data);
        return result;
    }
}
