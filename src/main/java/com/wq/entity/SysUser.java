package com.wq.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户实体类
 *
 * @author 邓卫平
 * @date 2021/12/19 12:08
 */
@Data
@TableName(value = "sys_user")
@ApiModel("系统用户实体类")
public class SysUser implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("账号")
    @NotBlank(message = "请输入【账号】")
    private String userName;

    @ApiModelProperty("密码（已加密）")
    @NotBlank(message = "请输入【密码】")
    private String password;

    @ApiModelProperty("角色ID")
    @NotBlank(message = "请选择【用户角色】")
    private String roleId;

    @ApiModelProperty("角色名")
    @TableField(exist = false)
    private String roleName;

    @ApiModelProperty("业务ID")
    private String bizId;

    @ApiModelProperty("删除标志 1已删除 0未删除")
    @TableLogic(value = Contants.DEL_FLAG_NO, delval = Contants.DEL_FLAG_YES)
    private String delFlag;

    @ApiModelProperty("创建人")
    private String crtBy;

    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date crtTime;

    @ApiModelProperty("修改人")
    private String updBy;

    @ApiModelProperty("修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updTime;
}
