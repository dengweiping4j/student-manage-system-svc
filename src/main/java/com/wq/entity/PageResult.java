package com.wq.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/25 13:44
 */
@Data
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<T> content;

    private long totalElements;
}

