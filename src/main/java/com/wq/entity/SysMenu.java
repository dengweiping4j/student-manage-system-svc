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
public class SysMenu {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("菜单路径")
    private String path;

    @ApiModelProperty("角色ID")
    private String roleId;
}
