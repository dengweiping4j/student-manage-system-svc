package com.wq.service;

import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.entity.SysRole;
import com.wq.entity.SysUser;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/18 21:33
 */
public interface SysRoleService {

    PageResult<List<SysRole>> findAll(SysRole role, PageParam pageParam);

    List<SysRole> find(SysRole role);

    SysRole findById(String id);

    void save(SysRole role);

    void update(SysRole role);

    void deleteById(String roleId);
}
