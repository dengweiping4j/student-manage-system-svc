package com.wq.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:响应返回类
 * @author: DengWeiPing
 * @time: 2020/6/5 11:37
 */
@Data
@ApiModel("响应实体类")
public class ResultBody<T> {

    @ApiModelProperty("状态码")
    private int code;

    @ApiModelProperty("返回信息")
    private String message;

    @ApiModelProperty("详细信息")
    private String detail;

    @ApiModelProperty("响应内容")
    private T data;

    public ResultBody(ResultCode resultCode) {
        this.code = resultCode.getResultCode();
        this.message = resultCode.getResultMsg();
    }

    /**
     * 返回正确结果
     *
     * @return
     */
    public static ResultBody success() {
        ResultBody result = new ResultBody(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 返回正确结果
     *
     * @param obj 返回数据
     * @return
     */
    public static ResultBody success(Object obj) {
        ResultBody result = new ResultBody(ResultCode.SUCCESS);
        result.setData(obj);
        return result;
    }

    /**
     * 返回错误结果
     *
     * @return
     */
    public static ResultBody error() {
        ResultBody result = new ResultBody(ResultCode.INTERNAL_SERVER_ERROR);
        return result;
    }

    /**
     * 返回错误结果
     *
     * @param message 错误信息
     * @return
     */
    public static ResultBody error(String message) {
        ResultBody result = new ResultBody(ResultCode.INTERNAL_SERVER_ERROR);
        result.setDetail(message);
        return result;
    }

    /**
     * 结果是否错误
     *
     * @return
     */
    public boolean errored() {
        if (this == null || this.getCode() == ResultCode.INTERNAL_SERVER_ERROR.getResultCode()) {
            return true;
        }
        return false;
    }

    /**
     * 结果是否成功
     *
     * @return
     */
    public boolean succeed() {
        if (this != null && this.getCode() == ResultCode.SUCCESS.getResultCode()) {
            return true;
        }
        return false;
    }

}
