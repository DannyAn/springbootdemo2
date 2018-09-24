package com.kong.core.result;

import com.google.gson.Gson;

// import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 */
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    public ResponseResult<T> setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ResponseResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        Gson g =  new Gson();
        return g.toJson(this);
    //return JSON.toJSONString(this);
    }
}
