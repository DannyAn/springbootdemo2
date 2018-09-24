package com.kong.core.result;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /**
     * 返回默认成功的结果对象
     * @return
     */
    public static ResponseResult<String> genSuccessResult() {
        return new ResponseResult<String>()
                .setCode(ResultCode.SUCCESS)
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
    /**
     * 返回默认失败的结果对象
     */
    public static ResponseResult<String> genFailResult(String message) {
        return new ResponseResult<String>()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    /**
     * Internal Server Error
     * @param message
     * @param data 出错时返回该数据，方便前段定位传递到后端的数据是否是期望的数据
     * @return
     */
    public static <T> ResponseResult<T> genFailResult(String message,T data) {
        return new ResponseResult<T>()
                .setCode(ResultCode.INTERNAL_SERVER_ERROR)
                .setMessage(message)
                .setData(data);
    }

      /**
     * 返回默内部错误的结果对象
     */
    public static ResponseResult<String> genInternalResult(String message) {
        return new ResponseResult<String>()
                .setCode(ResultCode.INTERNAL_SERVER_ERROR)
                .setMessage(message);
    }
}
