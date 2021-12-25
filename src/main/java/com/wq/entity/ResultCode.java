package com.wq.entity;

/**
 * @author 邓卫平
 * @date 2021/12/19 10:42
 */
public enum ResultCode {
    // 数据操作错误定义
    SUCCESS(200, "成功!"),
    BODY_NOT_MATCH(400, "请求的数据格式不符!"),
    SIGNATURE_NOT_TOKEN(401, "请先登录!"),
    SIGNATURE_NOT_MATCH(403, "您的令牌无效，请重新登录!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试!");

    /**
     * 错误码
     */
    private int resultCode;

    /**
     * 错误描述
     */
    private String resultMsg;

    ResultCode(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }
}
