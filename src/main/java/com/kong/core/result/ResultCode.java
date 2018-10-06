package com.kong.core.result;

/**
 * 响应码枚举，参考HTTP状态码的语义
 * 在RESTful Api开发中，使用Http用来返回错误和状态是非常常用和友好的，其中常用的状态
 * 码有以下这些。
 *
 * 200 – OK – 一切正常
 * 201 – OK – 新资源已经被创建
 * 204 – OK – 资源删除成功
 *
 * 304 – 没有变化，客户端可以使用缓存数据
 * 400 – Bad Request – 调用不合法，确切的错误应该在error payload中描述，例如：“JSON 不合法 ”
 * 401 – 未认证，调用需要用户通过认证
 * 403 – 不允许的，服务端正常解析和请求，但是调用被回绝或者不被允许
 * 404 – 未找到，指定的资源不存在
 * 422 – 不可指定的请求体 – 只有服务器不能处理实体时使用，比如图像不能被格式化，或者重要字段丢失。
 * 500 – Internal Server Error – 标准服务端错误，API开发人员应该尽量避开这种错误
 *
 */
public enum ResultCode {
    SUCCESS(200),//成功，更新？
    CREATE_SUCCESS(201), //资源已经别创建
    DELETE_SUCCESS(204), //资源删除成功
    FAIL(400),//失败，调用不合法，参数无效，格式不正确
    UNAUTHORIZED(401),//未认证（签名错误）
    REFUSED(403),//服务器正常解析和请求，但是调用被回绝或不被允许，通常服务其活着
    NOT_FOUND(404),//接口不存在，服务器自己返回，通常不备程序所控制
    INTERNAL_SERVER_ERROR(500);//服务器内部错误

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
