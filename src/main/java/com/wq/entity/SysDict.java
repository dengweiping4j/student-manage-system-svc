package com.wq.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统字典
 *
 * @author 邓卫平
 * @date 2021/12/19 12:08
 */
@Data
@TableName(value = "sys_dict_type")
@ApiModel("系统字典实体类")
public class SysDict implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("字典名称")
    private String typeName;

    @ApiModelProperty("字典类型")
    private String lookupType;

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

    @ApiModelProperty("描述")
    private String lookupDesc;

    @TableField(exist = false)
    private List<SysDictItem> dictItem;

    @ApiModelProperty("删除标志 1已删除 0未删除")
    @TableLogic(value = Contants.DEL_FLAG_NO, delval = Contants.DEL_FLAG_YES)
    private String delFlag;
}
