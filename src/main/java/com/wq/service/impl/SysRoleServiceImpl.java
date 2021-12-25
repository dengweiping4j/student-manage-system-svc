package com.wq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wq.entity.*;
import com.wq.mapper.SysRoleMapper;
import com.wq.service.SysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/19 14:29
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public PageResult<List<SysRole>> findAll(SysRole role, PageParam pageParam) {
        QueryWrapper<SysRole> query = new QueryWrapper<>();
        Page<SysRole> page = PageHelper.startPage(pageParam);
        List<SysRole> list = roleMapper.selectList(query);

        PageResult result = new PageResult();
        result.setTotalElements(page.getTotal());
        result.setContent(list);
        return result;
    }

    @Override
    public List<SysRole> find(SysRole role) {
        QueryWrapper<SysRole> query = new QueryWrapper<>();
        List<SysRole> list = roleMapper.selectList(query);
        return list;
    }

    @Override
    public SysRole findById(String id) {
        SysRole role = roleMapper.selectById(id);
        return role;
    }

    @Override
    public void save(SysRole role) {
        roleMapper.insert(role);
    }

    @Override
    public void update(SysRole role) {
        roleMapper.updateById(role);
    }

    @Override
    public void deleteById(String roleId) {
        roleMapper.deleteById(roleId);
    }
}
