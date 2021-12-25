package com.wq.service;

import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.entity.SysMenu;
import com.wq.entity.SysRole;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/18 21:33
 */
public interface SysMenuService {

    PageResult<List<SysMenu>> findAll(SysMenu menu, PageParam pageParam);

    List<SysMenu> find(SysMenu menu);

    SysMenu findById(String id);

    void save(SysMenu menu);

    void update(SysMenu menu);

    void deleteById(String id);
}
