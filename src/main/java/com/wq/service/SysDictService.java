package com.wq.service;

import com.wq.entity.*;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/18 21:33
 */
public interface SysDictService {
    PageResult<List<SysDict>> findAll(SysDict dict, PageParam pageParam);

    List<SysDict> find(SysDict dict);

    SysDict findById(String id);

    void save(SysDict dict);

    void update(SysDict dict);

    void deleteById(String id);
}
