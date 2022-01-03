package com.wq.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 邓卫平
 * @date 2022/01/02 15:06
 */
@Data
@TableName(value = "t_teacher")
@ApiModel("教师班级关联实体类")
public class TeacherClass implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("教师姓名")
    private String teaId;

    @ApiModelProperty("教师姓名")
    private String classId;
}
