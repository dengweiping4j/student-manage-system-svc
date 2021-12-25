package com.wq.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 邓卫平
 * @date 2021/12/22 16:31
 */
@Data
public class PageParam implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String sort = "ID";

    @TableField(exist = false)
    private String order = "DESC";

    @TableField(exist = false)
    private int offset;

    @TableField(exist = false)
    private int limit = 10;

    @TableField(exist = false)
    private int pageNum = 1;

    @TableField(exist = false)
    private int pageSize = 10;

    @TableField(exist = false)
    private int page;

    @TableField(exist = false)
    private int rows = 10;

}
