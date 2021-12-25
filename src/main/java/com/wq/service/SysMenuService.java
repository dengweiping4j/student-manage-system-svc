package com.wq.service;

import com.wq.entity.SysRole;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/18 21:33
 */
public interface SysMenuService {

    List<SysRole> find(SysRole role);

    SysRole findById(String id);

    void save(SysRole role);

    void update(SysRole role);

    void deleteById(String roleId);
}
