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

/**
 * @author 邓卫平
 * @date 2022/01/02 12:08
 */
@Data
@TableName(value = "t_student")
@ApiModel("学生实体类")
public class StudentInfo implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("学生姓名")
    private String stuName;

    @ApiModelProperty("年级ID")
    private String gradeId;

    @ApiModelProperty("年级名称")
    @TableField(exist = false)
    private String gradeName;

    @ApiModelProperty("班级ID")
    private String classId;

    @ApiModelProperty("班级名称")
    @TableField(exist = false)
    private String claName;

    @ApiModelProperty("学号")
    private String stuCode;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("联系方式")
    private String tel;

    @ApiModelProperty("出生日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    @ApiModelProperty("证件照")
    private String profilePicture;

    @ApiModelProperty("删除标志 1已删除 0未删除")
    @TableLogic(value = Contants.DEL_FLAG_NO, delval = Contants.DEL_FLAG_YES)
    private String delFlag;
}
