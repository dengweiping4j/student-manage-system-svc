package com.wq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wq.entity.*;
import com.wq.mapper.SysMenuMapper;
import com.wq.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓卫平
 * @date 2021/12/19 14:29
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public PageResult<List<SysMenu>> findAll(SysMenu menu, PageParam pageParam) {
        QueryWrapper<SysMenu> query = new QueryWrapper<>();
        Page<SysMenu> page = PageHelper.startPage(pageParam);
        List<SysMenu> list = menuMapper.selectList(query);

        PageResult result = new PageResult();
        result.setTotalElements(page.getTotal());
        result.setContent(list);
        return result;
    }

    @Override
    public List<SysMenu> find(SysMenu menu) {
        return null;
    }

    @Override
    public SysMenu findById(String id) {
        return null;
    }

    @Override
    public void save(SysMenu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public void update(SysMenu menu) {
        menuMapper.updateById(menu);
    }

    @Override
    public void deleteById(String id) {
        menuMapper.deleteById(id);
    }
}
