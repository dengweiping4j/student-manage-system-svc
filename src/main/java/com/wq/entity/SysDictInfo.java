package com.wq.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统字典
 *
 * @author 邓卫平
 * @date 2021/12/19 12:08
 */
@Data
@ApiModel("系统字典实体类")
public class SysDictInfo {

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("字典名称")
    private String name;

    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("描述")
    private String remark;

    @ApiModelProperty("字典项名称")
    private String dictName;

    @ApiModelProperty("字典项值")
    private String dictValue;

    @ApiModelProperty("删除标志 1已删除 0未删除")
    private String delFlag;
}
