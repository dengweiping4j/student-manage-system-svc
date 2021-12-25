package com.wq.service;

import com.wq.entity.SysDictInfo;
import com.wq.entity.SysRole;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/18 21:33
 */
public interface SysDictInfoService {

    List<SysDictInfo> find(SysDictInfo dictInfo);

    SysRole findById(String id);

    void save(SysDictInfo dictInfo);

    void update(SysDictInfo dictInfo);

    void deleteById(String id);
}
