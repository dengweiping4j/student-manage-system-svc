package com.wq.service;

import com.wq.entity.PageParam;
import com.wq.entity.PageResult;
import com.wq.entity.SysUser;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/18 21:33
 */
public interface SysUserService {

    PageResult<List<SysUser>> findAll(SysUser user, PageParam pageParam);

    SysUser findById(String id);

    String login(SysUser user);

    void save(SysUser user);

    void update(SysUser user);

    void deleteById(String id);
}
