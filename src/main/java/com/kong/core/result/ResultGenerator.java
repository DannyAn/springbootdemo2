package com.kong.core.result;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    public static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /**
     * 返回默认成功的结果对象
     * @return
     */
    public static ResponseResult<String> genSuccessResult() {
        return new ResponseResult<String>()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }
    public static ResponseResult<String> genCreateSuccessResult() {
        return new ResponseResult<String>()
                .setCode(ResultCode.CREATE_SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }
    /**
     * 返回默认成功的结果对象
     * @param data
     * @return
     */
    public static <T> ResponseResult<T> genSuccessResult(T data) {
        return new ResponseResult<T>()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static <T> ResponseResult<T> genCreateSuccessResult(T data) {
        return new ResponseResult<T>()
                .setCode(ResultCode.CREATE_SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    /**
     * 返回调用错误的具体提示信息
     */
    public static ResponseResult<String> genFailResult(String message) {
        return new ResponseResult<String>()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    /**
     * 系统内部错误，通常底层直接跑出异常上来
     * Internal Server Error
     * @param message
     * @param data 出错时返回该数据，方便前段定位传递到后端的数据是否是期望的数据
     * @return
     */
    public static <T> ResponseResult<T> genErrorResult(String message,T data) {
        return new ResponseResult<T>()
                .setCode(ResultCode.INTERNAL_SERVER_ERROR)
                .setMessage(message)
                .setData(data);
    }

    /**
     * 系统内部错误，通常底层直接跑出异常上来
     * Internal Server Error
     */
    public static ResponseResult<String> genErrorResult(String message) {
        return new ResponseResult<String>()
                .setCode(ResultCode.INTERNAL_SERVER_ERROR)
                .setMessage(message);
    }
}
