package com.wq.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 邓卫平
 * @date 2021/12/19 12:08
 */
@Data
@ApiModel("用户角色实体类")
public class SysRole {

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("描述")
    private String remark;

    @ApiModelProperty("删除标志 1已删除 0未删除")
    private String delFlag;
}
